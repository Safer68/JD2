package Lesson2.Task72;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Создать собственную аннотацию @AcademyInfo c полем year. Создать метод,
 * помеченный этой анотацией с заданным year и метод без нее.
 * С помощью рефлексии проверить наличие данной аннотации у этих методов из основной программы.
 */
public class Task72 {
    public static final Class CLASS = Task72.class;
    public static final Class ANNOTATION = AcademyInfo.class;

    private void yearNoAnnotation() {

    }

    @AcademyInfo(year = "year")
    private static void yearYesAnnotation() {

    }

    public static void main(String[] args) {
        searchMethodAnnotation(ANNOTATION, CLASS);
    }

    private static void searchMethodAnnotation(Class annotation, Class aClass) {
        Method[] methods = aClass.getDeclaredMethods();
        for (Method f : methods) {
            Annotation[] annotations = f.getDeclaredAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().equals(annotation)) {
                    System.out.println("@" + a.annotationType().getName());
                    System.out.println(f.getName());
                } else System.out.println("No");
            }
        }
    }
}
