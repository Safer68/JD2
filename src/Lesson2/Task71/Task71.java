package Lesson2.Task71;

import Lesson2.Task70.Man;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Создайте класс с методов printHelloWorld(). Вызвать метод с помощью
 * рефлексии из основной программы.
 */
public class Task71 {
    private static final String NAME_METHOD = "printHelloWorld";

    public static void main(String[] args) {
        try {
            Method method = Man.class.getMethod(NAME_METHOD);
            method.setAccessible(true);
            method.invoke(new Man());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
