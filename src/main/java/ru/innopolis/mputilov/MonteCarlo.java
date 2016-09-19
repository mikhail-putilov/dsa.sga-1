package ru.innopolis.mputilov;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mputilov on 16.09.16.
 */
public class MonteCarlo {
    public static final int NUMBER_OF_MONTE_CARLO_ITERATIONS = 100000;
    private int counter = 1;
    private Random rnd = new Random(java.time.Instant.now().toEpochMilli());

    private List<Integer> getRandomList() {
        List<Integer> list = new ArrayList<>(100);
        double v = counter++ * Math.PI;
        double step = v / 100.0;

        int maxNumberOfMultiplications = rnd.nextInt(3) + 1;
        int maxBound = 1;

        for (int i = 0; i < maxNumberOfMultiplications; i++) {
            maxBound *= 10;
        }

        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.tan(step * i) * 1000) + Math.abs(rnd.nextInt(maxBound)));
        }
        return list;
    }

    public void processSimulation() {
        System.out.println("Monte carlo simulation started...");
        System.out.format("Number of iterations: %d\n\n", NUMBER_OF_MONTE_CARLO_ITERATIONS);
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
        System.out.print("\n\n");
        System.out.println("Максимальное количество операций .compareTo():");
        System.out.println(maxCompares);
        System.out.println("Список на котором оно достигается:");
        System.out.println(maxComparesList);
        System.out.println();
        System.out.println("Два списка выше одинаковы?");
        System.out.println(maxComparesList.equals(maxSwapsList));
    }
}
