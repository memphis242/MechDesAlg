package Model;

/**
 *
 * @author abdullah
 */
public class Orientation {
    private double yaw, pitch, roll;

    public Orientation(double yaw, double pitch, double roll) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
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
        final Orientation other = (Orientation) obj;
        if (Double.doubleToLongBits(this.yaw) != Double.doubleToLongBits(other.yaw)) {
            return false;
        }
        if (Double.doubleToLongBits(this.pitch) != Double.doubleToLongBits(other.pitch)) {
            return false;
        }
        if (Double.doubleToLongBits(this.roll) != Double.doubleToLongBits(other.roll)) {
            return false;
        }
        return true;
    }
}
