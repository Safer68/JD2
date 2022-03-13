package Lesson2.Task70;

import Lesson2.Task72.AcademyInfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Создать класс Man c произвольным набором полей и методов (не менее 3) Создать метод,
 * который распечатает информацию о классе с помощью рефлексии. Вызвать метод с помощью рефлексии из основной программы.
 */
public class Task70 {
    private static final String NAME_METHOD = "printNameClass";

    public static void main(String[] args) {
        Class aClass = Man.class;
        printInfoClass(aClass);
        System.out.println("******************");
        executeMethodClass(aClass, NAME_METHOD);
    }

    public static void printInfoClass(Class aClass) {
        System.out.println("InfoClass " + aClass.getName() + ":");
        System.out.println("----------fields class----------");
        Field[] field = aClass.getDeclaredFields();
        Arrays.stream(field).forEach(field1 -> System.out.println(field1.getName()));
        System.out.println("----------methods class----------");
        Method[] methods = aClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> System.out.println(method.getName()));
    }
    public static void executeMethodClass(Class aClass, String nameName) {
        try {
            Method method = aClass.getDeclaredMethod(nameName);
            method.setAccessible(true);
            method.invoke(new Man());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
