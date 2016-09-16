package ru.innopolis.mputilov;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mputilov on 16.09.16.
 */
public class MonteCarlo {
    public static final int NUMBER_OF_MONTE_CARLO_ITERATIONS = 1000000;

    public void processSimulation() {
        ShellSorter sorter = new ShellSorter();
        int maxSwaps = 0;
        List<Integer> maxSwapsList = new ArrayList<>();
        int maxCompares = 0;
        List<Integer> maxComparesList = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_MONTE_CARLO_ITERATIONS; i++) {
            sorter.resetCounters();
            List<Integer> randomList = getRandomList();
            List<Integer> originalRandomList = new ArrayList<>(randomList);
            sorter.shellSort(randomList);
            if (sorter.getCompareCounter() > maxCompares) {
                maxCompares = sorter.getCompareCounter();
                maxComparesList = new ArrayList<>(originalRandomList);
            }
            if (sorter.getSwapCounter() > maxSwaps) {
                maxSwaps = sorter.getSwapCounter();
                maxSwapsList = new ArrayList<>(originalRandomList);
            }
        }
        System.out.println("Максимальное количество операций swap:");
        System.out.println(maxSwaps);
        System.out.println("Список на котором оно достигается:");
        System.out.println(maxSwapsList);
        System.out.println("Максимальное количество операций .compareTo():");
        System.out.println(maxCompares);
        System.out.println("Список на котором оно достигается:");
        System.out.println(maxComparesList);
        System.out.println("Два списка выше одинаковы?");
        System.out.println(maxComparesList.equals(maxSwapsList));
    }

    private static List<Integer> getRandomList() {
        List<Integer> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        java.util.Collections.shuffle(list);
        return list;
    }
}
