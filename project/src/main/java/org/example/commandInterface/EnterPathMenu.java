package org.example.commandInterface;

import java.io.File;
import java.util.Scanner;

public class EnterPathMenu implements State {
    Scanner scanner;
    State nextState;
    EnterPathMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void excute() {
        String errorMsg = "";
        while (true) {
            System.out.print("\033[H\033[2J");
            if (!errorMsg.equals(""))
                System.out.println(ConsoleColors.RED + errorMsg + ConsoleColors.RESET);
            
            System.out.println(ConsoleColors.BLUE + "Array Input Menu" + ConsoleColors.RESET);
            System.out.print("Enter file path: ");
            String input = scanner.nextLine().trim();
            switch (checkBackOrExit(input)) {
                case 1:
                    nextState = new ArrayInputMenu(scanner, "");
                    return;
                case 2:
                    System.exit(0);
            }

            File file = new File(input);
            if (!file.exists())
                errorMsg = "File doesn't exist";
            else if (!file.isFile())
                errorMsg = "Path entered is not for a file";
            else if (!input.endsWith(".txt"))
                errorMsg = "Invalid file type";
            else {
                nextState = new OperationMenu(scanner, input);
                return;
            }
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
