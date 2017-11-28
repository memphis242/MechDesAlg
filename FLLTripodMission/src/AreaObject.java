/**
 * This is a class that inherits the MapObject class and defines an AreaObject
 * An AreaObject is one that has a defined point-position as well as length and width.
 * @author abdullah
 */
public class AreaObject extends MapObject {
    private double x, y, length, width;
    
    public AreaObject(double x, double y, double length, double width){
        super(x, y);
        this.length = length;
        this.width = width;
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
