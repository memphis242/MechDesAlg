/**
 * This is a class meant to represent an object on the FLL map.
 * Currently, I am deciding to just include one defining point-position on the object to define the object.
 * @author abdullah
 */
public class MapObject {
    //private double X_POS_OF_TRIPOD_RELATIVE_TO_ROBOT, Y_POS_OF_TRIPOD_RELATIVE_TO_ROBOT, LENGTH_OF_TRIPOD, X_POS_OF_OBSTACLE_1, Y_POS_OF_OBSTACLE_
    private double x, y;
    
    public MapObject(){
        x = 0;
        y = 0;
    }
    
    
    
    public MapObject(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
