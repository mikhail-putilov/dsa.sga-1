package ru.innopolis.mputilov;

import java.util.List;

import static java.util.Collections.swap;

/**
 * Created by mputilov on 16.09.16.
 */
public class Collections {
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
}
