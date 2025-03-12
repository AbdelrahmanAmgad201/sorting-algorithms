package org.example.commandInterface;

import java.util.Scanner;

public class ArrayInputMenu implements State {
    String[] options = {"Write your array", "Enter path"};
    Scanner scanner;
    State nextState = null;
    String errorMsg;

    public ArrayInputMenu(Scanner scanner, String msg) {
        this.scanner = scanner;
        this.errorMsg = msg;
    }

    public void excute() {
        while (true) {
            System.out.print("\033[H\033[2J");
            if (!errorMsg.equals(""))
                System.out.println(ConsoleColors.RED + errorMsg + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "Array Input Menu" + ConsoleColors.RESET);
            printMenu(options);
            String input = scanner.nextLine();
            switch (checkBackOrExit(input)) {
                case 2:
                    System.exit(0);
            }
            switch (input.replaceAll("\\s+", "")) {
                case "1":
                    nextState = new ManualInputMenu(scanner);
                    return;
                case "2":
                    nextState = new EnterPathMenu(scanner);
                    return;
            }
            errorMsg = "Invalid Input";
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
