package com.zeulb.textbuddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandClearTest {

    private static final String fileName = "testFile.txt";
    private TextContainer tc = null;
    
    @Before
    public void setUp() throws Exception {
        tc = new TextContainer(fileName);
        tc.clear();
    }

    @Test
    public void testCanClear() throws Exception {
        
        tc.add("sleep");
        tc.add("eat");
        
        assertEquals(2, tc.size());
        
        Command cmd = new CommandClear("   ");
        String feedback = cmd.execute(tc);
        
        assertTrue(tc.isEmpty());
        assertEquals(String.format(Helper.MESSAGE_CLEAR, fileName), feedback);
        
    }

}
