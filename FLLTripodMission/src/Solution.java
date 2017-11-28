/**
 *
 * @author abdullah
 */
public class Solution {
    private MapObject initialPosition;
    private double angle;
    
    public Solution(MapObject initialPosition, double angle){
        this.initialPosition = initialPosition;
        this.angle = angle;
    }
    
    
    
    public MapObject getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(MapObject initialPosition) {
        this.initialPosition = initialPosition;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    
    
    @Override
    public String toString(){
        String returnString = "";
        returnString += "(";
        returnString += "(" + initialPosition.getX() + ", " + initialPosition.getY() + ")";
        returnString += ", ";
        returnString += angle + ")";
        
        return returnString;
    }
}
