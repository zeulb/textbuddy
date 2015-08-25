package com.zeulb.textbuddy;

public class CommandDelete implements Command {
    
    int index;

    public CommandDelete(String args) throws Exception {
        try {
            index = Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            throw new Exception("Argument for command 'delete' is not an integer");
        }
    }
    
    @Override
    public String execute(TextContainer tc) throws Exception {
        String fileName = tc.getFileName();
        String text;
        try {
            text = tc.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Argument for command 'delete' is out of bound");
        }
        return "deleted from " + fileName + ": \"" + text + "\"";
    }

}
