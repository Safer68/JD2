package Lesson2.Robots_team;

import java.util.HashSet;
import java.util.Set;

public class Robot {
    private final Set<PartsRobot> partsRobots = new HashSet<>();

    public boolean addPartRobots(PartsRobot part){
        return partsRobots.add(part);
    }

    public boolean isReadinessRobot() {
        return partsRobots.size() == PartsRobot.values().length;
    }

}
