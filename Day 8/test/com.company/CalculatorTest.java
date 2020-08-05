package com.company;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {
    @Test
    public void sumTest(){
        Calculator calc = new Calculator();

        int value  = calc.sum(5,7).intValue();

        assertEquals(5+7, value);
    }

    @Test
    public void subTest(){
        Calculator calc = new Calculator();

        int value  = calc.sub(5,7).intValue();

        assertEquals(5-7, value);
    }

    @Test
    public void mulTest(){
        Calculator calc = new Calculator();

        int value  = calc.mul(5,7).intValue();

        assertEquals(5*7, value);
    }


    @Test
    public void divTest(){
        Calculator calc = new Calculator();

        double value  = calc.div(30,7).doubleValue();

        assertEquals(30d/7d, value);
    }
}
