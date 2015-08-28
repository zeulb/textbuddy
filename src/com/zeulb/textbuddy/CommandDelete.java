package com.zeulb.textbuddy;

public class CommandDelete implements Command {
    
    private int deleteIndex;
    
    /**
     * Class constructor specifying arguments for the command
     */
    public CommandDelete(String args) throws Exception {
        // Try to parse arguments
        try {
            deleteIndex = Integer.parseInt(args)-1;
        } catch (NumberFormatException nfe) {
            throw new Exception(Helper.ERROR_NON_INTEGER_ARGUMENT);
        }
    }
    
    @Override
    public String execute(TextContainer container) throws Exception {
        String text;
        // Try to retrieve text with deleteIndex from container
        try {
            text = container.remove(deleteIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception(Helper.ERROR_OUT_OF_BOUNDS_ARGUMENT);
        }
        
        String fileName = container.getFileName();
        return String.format(Helper.MESSAGE_DELETE, fileName, text);
    }

}
