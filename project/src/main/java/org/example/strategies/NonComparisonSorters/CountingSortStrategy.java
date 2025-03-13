package org.example.strategies.NonComparisonSorters;

import org.example.strategies.SortingStrategy;
import java.util.ArrayList;
import java.util.List;

public class CountingSortStrategy implements SortingStrategy, countingSort {
    private int maxValue;
    private int minValue;

    public CountingSortStrategy(int maxValue, int minValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public void setMaxMinValues(int maxValue, int minValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    @Override
    public List<int[]> sort(int[] array) {
        List<int[]> steps = new ArrayList<>();
        countingSort(array, steps);
        return steps;
    }

    private void countingSort(int[] arr, List<int[]> steps) {
        int n = arr.length;
        int range = maxValue - minValue + 1;
        int[] output = new int[n];
        int[] count = new int[range];

        for (int num : arr) {
            count[num - minValue]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int currentNumber = arr[i];
            output[count[currentNumber - minValue] - 1] = currentNumber;
            count[currentNumber - minValue]--;
            steps.add(output.clone()); // Store sorted step
        }

        System.arraycopy(output, 0, arr, 0, n);
        steps.add(arr.clone()); // Store sorted step
    }
}
