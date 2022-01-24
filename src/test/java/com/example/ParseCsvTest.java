package com.example;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParseCsvTest {
    private static String expectedOut = "Upper Case,Lower Case,Prounciation,\r\nA,a,a,\r\nB,b,bee,\r\nC,c,cee,\r\nD,d,dee,\r\nE,e,e,\r\nF,f,ef,\r\nG,g,gee,\r\nH,h,aitch,\r\nI,i,i,\r\nJ,j,jay,\r\nK,k,kay,\r\nL,l,el,\r\nM,m,em,\r\nN,n,en,\r\nO,o,o,\r\nP,p,pee,\r\nQ,q,cue,\r\nR,r,ar,\r\nS,s,ess,\r\nT,t,tee,\r\nU,u,u,\r\nV,v,vee,\r\nW,w,double-u,\r\nX,x,ex,\r\nY,y,wye,\r\nZ,z,zee,";
    private static String expectedErr = "";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void testMain() {
        String[] args = {"English-Grid view.csv"};
        ParseCsv.main(args);
        assertEquals(expectedOut, outContent.toString());
    }

    @Test
    public void testNoArgs() {
        String[] args = {};
        ParseCsv.main(args);
        assertEquals("requires 1 argument of csv file", errContent.toString());
    }

    @Test(expected = FileNotFoundException.class)
    public void testError() {
        String[] args = {"blah"};
        ParseCsv.main(args);
    }
}
