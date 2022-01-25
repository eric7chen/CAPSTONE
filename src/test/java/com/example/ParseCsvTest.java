package com.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParseCsvTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void teardown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testMain() {
        String[] args = {"English-Grid view.csv"};
        ParseCsv.main(args);
    }

    @Test
    public void testNoArgs() {
        String[] args = {};
        ParseCsv.main(args);
    }

    @Test()
    public void testNoFile() {
        String[] args = {"blah"};
        ParseCsv.main(args);
    }
}
