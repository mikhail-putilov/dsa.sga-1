package ru.innopolis.mputilov;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by mputilov on 16.09.16.
 */
public class ShellSorterTest {
    private List<Integer> testList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        testList.addAll(Arrays.asList(2, 17, 33, 78, 49, 26, 54, 80, 36, 32, 100, 41, 64, 93, 11, 95, 20, 97, 31, 27,
                53, 59, 40, 62, 88, 74, 98, 8, 5, 11, 75, 4, 10, 17, 62, 96, 10, 3, 30, 54, 34, 79, 46, 66, 66, 50, 38,
                89, 55, 60, 53, 84, 76, 92, 45, 67, 81, 71, 40, 28, 35, 8, 65, 81, 13, 79, 91, 98, 32, 40, 46, 37, 71,
                92, 48, 100, 43, 87, 92, 43, 83, 35, 84, 8, 78, 62, 9, 46, 43, 73, 36, 40, 10, 94, 86, 28, 63, 2, 12, 98));
    }

    @Test
    public void simple() throws Exception {
        ArrayList<Integer> copy = new ArrayList<>(testList);
        testList.sort(Integer::compare);
        new ShellSorter().shellSort(copy);
        assertArrayEquals(testList.toArray(), copy.toArray());
    }

    @Test
    public void simpleReverse() throws Exception {
        ArrayList<Integer> copy = new ArrayList<>(testList);

        testList.sort(Integer::compare);
        java.util.Collections.reverse(testList);
        Comparator<Integer> comparator = Integer::compareTo;
        new ShellSorter().sortSubListRespectingJumps(copy, 1, comparator.reversed());
        assertArrayEquals(testList.toArray(), copy.toArray());
    }

    @Test
    public void worstCaseScenario() throws Exception {
        ArrayList<Integer> copy = new ArrayList<>(testList);

        ShellSorter sorter = new ShellSorter();
        sorter.shellSort(testList);
        System.out.println(sorter.getCompareCounter());
        System.out.println(sorter.getSwapCounter());

        sorter.worstCaseShellSorting(copy, Integer::compareTo);
        sorter.resetCounters();
        sorter.shellSort(copy, Integer::compare);

        System.out.println(sorter.getCompareCounter());
        System.out.println(sorter.getSwapCounter());
    }
}