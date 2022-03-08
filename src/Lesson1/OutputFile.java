package Lesson1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFile {

    public static void writeArrayString(File file, List<String[]> strings) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String[] s : strings) {
                for (String s1 : s) {
                    bufferedWriter.write(s1 + "\t");
                }
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
