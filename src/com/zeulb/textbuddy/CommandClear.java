package com.zeulb.textbuddy;

public class CommandClear implements Command {

    public CommandClear(String args) throws Exception {
        if (args.trim().length() > 0) {
            throw new Exception("Command 'delete' doesn't need any arguments");
        }
        
    }

    @Override
    public String execute(TextContainer tc) {
        String fileName = tc.getFileName();
        tc.clear();
        return "all content deleted from" + fileName;
    }

}
