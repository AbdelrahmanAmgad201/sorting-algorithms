package org.example.commandInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManualInputMenu implements State {
    Scanner scanner;
    State nextState;
    String filePath;
    ManualInputMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void excute() {
        String errorMsg = "";
        String input;
        while (true) {
            System.out.print("\033[H\033[2J");
            if (!errorMsg.equals(""))
                System.out.println(ConsoleColors.RED + errorMsg + ConsoleColors.RESET);

            System.out.println(ConsoleColors.BLUE + "Array Input Menu" + ConsoleColors.RESET);
            System.out.println("Enter your array in a single line:");
            input = scanner.nextLine().trim();
            switch (checkBackOrExit(input)) {
                case 1:
                    nextState = new ArrayInputMenu(scanner, "");
                    return;
                case 2:
                    System.exit(0);
            }

            input = input.replaceAll(",", " ").replaceAll("\\s+", ",").trim();
            if (input.matches("^(-?\\d+)([ ,]+-?\\d+)*$"))
                break;
            errorMsg = "Invalid input: only numbers separated by , or/and space allowed";
        }

        String fileName = "1";
        errorMsg = "";
        while (!fileName.trim().matches("^[a-zA-Z_]+$")) {
            if (!errorMsg.equals(""))
                System.out.println(ConsoleColors.RED + errorMsg + ConsoleColors.RESET);
            System.out.println("Enter file name:");
            fileName = scanner.nextLine();
            errorMsg = "Invalid input: only letters and _ for name";
        }

        String filePath = "arrays/" + fileName.trim() + ".txt";
        File folder = new File("arrays");
        if (!folder.exists() && !folder.mkdirs()) {
            System.out.println("Failed to create folder: arrays");
            System.exit(2);
        }

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(input);
            writer.close();
            System.out.println("Successfully written to the file.");
        } 
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        nextState = new OperationMenu(scanner, filePath);
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
