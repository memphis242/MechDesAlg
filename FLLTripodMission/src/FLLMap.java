/**
 * This is a class meant to represent the FLL Map.
 * Currently, I am just including the robot, two obstacles, a tripod, and destination as MapObject's.
 * @author abdullah
 */
public class FLLMap {
    private MapObject obstacle1, obstacle2, tripodDestination;
    private AreaObject tripod, robot;
    private ConstantsConfiguration configuration;

    public FLLMap(MapObject obstacle1, MapObject obstacle2, MapObject tripodDestination, AreaObject tripod, ConstantsConfiguration configuration) {
        this.obstacle1 = obstacle1;
        this.obstacle2 = obstacle2;
        this.tripodDestination = tripodDestination;
        this.tripod = tripod;
        this.robot = robot;
        this.configuration = configuration;
    }
    
    
    
    public MapObject getObstacle1() {
        return obstacle1;
    }

    public void setObstacle1(MapObject obstacle1) {
        this.obstacle1 = obstacle1;
    }

    public MapObject getObstacle2() {
        return obstacle2;
    }

    public void setObstacle2(MapObject obstacle2) {
        this.obstacle2 = obstacle2;
    }

    public MapObject getTripodDestination() {
        return tripodDestination;
    }

    public void setTripodDestination(MapObject tripodDestination) {
        this.tripodDestination = tripodDestination;
    }

    public AreaObject getTripod() {
        return tripod;
    }

    public void setTripod(AreaObject tripod) {
        this.tripod = tripod;
    }

    public AreaObject getRobot() {
        return robot;
    }

    public void setRobot(AreaObject robot) {
        this.robot = robot;
    }

    public ConstantsConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ConstantsConfiguration configuration) {
        this.configuration = configuration;
    }
}
