package com.zeulb.textbuddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandSortTest {

    private static final String fileName = "testFile.txt";
    private TextContainer tc = null;
    
    @Before
    public void setUp() throws Exception {
        tc = new TextContainer(fileName);
        tc.clear();
    }

    @Test
    public void testCannotTakesArguments() {
        
        try {
            Command cmd = new CommandSort(" helo");
            fail("exception should be thrown");
            cmd.execute(tc);
        } catch(Exception e) {
            assertEquals(Helper.ERROR_INVALID_ARGUMENT, e.getMessage());
        }
    }

}
