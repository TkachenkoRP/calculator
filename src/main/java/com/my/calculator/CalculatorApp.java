package com.my.calculator;

import com.my.io.ConsoleInputHandler;
import com.my.io.ConsoleOutputHandler;

public class CalculatorApp {

    public void start() {
        boolean working = true;
        double result;
        double currentValue = ConsoleInputHandler.getUserDoubleInput("Введите операнд: ");

        while (working) {
            Operation operation = getOperation();
            switch (operation) {
                case EXIT:
                    working = false;
                    ConsoleOutputHandler.displayMsg("Вы вышли из калькулятора.");
                    break;
                case RESET:
                    ConsoleOutputHandler.displayMsg("Результат сброшен.");
                    currentValue = ConsoleInputHandler.getUserDoubleInput("Введите операнд: ");
                    break;
                default:
                    double operand2 = ConsoleInputHandler.getUserDoubleInput("Введите операнд: ");
                    result = calc(currentValue, operand2, operation);
                    currentValue = result;
                    ConsoleOutputHandler.displayMsg("Результат: " + result);
                    break;
            }
        }
    }

    private double sum(double a, double b) {
        return a + b;
    }

    private double sub(double a, double b) {
        return a - b;
    }

    private double mul(double a, double b) {
        return a * b;
    }

    private double div(double a, double b) {
        if (b == 0) {
            ConsoleOutputHandler.displayMsg("Ошибка: деление на ноль!");
            return a;
        }
        return a / b;
    }

    private Operation getOperation() {
        while (true) {
            char operation = ConsoleInputHandler.getUserCharInput("Введите операцию (+, -, *, /, E - выход, R - сброс)");
            switch (operation) {
                case '+':
                    return Operation.SUM;
                case '-':
                    return Operation.MINUS;
                case '*':
                    return Operation.MUL;
                case '/':
                    return Operation.DIV;
                case 'E':
                case 'e':
                    return Operation.EXIT;
                case 'R':
                case 'r':
                    return Operation.RESET;
                default:
                    ConsoleOutputHandler.displayMsg("Неверное значение операции! Попробуйте ещё раз.\n");
            }
        }
    }

    private double calc(double a, double b, Operation op) {
        double result = switch (op) {
            case SUM -> sum(a, b);
            case MINUS -> sub(a, b);
            case MUL -> mul(a, b);
            case DIV -> div(a, b);
            default -> 0.0;
        };
        return result;
    }

    private enum Operation {
        SUM,
        MINUS,
        MUL,
        DIV,
        EXIT,
        RESET
    }
}
