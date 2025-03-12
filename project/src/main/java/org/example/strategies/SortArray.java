package org.example.strategies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortArray {
    int[] arr;
    boolean errorLoadingFile = false;
    private SortingStrategy sortingStrategy;
    public SortArray(String filePath) {
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            if (fileScanner.hasNextLine()) {
                String fileArray = fileScanner.nextLine()
                                    .replaceAll(",", " ")
                                    .trim()
                                    .replaceAll("\\s+", ",");
                if (fileArray.matches("^(-?\\d+)([ ,]+-?\\d+)*$")) {
                    String[] numbers = fileArray.split(",");
                    arr = new int[numbers.length];
                    for (int i = 0; i < numbers.length; i++)
                        arr[i] = Integer.parseInt(numbers[i]);
                }
                else  {
                    System.out.println("Invalid file formate");
                    errorLoadingFile = true;
                }
            }
            else {
                System.out.println("File is empty");
                errorLoadingFile = true;
            }
            fileScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }


    public boolean fileLoaded() {
        return !errorLoadingFile;
    }

    public void sort(boolean showSteps) {
        System.out.println("array: " + Arrays.toString(arr));
        long startTime = System.nanoTime();
        List<int[]> list = sortingStrategy.sort(arr.clone());
        long totalTime = (System.nanoTime() - startTime) / 1000;
        System.out.println("sorted Array: " + Arrays.toString(list.get(list.size()-1)));
        System.out.println("Time taken: " + Long.toString(totalTime) + "us");
        if (showSteps) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("step " + Integer.toString(i) + ": " + Arrays.toString(list.get(i)));
            }
        }
    }
}
