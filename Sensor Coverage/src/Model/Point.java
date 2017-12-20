package Model;

import java.lang.Math;

/**
 * The frame of reference used here is the following:
    * Units will be given by user in the Configuration class.
    * Origin is placed at the center of the robot relative to its horizontal plane, and at the lowest point of the main body (e.g., for a car, this would be on the ground centered between all the wheels)
    * Positive axes:
        * z-axis pointing directly upwards and perpandicular to the plane of the robot, (e.g., so a car on the ground, pointing up at the sky from the origin)
        * y-axis pointing directly to the front of the vehicle (e.g., for a car, pointing forwards towards front bumpers)
        * x-axis point directly left of the robot (e.g., for a car, pointing to the left of the car)
    * Note that this is a right-handed frame of reference, hence the reasoning for the positive axes.
 * @author abdullah
 */
public class Point {
    private double x, y, z, xyRadius, xyTheta, xzRadius, xzTheta, yzRadius, yzTheta;
    
    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        xyRadius = Math.hypot(x, y);
        xyTheta = Math.toDegrees(Math.atan2(y, x));   //Note that theta is in degrees for easier visualization but Math class works with radians!
        xzRadius = Math.hypot(x, z);
        xzTheta = Math.toDegrees(Math.atan2(z, x));
        yzRadius = Math.hypot(y, z);
        yzTheta = Math.toDegrees(Math.atan2(z, y));
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getXyRadius() {
        return xyRadius;
    }

    public void setXyRadius(double xyRadius) {
        this.xyRadius = xyRadius;
    }

    public double getXyTheta() {
        return xyTheta;
    }

    public void setXyTheta(double xyTheta) {
        this.xyTheta = xyTheta;
    }

    public double getXzRadius() {
        return xzRadius;
    }

    public void setXzRadius(double xzRadius) {
        this.xzRadius = xzRadius;
    }

    public double getXzTheta() {
        return xzTheta;
    }

    public void setXzTheta(double xzTheta) {
        this.xzTheta = xzTheta;
    }

    public double getYzRadius() {
        return yzRadius;
    }

    public void setYzRadius(double yzRadius) {
        this.yzRadius = yzRadius;
    }

    public double getYzTheta() {
        return yzTheta;
    }

    public void setYzTheta(double yzTheta) {
        this.yzTheta = yzTheta;
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
        final Point other = (Point) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        
        return true;
    }
    
    
    
}
