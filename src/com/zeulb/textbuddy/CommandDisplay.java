package com.zeulb.textbuddy;

public class CommandDisplay implements Command {
    
    public CommandDisplay(String args) throws Exception {
        if (args.trim().length() > 0) {
            throw new Exception("Command 'display' doesn't need any arguments");
        }
    }

    @Override
    public String execute(TextContainer tc) {
        String fileName = tc.getFileName();
        if (tc.size() > 0) {
            return tc.toString();
        }
        else {
            return fileName + " is empty";
        }
    }

}
