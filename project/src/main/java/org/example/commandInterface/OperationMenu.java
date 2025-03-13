package org.example.commandInterface;

import java.util.Scanner;

import org.example.strategies.*;
import org.example.strategies.NonComparisonSorters.RadixSortStrategy;

public class OperationMenu implements State {
    State nextState;
    Scanner scanner;
    String filePath;
    SortArray sortArray;
    String[] options = {"Simple Sort", "Efficient Sort (Merge Sort):", "Efficient Sort (Quick Sort):", "Non-Comparison Sort"};
    OperationMenu(Scanner scanner, String filePath) {
        this.scanner = scanner;
        this.filePath = filePath;
    }

    public void excute() {
        sortArray = new SortArray(filePath);
        if (!sortArray.fileLoaded()) {
            nextState = new ArrayInputMenu(scanner, "Failed to load file: " + filePath);
            return;
        }

        String errorMsg = "";
        while (true) {
            System.out.print("\033[H\033[2J");
            if (!errorMsg.equals(""))
                System.out.println(ConsoleColors.RED + errorMsg + ConsoleColors.RESET);

            System.out.println(ConsoleColors.BLUE + "Operations Menu" + ConsoleColors.RESET);
            printMenu(options);
            String input = scanner.nextLine().trim().replaceAll("\\s+", ",");
            String[] inputs = input.split(",");

            if ((inputs.length == 2 && !inputs[1].equals("&")) || inputs.length > 2) {
                errorMsg = "Invalid Input";
                continue;
            }
            
            boolean showSteps = false;
            if (inputs.length == 2)
                showSteps = true;
            
            switch (checkBackOrExit(inputs[0])) {
                case 1:
                    nextState = new ArrayInputMenu(scanner, "");
                    return;
                case 2:
                    System.exit(0);
            }
            switch (inputs[0]) {
                case "1":
                    sortArray.setSortingStrategy(new BubbleSortStrategy());
                    break;
                case "2":
                    sortArray.setSortingStrategy(new MergeSortStrategy());
                    break;
                case "3":
                    sortArray.setSortingStrategy(new QuickSortStrategy());
                    break;
                case "4":
                    sortArray.setSortingStrategy(new NonComparisonSort());
                    break;
                default:
                    errorMsg = "Invalid Input";
                    continue;
            }
            sortArray.sort(showSteps);
            System.out.print(ConsoleColors.YELLOW + "press enter to continue.." + ConsoleColors.RESET);
            scanner.nextLine();
            errorMsg = "";
        }
    }

    private void printMenu(String[] options) {
        for (int i = 0; i < options.length; i++){
            System.out.println((i+1) + " " + options[i]);
        }
    }

    private int checkBackOrExit(String s) {
        if (s.equalsIgnoreCase("back"))
            return 1;
        else if (s.equalsIgnoreCase("exit"))
            return 2;
        return 0;
    }

    public State nextState() {
        return nextState;
    }
}
