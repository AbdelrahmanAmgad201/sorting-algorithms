package org.example.strategies;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortStrategy implements SortingStrategy {
    @Override
    public List<int[]> sort(int[] array) {
        List<int[]> steps = new ArrayList<>();
        steps.add(array.clone());
        BubbleSort(array, steps);
        return steps;
    }

    private void BubbleSort(int[] array, List<int[]> steps) {
        int sz = array.length;
        boolean swapped;

        for (int i = 0; i < sz - 1; i++) {
            swapped = false;
            for (int j = 0; j < sz - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            steps.add(array.clone());
            if (!swapped) {
                break;
            }
        }
    }
}
