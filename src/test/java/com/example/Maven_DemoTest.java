package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        // Verifies if 5 + 3 truly equals 8
        assertEquals(8, calc.add(5, 3), "5 + 3 should equal 8");
    }
}
