package org.example.strategies;

import java.util.ArrayList;
import java.util.List;

public class QuickSortStrategy implements SortingStrategy {
    private List<int[]> steps; // Stores each step of the sorting process

    @Override
    public List<int[]> sort(int[] array) {
        steps = new ArrayList<>();
        quickSort(array, 0, array.length - 1);

        return steps;
    }

    void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    int partition(int[] array, int low, int high) {
        int pivot = array[high]; 
        int pivotIndex = low;

        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }

        swap(array, pivotIndex, high);
        
        // Store the current state of the array after partitioning
        steps.add(array.clone());

        return pivotIndex;
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
