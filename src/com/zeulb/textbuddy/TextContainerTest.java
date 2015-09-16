package com.zeulb.textbuddy;

import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;

public class TextContainerTest {
    
    private static final String fileName = "testFile.txt";
    
    public boolean insertToFile(String string) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            out.print(string);
            out.close();
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    @Before
    public void setUp() throws Exception {
        insertToFile("");
    }
    
    @Test
    public void testToString() {
        TextContainer tc = new TextContainer(fileName);
        
        tc.add("Makan");
        tc.add("Minum");
        tc.add("Tidur");
        
        assertEquals( "1. Makan\n"
                    + "2. Minum\n"
                    + "3. Tidur", tc.toString());
    }

    @Test
    public void testCanImportFromFile() throws Exception {
        
        String list = "1. Eat\n" + 
                      "2. Sleep\n" +
                      "3. Watch TV";
        
        insertToFile(list);
        
        TextContainer tc = new TextContainer(fileName);
        
        assertEquals(tc.toString(), list);
        
    }

}
