package org.example.strategies;

import java.util.List;

public class BubbleSortStrategy implements SortingStrategy {
    @Override
    public List<int[]> sort(int[] array) {
        // Implement Bubble Sort algorithm
        System.out.println("Sorting using Bubble Sort");
        return List.of(array);
    }
}

