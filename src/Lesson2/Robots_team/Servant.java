package Lesson2.Robots_team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Servant {

    private final List<PartsRobot> partsRobot = new ArrayList<>();

    public List<PartsRobot> getPartsRobot() {
        return partsRobot;
    }

    public void addParts(Competitions competitions){
        int number = new Random().nextInt(4) + 1;
        for(int i = 0; i<number; i++){
            PartsRobot parts = competitions.removePartsRobotDump();
            if(parts != null){
                partsRobot.add(parts);
            }
        }
    }

}
