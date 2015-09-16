package com.zeulb.textbuddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandAddTest {
    private static final String fileName = "testFile.txt";
    private TextContainer tc = null;
    
    @Before
    public void setUp() throws Exception {
        tc = new TextContainer(fileName);
        tc.clear();
    }

    @Test
    public void testCanAdd() throws Exception {
        Command cmd = new CommandAdd("sleep  ");
        String feedback = cmd.execute(tc);
        
        assertEquals(1, tc.size());
        assertEquals("sleep", tc.get(0));
        assertEquals(String.format(Helper.MESSAGE_ADD_TEXT, fileName, "sleep"), feedback);
    }
    
    @Test
    public void testCannotAddBlankText() {
        try {
            Command cmd = new CommandAdd("      ");
            fail("exception should be thrown");
            cmd.execute(tc);
        } catch (Exception e) {
            assertEquals(0, tc.size());
            assertEquals(Helper.ERROR_BLANK_TEXT, e.getMessage());
        }
    }
}
