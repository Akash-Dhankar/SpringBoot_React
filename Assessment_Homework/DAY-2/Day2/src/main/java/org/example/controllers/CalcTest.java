package org.example.controllers;

import org.example.controllers.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


public class CalcTest {

    Calculator calc = new Calculator();

    @org.testng.annotations.Test
    public void Add() {
        int x = 7;
        int y = 10;
        int z = calc.addition(x, y);
        assertEquals(17, z);
    }

    @Test
    public void Sub() {
        int x = 24;
        int y = 11;
        int z = calc.subtraction(x, y);
        assertEquals(13, z);
    }

    @Test
    public void Mul() {
        int x = 2;
        int y = 3;
        int z = calc.multiplication(x, y);
        assertEquals(6, z);
    }

    @Test
    public void Div() {
        int x = 16;
        int y = 4;
        int z = calc.division(x, y);
        assertEquals(4, z);
    }

    @Test
    public void testDivByZero() {
        int x = 10;
        int y = 0;
        int z = calc.division(x, y);
        assertEquals(0, z);
    }
}
