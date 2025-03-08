package org.example.strategies;

import java.util.List;

public class QuickSortStrategy implements SortingStrategy {
    @Override
    public List<int[]> sort(int[] array) {
        // Implement Quick Sort algorithm
        System.out.println("Sorting using Quick Sort");
        return List.of(array);
    }
}