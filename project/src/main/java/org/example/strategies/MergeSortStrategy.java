package org.example.strategies;

import java.util.List;

public class MergeSortStrategy implements SortingStrategy {
    @Override
    public List<int[]> sort(int[] array) {
        // Implement Bubble Sort algorithm
        System.out.println("Sorting using Merge Sort");
        return List.of(array);
    }
}

