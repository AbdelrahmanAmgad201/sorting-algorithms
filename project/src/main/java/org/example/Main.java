package org.example;

import org.example.commandInterface.State;
import org.example.commandInterface.ArrayInputMenu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        State state = new ArrayInputMenu(scanner, "");
        while (true && state != null) {
            state.excute();
            state = state.nextState();
        }
        System.out.println("Error: entered null state");
    }
}