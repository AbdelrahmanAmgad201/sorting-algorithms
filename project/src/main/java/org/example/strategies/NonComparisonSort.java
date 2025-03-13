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
            System.out.println("Chosen sorting strategy is COUNTING SORT method");
        } else {
            if (!(sortMethod instanceof RadixSortStrategy)) {
                sortMethod = new RadixSortStrategy(maxValue, minValue);
            } else {
                ((RadixSortStrategy) sortMethod).setMaxMinValues(maxValue, minValue);
            }
            System.out.println("Chosen sorting strategy is RADIX SORT method");
        }

        return sortMethod.sort(array);
    }
}
