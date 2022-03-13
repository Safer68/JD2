package Lesson2.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Двое безумных учёных устроили соревнование, кто из них соберёт больше роботов за 100 ночей.
 * Для этого каждую ночь каждый из них отправляет своего прислужника на свалку фабрики роботов за деталями.
 * Чтобы собрать одного робота им нужно:
 * Голова, Тело, Левая рука, Правая рука, Левая нога, Правая нога, CPU, RAM, HDD
 * В первую ночь на свалке находится 20 случайных деталей. Каждую ночь фабрика выбрасывает на свалку от 1 до 4 случайных деталей.
 * В то же самое время прислужники обоих учёных отправляются на свалку, и каждый собирает от 1 до 4 случайных деталей.
 * Если на свалке деталей нет – прислужник уходит ни с чем.
 * Затем они возвращаются домой и отдают детали хозяевам.
 * Учёные пытаются собрать как можно больше роботов из деталей, которые они получили.
 * Написать программу, симулирующую этот процесс. Для симуляции принять, что каждая ночь наступает через 100мс.
 * <p>
 * Фабрика и два прислужника действуют в одно и то же время.
 * После 100 ночей (около 10 секунд) определить победителя соревнования.
 */
public class Competitions {

    private final LinkedList<PartsRobot> dump = new LinkedList<>();
    Factory factory;
    Professor professor1;
    Professor professor2;

    {
        for (int i = 0; i < 200; i++) {
            dump.add(PartsRobot.values()[new Random().nextInt(PartsRobot.values().length)]);
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
        System.out.println("professor1: " + professor1.getNumberRobot());
        System.out.println("professor1: " + professor2.getNumberRobot());
    }

    public static void main(String[] args) {
        Competitions competitions = new Competitions(new Factory(), new Professor(), new Professor());
        competitions.start();
        competitions.result();
    }
}
