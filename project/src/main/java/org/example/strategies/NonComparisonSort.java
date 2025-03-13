package org.example.strategies;

import org.example.strategies.NonComparisonSorters.CountingSortStrategy;
import org.example.strategies.NonComparisonSorters.RadixSortStrategy;
import java.util.List;

public class NonComparisonSort implements SortingStrategy {
    SortingStrategy sortMethod;

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
            if (sortMethod instanceof CountingSortStrategy) {
                ((CountingSortStrategy) sortMethod).setMaxMinValues(maxValue, minValue);
            } else {
                setSortingAlgorithm(new CountingSortStrategy(maxValue, minValue));
            }
            System.out.println("Chosen sorting strategy is COUNTING SORT method");
        } else {
            if (sortMethod instanceof RadixSortStrategy) {
                ((RadixSortStrategy) sortMethod).setMaxMinValues(maxValue, minValue);
            } else {
                setSortingAlgorithm(new RadixSortStrategy(maxValue, minValue));
            }
            System.out.println("Chosen sorting strategy is RADIX SORT method");
        }

        return sortMethod.sort(array);
    }

    void setSortingAlgorithm(SortingStrategy sort) {
        this.sortMethod = sort;
    }
}
