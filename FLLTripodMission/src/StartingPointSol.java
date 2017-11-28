/**
 * This is the class that will print out all the solutions based on the set of inputs the user gives that
 * set the configuration of certain parameters of the problem environment.
 * @author abdullah
 */

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class StartingPointSol {
    private static final double ACCURACY_OF_POSITIONING = 1, ACCURACY_OF_ANGLING = 0.5, RADIUS_OF_BASE = 56;
    private static final int NUMBER_OF_POSSIBLE_POSITIONS = (int) ((Math.PI * Math.pow(RADIUS_OF_BASE, 2)) / ACCURACY_OF_POSITIONING);
    
    public static void main(String[] args){
        //Variables
        
        double LR, WR, PO1X, PO1Y, PO2X, PO2Y, PFX, PFY, LT;//These are meant to be CONSTANT.
                                                            //LR = length of square containing robot and defining point of tripod
                                                            //WR = width of square containing robot and defining point of tripod
                                                            //PO1X = x position of obstacle 1
                                                            //PO1Y = y position of obstacle 1
                                                            //PO2X = x position of obstacle 2
                                                            //PO2Y = y position of obstacle 2
                                                            //PFX = x position of destination
                                                            //PFY = y position of destination
                                                            //LT = maximum length of tripod

        MapObject initialPositionOfTripod;
        double angle;
        Solution chosenSolution;
                                                            //These are the variables we are attempting to determine.
                                                            //angle is initial angle of robot relative to horizontal axis of map
                                                            //initialPositionOfTripod is the MapObject representing where the tripod starts
                                                            //chosenSolution is the object to hold both the MapObject and the angle
        
        //Setting the constants.
        Scanner input = new Scanner(System.in);
        System.out.print("Length of Square Containg Robot and Tripod Point: ");
        LR = input.nextDouble();
        System.out.println();
        System.out.print("Width of Square Containing Robot and Tripod Point: : ");
        WR = input.nextDouble();
        System.out.println();
        System.out.print("X-Position of Obstacle 1: ");
        PO1X = input.nextDouble();
        System.out.println();
        System.out.print("Y-Position of Obstacle 1: ");
        PO1Y = input.nextDouble();
        System.out.println();
        System.out.print("X-Position of Obstacle 2: ");
        PO2X = input.nextDouble();
        System.out.println();
        System.out.print("Y-Position of Obstacle 2: ");
        PO2Y = input.nextDouble();
        System.out.println();
        System.out.print("X-Position of Tripod Destination: ");
        PFX = input.nextDouble();
        System.out.println();
        System.out.print("Y-Position of Tripod Destination: ");
        PFY = input.nextDouble();
        System.out.println();
        System.out.print("Maximum Length of Tripod (from center of robot to opposite end of Tripod): ");
        LT = input.nextDouble();
        System.out.println();
        System.out.println("\n\n");
        
        //Initializing FLLMap object using constant values.
        MapObject obstacle1 = new MapObject(PO1X, PO1Y);
        MapObject obstacle2 = new MapObject(PO2X, PO2Y);
        MapObject tripodDestination = new MapObject(PFX, PFY);
        initialPositionOfTripod = new MapObject();
        AreaObject tripod = new AreaObject(initialPositionOfTripod.getX(), initialPositionOfTripod.getY(), LR, WR);
        ConstantsConfiguration configuration = new ConstantsConfiguration(LR, WR, PO1X, PO1Y, PO2X, PO2Y, PFX, PFY, LT);
        FLLMap map = new FLLMap(obstacle1, obstacle2, tripodDestination, tripod, configuration);
        
        //Configuring solution variables
        ArrayList<MapObject> possiblePositions = fillPossibilePositions();
        double minAngle = Math.atan((PFY - RADIUS_OF_BASE) / PFX);
        double maxAngle = Math.atan(PFY / (PFX - RADIUS_OF_BASE));
        ArrayList<Double> possibleAngles = fillPossibleAngles(minAngle, maxAngle);
        ArrayList<MapObject> domain = fillPossibleInitialPositions(possiblePositions, WR, LR, possibleAngles);
        
        //Initiate domain test and obtain all solutions
        ArrayList<Solution> solutions = findSolutions(domain, configuration);
        
        printSolutions(solutions);
    }
    
    
    
    private static ArrayList<MapObject> fillPossibilePositions(){
        ArrayList<MapObject> possiblePositions = new ArrayList<>(NUMBER_OF_POSSIBLE_POSITIONS);
        int i=0;
        for(int x=0; x<RADIUS_OF_BASE; x += (int) ACCURACY_OF_POSITIONING){
            for(int y=0; y<RADIUS_OF_BASE; y += (int) ACCURACY_OF_POSITIONING){
                possiblePositions.add(new MapObject(x, y));
            }
        }
        
        return possiblePositions;
    }
    
    private static ArrayList<Double> fillPossibleAngles(double minAngle, double maxAngle){
        ArrayList<Double> possibleAngles = new ArrayList<>((int) ((maxAngle - minAngle) / ACCURACY_OF_ANGLING));
        for(double theta=minAngle; theta<maxAngle; theta += ACCURACY_OF_ANGLING){
            possibleAngles.add(theta);
        }
        
        return possibleAngles;
    }
    
    private static ArrayList<MapObject> fillPossibleInitialPositions(ArrayList<MapObject> possiblePositions, double WR, double LR, ArrayList<Double> possibleAngles){
        ArrayList<MapObject> possibleInitialPositions = new ArrayList<>(possiblePositions.size() * possibleAngles.size());
        
        for(MapObject pos : possiblePositions){
            for(Double angle : possibleAngles){
                double x = pos.getX() + (Math.hypot(WR, (LR/2)) * Math.sin(angle + Math.atan(LR/(2 * WR))));
                double y = pos.getY() + (Math.hypot(WR, (LR/2)) * Math.cos(angle + Math.atan(LR/(2 * WR))));
                possibleInitialPositions.add(new MapObject(x, y));
            }
        }
        
        return possibleInitialPositions;
    }
    
    
    
    private static ArrayList<Solution> findSolutions(ArrayList<MapObject> domain, ConstantsConfiguration configuration){
        ArrayList<Solution> solutions = new ArrayList<>(domain.size());
        
        for(MapObject initialPos : domain){
            if(checkObstacleAvoidance(initialPos, configuration)){
                double angle = Math.atan((configuration.getPFY() - initialPos.getY()) / (configuration.getPFX() - initialPos.getX()));
                solutions.add(new Solution(initialPos, Math.toDegrees(angle)));
            }
        }
        
        solutions.trimToSize();
        
        return solutions;
    }
    
    private static boolean checkObstacleAvoidance(MapObject mo, ConstantsConfiguration configuration){
        if(checkObstacleAvoidance1(mo, configuration) && checkObstacleAvoidance2(mo, configuration)) return true;
        return false;
    }
    
    private static boolean checkObstacleAvoidance1(MapObject mo, ConstantsConfiguration configuration){
        double distanceToObstacle1 = (Math.abs(((configuration.getPFY() - mo.getY()) * configuration.getPO1X()) - ((configuration.getPFX() - mo.getX()) * configuration.getPO1Y()) + ((configuration.getPFX() * mo.getY()) - (configuration.getPFY() * mo.getX())) )) / (Math.hypot((configuration.getPFY() - mo.getY()), (configuration.getPFX() - mo.getX())));
        if(distanceToObstacle1 < configuration.getLR()) return true;
        return false;
    }
    
    private static boolean checkObstacleAvoidance2(MapObject mo, ConstantsConfiguration configuration){
        double distanceToObstacle1 = (Math.abs(((configuration.getPFY() - mo.getY()) * configuration.getPO2X()) - ((configuration.getPFX() - mo.getX()) * configuration.getPO2Y()) + ((configuration.getPFX() * mo.getY()) - (configuration.getPFY() * mo.getX())) )) / (Math.hypot((configuration.getPFY() - mo.getY()), (configuration.getPFX() - mo.getX())));
        if(distanceToObstacle1 < configuration.getLR()) return true;
        return false;
    }
    
    
    
    private static void printSolutions(ArrayList<Solution> solutions){
        System.out.println("Solutions:");
        for(Solution sol : solutions){
            System.out.print(sol);
            
            System.out.print(", \t");
        }
    }
}
