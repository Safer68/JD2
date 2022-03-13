package Lesson2.Task;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private final List<Robot> robotList = new ArrayList<>();
    private final Servant servant = new Servant();

    public Servant getServant() {
        return servant;
    }

    public boolean createRobot() {
        List<PartsRobot> list = new ArrayList<>(servant.getPartsRobots());
        Robot robot = new Robot();
        for (PartsRobot partsRobot : list) {
            if (robot.addPartRobots(partsRobot)) {
                servant.getPartsRobots().remove(partsRobot);
            }
            if (robot.isReadinessRobot()) {
                return robotList.add(robot);
            }
        }
        return false;
    }

    public int getNumberRobot() {
        boolean b = true;
        while (b) {
            b = createRobot();
        }
        return robotList.size();
    }
}
