package com.zeulb.textbuddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandDisplayTest {

    private static final String fileName = "testFile.txt";
    private TextContainer tc = null;
    
    @Before
    public void setUp() throws Exception {
        tc = new TextContainer(fileName);
        tc.clear();
    }

    @Test
    public void testCanDisplayNonEmptyList() throws Exception {
        
        tc.add("sleep");
        tc.add("eat");
        
        Command cmd = new CommandDisplay("   ");
        String feedback = cmd.execute(tc);
        
        assertEquals("1. sleep\n2. eat", feedback);
    }
    
    @Test
    public void testCanDisplayEmptyList() throws Exception {
        
        Command cmd = new CommandDisplay("   ");
        String feedback = cmd.execute(tc);
        
        assertEquals(String.format(Helper.MESSAGE_IS_EMPTY, fileName), feedback);
    }

}
