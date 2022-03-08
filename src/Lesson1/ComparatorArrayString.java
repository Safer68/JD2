package Lesson1;

import java.util.Comparator;

public class ComparatorArrayString implements Comparator<String[]> {

    @Override
    public int compare(String[] strings, String[] t1) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].compareTo(t1[i]) == 0 && i + 1 < strings.length) {
                int s = ++i;
                while (strings[s].compareTo(t1[s]) == 0) {
                    s = ++s;
                    return strings[s].compareTo(t1[s]);
                }
            } else return strings[i].compareTo(t1[i]);
        }
        return 0;
    }
}
