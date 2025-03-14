package org.example.strategies;

import org.example.strategies.NonComparisonSorters.CountingSortStrategy;
import org.example.strategies.NonComparisonSorters.RadixSortStrategy;
import java.util.List;

public class NonComparisonSort implements SortingStrategy {
    private static NonComparisonSort instance;
    private SortingStrategy sortMethod;

    private NonComparisonSort() {}

    public static NonComparisonSort getInstance() {
        if (instance == null) {
            synchronized (NonComparisonSort.class) {
                if (instance == null) {
                    instance = new NonComparisonSort();
                }
            }
        }
        return instance;
    }

    @Override
    public List<int[]> sort(int[] array) {
        if (array.length == 0) {
            long startTime = System.nanoTime();  // Start time measurement
            List<int[]> result = List.of(new int[0]);
            long endTime = System.nanoTime();    // End time measurement

            long elapsedTime = endTime - startTime;  // Compute elapsed time
            System.out.println("Non comparison sort took "+elapsedTime / 1_000_000.0 + " milliseconds");
            return result;
        }

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int number : array) {
            if (number > maxValue) {
                maxValue = number;
            }
            if (number < minValue) {
                minValue = number;
            }
        }

        int range = maxValue - minValue;
        if (range <= 10 * array.length) {
            if (!(sortMethod instanceof CountingSortStrategy)) {
                sortMethod = new CountingSortStrategy(maxValue, minValue);
            } else {
                ((CountingSortStrategy) sortMethod).setMaxMinValues(maxValue, minValue);
            }
            System.out.print("Counting sort without overhead took ");
        } else {
            if (!(sortMethod instanceof RadixSortStrategy)) {
                sortMethod = new RadixSortStrategy(maxValue, minValue);
            } else {
                ((RadixSortStrategy) sortMethod).setMaxMinValues(maxValue, minValue);
            }
            System.out.print("Radix sort without overhead took ");
        }

        long startTime = System.nanoTime();  // Start time measurement
        List<int[]> result = sortMethod.sort(array);
        long endTime = System.nanoTime();    // End time measurement

        long elapsedTime = endTime - startTime;  // Compute elapsed time
        System.out.println(elapsedTime / 1_000_000.0 + " milliseconds");


        return result;
    }
}
