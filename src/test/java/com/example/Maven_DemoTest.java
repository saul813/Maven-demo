package com.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Maven_DemoTest {

    @Test
    public void testMainMethodOutput() {
        // 1. Redirect System.out to capture the console print statement
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // 2. Execute the main method of your application
            Maven_Demo.main(new String[]{});

            // 3. Verify that the console output matches exactly what we expect
            // Note: System.out.println adds a platform-dependent line separator at the end
            String expectedOutput = "Hello, Maven!" + System.lineSeparator();
            assertEquals(expectedOutput, outputStream.toString());

        } finally {
            // 4. Always restore the original System.out stream
            System.setOut(originalOut);
        }
    }
}
