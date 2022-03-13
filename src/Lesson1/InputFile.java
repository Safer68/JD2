package Lesson1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFile {

    public static List<String[]> getArrayString(File file, String regex) {

        List<String[]> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                list.add(text.split(regex));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
