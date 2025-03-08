package org.example;

import java.util.List;

public class Sort_Array {
    private int[] arr;

    public Sort_Array(String arrayPath) {
        // TO DO: Read the array from a file
        this.arr = readArrayFromFile(arrayPath);
    }

    public List<int[]> sorter(SortType sortType, boolean takeIntermediateSteps) {
        return switch (sortType) {
            case simple -> simpleSort();
            case efficient -> efficientSort();
            case nonComparative -> nonComparativeSort();
            default -> null;
        };
    }
    // example pseudo code for sorting algorithms
//    public List<int[]> bubbleSort(boolean intermediate) {
//        int[] arr = data.clone();
//        List<int[]> steps = new ArrayList<>();
//
//        // Sorting logic here...
//        // If intermediate is true, add snapshots of the array to steps
//
//        return intermediate ? steps : List.of(arr);
//    }

    private List<int[]> simpleSort(boolean takeIntermediateSteps) {
        // TO DO: implement any sorting technique in another function and call it here
        return arr; // eg return bubbleSort(takeIntermediateSteps);
    }
    private List<int[]> efficientSort(boolean takeIntermediateSteps) {
        // TO DO: implement any sorting technique in another function and call it here
        return new; // eg return mergeSort(takeIntermediateSteps);
    }
    private List<int[]> nonComparativeSort() {
        // TO DO: implement any sorting technique in another function and call it here
        return arr; // eg return radixSort(takeIntermediateSteps);
    }
    private int[] readArrayFromFile(String arrayPath) {
        // TO DO: Read the array from a file
    }

}
