package Lesson2.Task;

import java.util.Random;

public class Factory {

    public void addDump(Competitions competitions) {

        int number = new Random().nextInt(4) + 1;
        for (int i = 0; i < number; i++) {
            competitions.addPartsRobotDump(PartsRobot.values()[new Random().nextInt(PartsRobot.values().length)]);
        }
    }
}
