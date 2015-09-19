package com.zeulb.textbuddy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandSortTest {

    private static final String fileName = "testFile.txt";
    private TextContainer tc = null;
    
    @Before
    public void setUp() throws Exception {
        // Create a empty dummy container file
        tc = new TextContainer(fileName);
        tc.clear();
    }

    @Test
    public void testShouldNotTakeAnyArguments() {
        try {
            Command cmd = new CommandSort(" helo");
            fail("exception should be thrown");
            cmd.execute(tc);
        } catch(Exception e) {
            assertEquals(Helper.ERROR_INVALID_ARGUMENT, e.getMessage());
        }
    }
    
    @Test
    public void testCanSortNonEmptyList() throws Exception {
        
        // Add some data to text container
        tc.add("sdk");
        tc.add("bb");
        tc.add("d");
        tc.add("sc");
        tc.add("kk");
        
        Command cmd = new CommandSort("");
        
        // Execute sort command
        String feedback = cmd.execute(tc);
        
        // Check if correct feedback displayed
        assertEquals(String.format(Helper.MESSAGE_SORT, fileName), feedback);
        
        // Check if text container size doesn't change
        assertEquals(5, tc.size());
        
        // Check if elements inside text container is sorted
        assertEquals("bb" , tc.get(0));
        assertEquals("d"  , tc.get(1));
        assertEquals("kk" , tc.get(2));
        assertEquals("sc" , tc.get(3));
        assertEquals("sdk", tc.get(4));
        
    }
    
    @Test
    public void testCannotSortEmptyList() throws Exception {
        Command cmd = new CommandSort("");
        
        // Execute sort command
        String feedback = cmd.execute(tc);
        
        // Check if correct feedback displayed
        assertEquals(String.format(Helper.MESSAGE_IS_EMPTY, fileName), feedback);
        
    }

}
