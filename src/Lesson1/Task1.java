package Lesson1;

import java.io.File;
import java.util.List;

/**
 * Создайте java-приложение, которое будет считывать данные из источника (файл in.txt) и выполнять их сортировку. Данные имеют табличную структуру. Строки разделены переносом строки. Столбцы – знаком табуляции.
 * Данные необходимо отсортировать и вывести в файл out.txt.
 * Сортировка производится сначала по первой колонке строк, потом по второй (если строки или числа в первой колонке совпадают) и т.д.. Данные относящиеся к одной строке в гриде должны быть также в одной строке.
 * При этом: любое число в колонке выше любого не числа, числа отсортированы по возрастанию, строки в лексикографическом порядке.
 */

public class Task1 {

    public static void main(String[] args) {
        File input = new File("in.txt");
        File output = new File("out.txt");
        List<String[]> list = InputFile.getArrayString(input, "\\t");
        list.sort(new ComparatorArrayString());
        OutputFile.writeArrayString(output, list);

    }
}
