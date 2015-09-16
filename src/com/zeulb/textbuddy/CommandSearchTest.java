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
    public void testTakeExactlyOneKeyword() {
        try {
            Command cmd = new CommandSearch(" helo halo elo");
            fail("exception should be thrown");
            cmd.execute(tc);
        } catch(Exception e) {
            assertEquals(Helper.ERROR_INVALID_ARGUMENT, e.getMessage());
        }
        
        try {
            Command cmd = new CommandSearch("     ");
            fail("exception should be thrown");
            cmd.execute(tc);
        } catch(Exception e) {
            assertEquals(Helper.ERROR_INVALID_ARGUMENT, e.getMessage());
        }
        
        try {
            Command cmd = new CommandSearch(" budi ");
            cmd.execute(tc);
        } catch(Exception e) {
            fail("exception should not be thrown");
        }
    }
    
    @Test
    public void testCanSearchByKeyword() {
        fail("Not yet implemented");
    }

}
