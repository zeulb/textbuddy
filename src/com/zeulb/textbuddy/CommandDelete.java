package com.zeulb.textbuddy;

public class CommandDelete implements Command {
    
    private int deleteIndex;

    public CommandDelete(String args) throws Exception {
        try {
            deleteIndex = Integer.parseInt(args)-1;
        } catch (NumberFormatException e) {
            throw new Exception(String.format(Helper.ERROR_NON_INTEGER_ARGUMENT, "delete"));
        }
    }
    
    @Override
    public String execute(TextContainer container) throws Exception {
        
        String text;
        try {
            text = container.remove(deleteIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception(String.format(Helper.OUT_OF_BOUNDS_ARGUMENT, "delete"));
        }
        
        String fileName = container.getFileName();
        return String.format(Helper.MESSAGE_DELETE, fileName, text);
    }

}
