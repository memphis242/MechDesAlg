package Model;

/**
 *
 * @author abdullah
 */
public class Sensor {
    private double horizontalFoVAngle, verticalFoVAngle;    //Just by intuition at the moment, there can only be two planes that have an FoV angle.
    private double xyFoVAngle, xzFoVAngle, yzFoVAngle;
    private Point position;
    private Orientation orientation;
    
    public Sensor(double hFoV, double vFoV, Point position, Orientation orientation){
        horizontalFoVAngle = hFoV;
        verticalFoVAngle = vFoV;
        this.position = position;
        this.orientation = orientation;
        
        xyFoVAngle = calculatexyFoVAngle(hFoV, vFoV, position, orientation);
        xzFoVAngle = calculatexzFoVAngle(hFoV, vFoV, position, orientation);
        yzFoVAngle = calculateyzFoVAngle(hFoV, vFoV, position, orientation);
    }
    
    /**
     * 
     * @param horizontalFoVAngle
     * @param verticalFoVAngle
     * @param position
     * @param orientation
     * @return 
     */
    public double calculatexyFoVAngle(double horizontalFoVAngle, double verticalFoVAngle, Point position, Orientation orientation){
        double xzFoVAngle = 0;
        
        return xzFoVAngle;
    }
    
    /**
     * 
     * @param horizontalFoVAngle
     * @param verticalFoVAngle
     * @param position
     * @param orientation
     * @return 
     */
    public double calculatexzFoVAngle(double horizontalFoVAngle, double verticalFoVAngle, Point position, Orientation orientation){
        double xzFoVAngle = 0;
        
        return xzFoVAngle;
    }
    
    /**
     * 
     * @param horizontalFoVAngle
     * @param verticalFoVAngle
     * @param position
     * @param orientation
     * @return 
     */
    public double calculateyzFoVAngle(double horizontalFoVAngle, double verticalFoVAngle, Point position, Orientation orientation){
        double yzFoVAngle = 0;
        
        return yzFoVAngle;
    }
    
    
    
    public double getHorizontalFoVAngle() {
        return horizontalFoVAngle;
    }

    public void setHorizontalFoVAngle(double horizontalFoVAngle) {
        this.horizontalFoVAngle = horizontalFoVAngle;
    }

    public double getVerticalFoVAngle() {
        return verticalFoVAngle;
    }

    public void setVerticalFoVAngle(double verticalFoVAngle) {
        this.verticalFoVAngle = verticalFoVAngle;
    }

    public double getXyFoVAngle() {
        return xyFoVAngle;
    }

    public void setXyFoVAngle(double xyFoVAngle) {
        this.xyFoVAngle = xyFoVAngle;
    }

    public double getXzFoVAngle() {
        return xzFoVAngle;
    }

    public void setXzFoVAngle(double xzFoVAngle) {
        this.xzFoVAngle = xzFoVAngle;
    }

    public double getYzFoVAngle() {
        return yzFoVAngle;
    }

    public void setYzFoVAngle(double yzFoVAngle) {
        this.yzFoVAngle = yzFoVAngle;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    //Getter and setter methods
    public void setOrientation(Orientation orientation) {    
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sensor other = (Sensor) obj;
        if (Double.doubleToLongBits(this.horizontalFoVAngle) != Double.doubleToLongBits(other.horizontalFoVAngle)) {
            return false;
        }
        if (Double.doubleToLongBits(this.verticalFoVAngle) != Double.doubleToLongBits(other.verticalFoVAngle)) {
            return false;
        }
        if (!this.position.equals(other.position)) {
            return false;
        }
        if (!this.orientation.equals(other.orientation)) {
            return false;
        }
        return true;
    }
}
