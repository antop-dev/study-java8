package ch03.ex07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        shuffle:
        while (true) {
            // shuffle
            Collections.shuffle(strings);
            // validate
            validate:
            {
                for (int i = 1; i < strings.size(); i++) {
                    String s1 = strings.get(i - 1);
                    String s2 = strings.get(i);

                    if (comp.compare(s1, s2) > 0) {
                        // s1과 s2가 오름차순이 되지 않았으면 false
                        break validate;
                    }

                }

                break shuffle;
            }

        }
    }

}
