package org.example.strategies.NonComparisonSorters;
import org.example.strategies.SortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RadixSortStrategy implements SortingStrategy, radixSort{
    private int maxValue;
    private int minValue;


    public RadixSortStrategy(int maxValue, int minValue) {
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
        if (minValue <0) {
            radixSortWithNegatives(array, steps);
        }else {
            radixSort(array, steps);
        }
        return steps;
    }

    private void radixSortWithNegatives(int[] arr, List<int[]> steps) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();

        for (int num : arr) {
            if (num < 0) {
                negatives.add(-num); // Convert to positive for sorting
            } else {
                positives.add(num);
            }
        }

        int[] posArray = positives.stream().mapToInt(Integer::intValue).toArray();
        int[] negArray = negatives.stream().mapToInt(Integer::intValue).toArray();

        if (posArray.length > 0) radixSort(posArray, steps);
        if (negArray.length > 0) radixSort(negArray, steps);

        int[] sortedNegArray = new int[negArray.length];
        for (int i = 0; i < negArray.length; i++) {
            sortedNegArray[i] = -negArray[negArray.length - i - 1];
        }


        System.arraycopy(sortedNegArray, 0, arr, 0, sortedNegArray.length);
        System.arraycopy(posArray, 0, arr, sortedNegArray.length, posArray.length);
        steps.add(arr.clone());
    }

    private void radixSort(int[] arr, List<int[]> steps) {
        int max = getMax();
        int exp = 1;

        while (max / exp > 0) {
            countingSort(arr, exp);
            steps.add(arr.clone());
            exp *= 10;
        }
    }

    private void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int num : arr) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    private int getMax() {
        return maxValue;
    }
}
