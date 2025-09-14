package com.my.io;

import java.util.Scanner;

public class ConsoleInputHandler {
    public static double getUserDoubleInput(String request) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleOutputHandler.displayMsg(request);
            String input = scanner.next().trim();
            input = input.replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                ConsoleOutputHandler.displayMsg("Неверное значение!\n");
            }
        }
    }

    public static char getUserCharInput(String request) {
        Scanner scanner = new Scanner(System.in);
        ConsoleOutputHandler.displayMsg(request);
        return scanner.next().charAt(0);
    }
}
