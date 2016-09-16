package ru.innopolis.mputilov;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

/**
 * Created by mputilov on 16.09.16.
 */
public class Collections {
    private static final List<Integer> SHELL_SORT_JUMP_CONSTANTS = Arrays.asList(40, 13, 4, 1);

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        if (list.size() <= 1) {
            return;
        }
        for (int leftSortedSide = 1; leftSortedSide < list.size(); leftSortedSide++) {
            T insertThis = list.get(leftSortedSide);
            for (int current = leftSortedSide - 1; current >= 0; current--) {
                T maybeGoRight = list.get(current);
                if (insertThis.compareTo(maybeGoRight) < 0) {
                    swap(list, current + 1, current);
                } else {
                    break;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void shellSort(List<T> list) {
        if (list.size() <= 1) {
            return;
        }
        for (Integer jump : SHELL_SORT_JUMP_CONSTANTS) {
            for (int firstUnsortedFromLeft = 1; firstUnsortedFromLeft < list.size(); firstUnsortedFromLeft += jump) {
                T insertThis = list.get(firstUnsortedFromLeft);
                //find place where to insert:
                for (int current = firstUnsortedFromLeft - jump; current >= 0; current -= jump) {
                    T maybeGoRight = list.get(current);
                    if (insertThis.compareTo(maybeGoRight) < 0) {
                        swap(list, current + jump, current);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
