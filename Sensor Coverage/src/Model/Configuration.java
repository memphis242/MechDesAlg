package Model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author abdullah
 */
public class Configuration {
    
    public Configuration(){}
    
    private ArrayList<Sensor> sensors;  //NOTE THAT ORDER IS IMPORTANT
    private ArrayList<Point> xyIntersectionPoints;    //NOTE THAT ORDER IS IMPORTANT. INTERSECTIONPOINT 1 CORRESPONDS TO SENSORS 1 AND 2. AND SO ON.
    private ArrayList<Point> xzIntersectionPoints;
    private ArrayList<Point> yzIntersectionPoints;
    
    //Stuff for visualizing configuration
    private double ACCURACY;    //This represents the length of the side of a square in the print grid.
    private int GRID_SIZE_X, GRID_SIZE_Y;
    private String units;
    private double maxXLength, maxYLength;
    private String[][] xyGrid, xzGrid, yzGrid;
    
    /**
     * Sets the sensors in the sensors ArrayList
     * Returns number of sensors used.
     * @return 
     */
    public int configure(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("STARTING CONFIGURATION");
        System.out.print("\n\t What will be the units for your frame of reference? ");  //Note this is not really to be used by the program; more for the user to keep in mind.
        units = input.nextLine();
        System.out.print("\tWhat would you like to be the accuracy of grid? ");
        ACCURACY = input.nextDouble();
        System.out.print("What is the desired length of the x-grid? ");
        maxXLength = input.nextDouble();
        System.out.print("What is the desired length of the y-grid? ");
        maxYLength = input.nextDouble();
        GRID_SIZE_X = (int) (maxXLength / ACCURACY);
        GRID_SIZE_Y = (int) (maxYLength / ACCURACY);
        
        double hFoV, vFoV, x, y, z, yaw, pitch, roll;
        Point position;
        Orientation orientation;
        
        boolean more = false;
        int numberOfSensors = 1;
        
        do{
            System.out.println("\n");
            System.out.println("Data for Sensor " + numberOfSensors);
            System.out.print("Horizontal Field of View: ");
            hFoV = input.nextDouble();
            System.out.print("Vertical Field of View: ");
            vFoV = input.nextDouble();
            
            System.out.print("X-coordinate: ");
            x = input.nextDouble();
            System.out.print("Y-coordinate: ");
            y = input.nextDouble();
            System.out.print("Z-coordinate: ");
            z = input.nextDouble();
            position = new Point(x, y, z);
            
            System.out.print("Yaw: ");
            yaw = input.nextDouble();
            System.out.print("Pitch: ");
            pitch = input.nextDouble();
            System.out.print("Roll: ");
            roll = input.nextDouble();
            orientation = new Orientation(yaw, pitch, roll);
            
            sensors.add(new Sensor(hFoV, vFoV, position, orientation));
            
            System.out.print("\n\t\tAre there more (true or false)? ");
            more = input.nextBoolean();
        } while(more==true);
        
        return numberOfSensors;
    }
    
    
    
    //**************************************************
    public void calculateXYIntersectionPoints(){
        
    }
    
    //**************************************************
    public void calculateXZIntersectionPoints(){
        
    }
    
    //**************************************************
    public void calculateYZIntersectionPoints(){
        
    }
    
    //*************************************************
    //REMEMBER FRAME OF REFERENCE!
    private String[][] fillXYGrid(){
        xyGrid = new String[GRID_SIZE_X][GRID_SIZE_Y];   //BECAUSE IT'S A NEW GRID EACH TIME, CALLING THIS METHOD IS A RESET IN OF ITSELF
        
        //Initialize 2D Array
        for(int i=0; i<GRID_SIZE_X; i++){
            for(int j=0; j<GRID_SIZE_Y; j++){
                xyGrid[i][j] = "";
            }
        }
        
        return xyGrid;
    }
    
    private String[][] fillXZGrid(){
        xzGrid = new String[GRID_SIZE_X][GRID_SIZE_Y];   //BECAUSE IT'S A NEW GRID EACH TIME, CALLING THIS METHOD IS A RESET IN OF ITSELF
        
        //Initialize 2D Array
        for(int i=0; i<GRID_SIZE_X; i++){
            for(int j=0; j<GRID_SIZE_Y; j++){
                xzGrid[i][j] = "";
            }
        }
        
        return xzGrid;
    }
    
    private String[][] fillYZGrid(){
        yzGrid = new String[GRID_SIZE_X][GRID_SIZE_Y];   //BECAUSE IT'S A NEW GRID EACH TIME, CALLING THIS METHOD IS A RESET IN OF ITSELF
        
        //Initialize 2D Array
        for(int i=0; i<GRID_SIZE_X; i++){
            for(int j=0; j<GRID_SIZE_Y; j++){
                yzGrid[i][j] = "";
            }
        }
        
        return yzGrid;
    }
    
    
    
    
    public void printGrid(int[][] grid){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.format("%10d", grid[i][j]);
            }
            for(int k=0; k<4; k++){    //4 REPRESENTS THE VERTICAL SPACE BETWEEN NUMBERS
                System.out.println();
            }
        }
    }
}
