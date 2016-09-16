package ru.innopolis.mputilov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by mputilov on 16.09.16.
 */
public class CollectionsTest {

    private List<Integer> testList = new ArrayList<>();

    @Test
    public void insertionSort1() throws Exception {
        testList.add(1);
        testList.add(2);
        testList.add(3);
        ru.innopolis.mputilov.Collections.insertionSort(testList);
        assertArrayEquals(new Integer[]{1, 2, 3}, testList.toArray());
    }

    @Test
    public void shellSort1() throws Exception {
        testList.add(1);
        testList.add(2);
        testList.add(3);
        ru.innopolis.mputilov.Collections.shellSort(testList);
        assertArrayEquals(new Integer[]{1, 2, 3}, testList.toArray());
    }

    @Test
    public void insertionSort2() throws Exception {
        testList.add(3);
        testList.add(1);
        testList.add(2);
        ru.innopolis.mputilov.Collections.insertionSort(testList);
        assertArrayEquals(new Integer[]{1, 2, 3}, testList.toArray());
    }

    @Test
    public void shellSort2() throws Exception {
        testList.add(3);
        testList.add(1);
        testList.add(2);
        ru.innopolis.mputilov.Collections.shellSort(testList);
        assertArrayEquals(new Integer[]{1, 2, 3}, testList.toArray());
    }

    @Test
    public void insertionSort3() throws Exception {
        ru.innopolis.mputilov.Collections.insertionSort(testList);
        assertArrayEquals(new Integer[]{}, testList.toArray());
    }

    @Test
    public void shellSort3() throws Exception {
        ru.innopolis.mputilov.Collections.shellSort(testList);
        assertArrayEquals(new Integer[]{}, testList.toArray());
    }

    @Test
    public void insertionSort4() throws Exception {
        testList.add(-5);
        ru.innopolis.mputilov.Collections.insertionSort(testList);
        assertArrayEquals(new Integer[]{-5}, testList.toArray());
    }

    @Test
    public void shellSort4() throws Exception {
        testList.add(-5);
        ru.innopolis.mputilov.Collections.shellSort(testList);
        assertArrayEquals(new Integer[]{-5}, testList.toArray());
    }

    @Test
    public void insertionSort5() throws Exception {
        testList.add(0);
        testList.add(-5);
        testList.add(0);
        testList.add(10);
        testList.add(11);
        testList.add(5);
        testList.add(-5);
        ru.innopolis.mputilov.Collections.insertionSort(testList);
        System.out.println(testList);
        assertArrayEquals(new Integer[]{-5, -5, 0, 0, 5, 10, 11}, testList.toArray());
    }

    @Test
    public void shellSort5() throws Exception {
        testList.add(0);
        testList.add(-5);
        testList.add(0);
        testList.add(10);
        testList.add(11);
        testList.add(5);
        testList.add(-5);
        ru.innopolis.mputilov.Collections.shellSort(testList);
        System.out.println(testList);
        assertArrayEquals(new Integer[]{-5, -5, 0, 0, 5, 10, 11}, testList.toArray());
    }

}