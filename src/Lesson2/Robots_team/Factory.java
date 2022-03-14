package Lesson2.Robots_team;


import java.util.Random;

public class Factory {

    public void addDump(Competitions competions) {
        int random = new Random().nextInt(4) + 1;
        for (int i = 0; i < random; i++) {
            competions.addPartsRobotDump(
                    PartsRobot.values()[
                            new Random().nextInt(PartsRobot.values().length)
                            ]);

        }
    }
}
