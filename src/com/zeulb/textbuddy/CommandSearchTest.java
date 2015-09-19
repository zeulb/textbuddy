package com.zeulb.textbuddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandSearchTest {

    private static final String fileName = "testFile.txt";
    private TextContainer tc = null;
    
    @Before
    public void setUp() throws Exception {
        tc = new TextContainer(fileName);
        tc.clear();
    }

    @Test
    public void testTakesExactlyOneKeyword() {
        try {
            // should not accept three arguments
            Command cmd = new CommandSearch(" helo halo elo");
            fail("exception should be thrown");
            cmd.execute(tc);
        } catch(Exception e) {
            assertEquals(Helper.ERROR_INVALID_ARGUMENT, e.getMessage());
        }
        
        try {
            // should not accept empty argument
            Command cmd = new CommandSearch("     ");
            fail("exception should be thrown");
            cmd.execute(tc);
        } catch(Exception e) {
            assertEquals(Helper.ERROR_INVALID_ARGUMENT, e.getMessage());
        }
        
        try {
            // should accept one argument
            Command cmd = new CommandSearch(" budi ");
            cmd.execute(tc);
        } catch(Exception e) {
            fail("exception should not be thrown");
        }
    }
    
    @Test
    public void testCanSearchByKeywordNotFound() throws Exception {
        
        // Add some data to the container
        tc.add("eatt food");
        tc.add("eatt seafood");
        tc.add("no eating");
        
        Command cmd = new CommandSearch("eat");
        
        String feedback = cmd.execute(tc);
        // Check if it return correct message when no text with specific keyword found
        assertEquals(String.format(Helper.MESSAGE_KEYWORD_NOT_FOUND, "eat", fileName), feedback);  
    }
    
    @Test
    public void testCanSearchByKeywordFound() throws Exception {
        
        // Add some data to the container
        tc.add("eat food");
        tc.add("dont eatt");
        tc.add("no eat no");
        tc.add("eat eat");
        
        Command cmd = new CommandSearch("eat");
        
        String feedback = cmd.execute(tc);
        // Check if it return correct message when texts are found
        assertEquals( "1. eat food\n"
                    + "2. no eat no\n"
                    + "3. eat eat", feedback);
        
    }

}
