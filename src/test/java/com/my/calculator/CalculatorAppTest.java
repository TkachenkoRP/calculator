package com.my.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorAppTest {
    private CalculatorApp calculatorApp;

    @BeforeEach
    void setUp() {
        calculatorApp = new CalculatorApp();
    }

    @Test
    void testSumOperation() {
        // Используем рефлексию для тестирования приватных методов
        double result = calculatorApp.calc(5.0, 3.0, CalculatorApp.Operation.SUM);
        assertEquals(8.0, result, 0.001);
    }

    @Test
    void testSubtractOperation() {
        double result = calculatorApp.calc(10.0, 4.0, CalculatorApp.Operation.MINUS);
        assertEquals(6.0, result, 0.001);
    }

    @Test
    void testMultiplyOperation() {
        double result = calculatorApp.calc(3.0, 4.0, CalculatorApp.Operation.MUL);
        assertEquals(12.0, result, 0.001);
    }

    @Test
    void testDivideOperation() {
        double result = calculatorApp.calc(15.0, 3.0, CalculatorApp.Operation.DIV);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    void testDivideByZero() {
        double result = calculatorApp.calc(10.0, 0.0, CalculatorApp.Operation.DIV);
        // Должен вернуть первое число при делении на ноль
        assertEquals(10.0, result, 0.001);
    }

    @Test
    void testFormatResultWithZero() {
        String formatted = calculatorApp.formatResult(0.0);
        assertEquals("0,00", formatted);
    }

    @Test
    void testFormatResultNegative() {
        String formatted = calculatorApp.formatResult(-123.456);
        assertEquals("-123,46", formatted);
    }
}
