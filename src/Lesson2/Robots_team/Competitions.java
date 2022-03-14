package Lesson2.Robots_team;

import java.util.LinkedList;
import java.util.Random;

public class Competitions {
    private final LinkedList<PartsRobot> dump = new LinkedList<>();
    Factory factory;
    Professor professor1;
    Professor professor2;

    {
        for (int i = 0; i < 200; i++) {
            dump.add(PartsRobot.values()[
                    new Random().nextInt(PartsRobot.values().length)
                    ]);
        }
    }

    public Competitions(Factory factory, Professor professor1, Professor professor2) {
        this.factory = factory;
        this.professor1 = professor1;
        this.professor2 = professor2;
    }

    public synchronized void addPartsRobotDump(PartsRobot partsRobot) {
        dump.add(partsRobot);
    }

    public synchronized PartsRobot removePartsRobotDump() {
        return dump.pollLast();
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> professor1.getServant().addParts(this)).start();
            new Thread(() -> professor2.getServant().addParts(this)).start();
            new Thread(() -> factory.addDump(this)).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void result() {
        System.out.println("professor1:" + professor1.getNumberRobot());
        System.out.println("professor2 " + professor2.getNumberRobot());
    }

    public static void main(String[] args) {
        Competitions competitions = new Competitions(new Factory(),
                    new Professor(), new Professor());
        competitions.start();
        competitions.result();
    }
}
