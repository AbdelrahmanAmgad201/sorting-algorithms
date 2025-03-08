package org.example;

import org.example.strategies.SortingStrategy;

import java.util.List;

public class Sort_Array {
    private final int[] arr;
    private SortingStrategy sortingStrategy; // Private to enforce encapsulation

    public Sort_Array(SortingStrategy sortingStrategy, String arrayPath) {
        this.sortingStrategy = sortingStrategy;
        this.arr = readArrayFromFile(arrayPath);
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public List<int[]> sort() {
        return sortingStrategy.sort(arr);
    }
    int[] readArrayFromFile(String arrayPath) {
        // TO DO: Implement the readArrayFromFile function
        return new int[0];
    }
}
