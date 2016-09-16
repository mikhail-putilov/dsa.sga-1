package ru.innopolis.mputilov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.swap;

/**
 * Created by mputilov on 16.09.16.
 */
public class ShellSorter {
    private static final List<Integer> SHELL_SORT_JUMP_CONSTANTS = Arrays.asList(40, 13, 4, 1);
    private int compareCounter = 0;
    private int swapCounter = 0;

    public void resetCounters() {
        compareCounter = 0;
        swapCounter = 0;
    }

    public int getCompareCounter() {
        return compareCounter;
    }

    public int getSwapCounter() {
        return swapCounter;
    }

    public <T extends Comparable<T>> void shellSort(List<T> list) {
        if (list.size() <= 1) {
            return;
        }
        for (Integer jump : SHELL_SORT_JUMP_CONSTANTS) {
            for (int firstUnsortedFromLeft = 1; firstUnsortedFromLeft < list.size(); firstUnsortedFromLeft++) {
                T insertThis = list.get(firstUnsortedFromLeft);
                //find place where to insert:
                for (int current = firstUnsortedFromLeft - jump; current >= 0; current -= jump) {
                    T maybeGoRight = list.get(current);
                    compareCounter++;
                    if (insertThis.compareTo(maybeGoRight) < 0) {
                        swapCounter++;
                        swap(list, current + jump, current);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public <T> void shellSort(List<T> list, Comparator<T> comparator) {
        if (list.size() <= 1) {
            return;
        }
        for (Integer jump : SHELL_SORT_JUMP_CONSTANTS) {
            sortSubListRespectingJumps(list, jump, comparator);
        }
    }

    public <T> void worstCaseShellSorting(List<T> list, Comparator<T> comparator) {
        sortSubListRespectingJumps(list, SHELL_SORT_JUMP_CONSTANTS.get(3), comparator.reversed());
        sortSubListRespectingJumps(list, SHELL_SORT_JUMP_CONSTANTS.get(2), comparator.reversed());
        sortSubListRespectingJumps(list, SHELL_SORT_JUMP_CONSTANTS.get(1), comparator.reversed());
        sortSubListRespectingJumps(list, SHELL_SORT_JUMP_CONSTANTS.get(0), comparator.reversed());
    }

    <T> void sortSubListRespectingJumps(List<T> list, int jump, Comparator<T> comparator) {
        for (int firstUnsortedFromLeft = 1; firstUnsortedFromLeft < list.size(); firstUnsortedFromLeft++) {
            T insertThis = list.get(firstUnsortedFromLeft);
            //find place where to insert:
            for (int current = firstUnsortedFromLeft - jump; current >= 0; current -= jump) {
                T maybeGoRight = list.get(current);
                compareCounter++;
                if (comparator.compare(insertThis, maybeGoRight) < 0) {
                    swapCounter++;
                    swap(list, current + jump, current);
                } else {
                    break;
                }
            }
        }
    }

}
