package org.example.strategies;

import java.util.ArrayList;
import java.util.List;

public class MergeSortStrategy implements SortingStrategy {
    @Override
    public List<int[]> sort(int[] array) {
        List<int[]> steps = new ArrayList<>();
        mergeSort(array, 0, array.length - 1, steps);
        return steps;
    }

    private void mergeSort(int[] arr, int left, int right, List<int[]> steps) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, steps);
            mergeSort(arr, mid + 1, right, steps);
            merge(arr, left, mid, right, steps);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, List<int[]> steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];

        steps.add(arr.clone());
    }
}
