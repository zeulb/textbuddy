package com.zeulb.textbuddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandDeleteTest {

    private static final String fileName = "testFile.txt";
    private TextContainer tc = null;
    
    @Before
    public void setUp() throws Exception {
        tc = new TextContainer(fileName);
        tc.clear();
    }

    @Test
    public void testCanDelete() throws Exception {
        
        tc.add("sleep");
        tc.add("eat");
        
        assertEquals(2, tc.size());
        
        Command cmd = new CommandDelete("2");
        String feedback = cmd.execute(tc);
        
        assertEquals(1, tc.size());
        assertEquals("sleep", tc.get(0));
        assertEquals(String.format(Helper.MESSAGE_DELETE, fileName, "eat"), feedback);
        
        cmd = new CommandDelete("1");
        feedback = cmd.execute(tc);
        
        assertTrue(tc.isEmpty());
        assertEquals(String.format(Helper.MESSAGE_DELETE, fileName, "sleep"), feedback);
        
    }

}
