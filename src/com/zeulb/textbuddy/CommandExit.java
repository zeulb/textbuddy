package com.zeulb.textbuddy;

public class CommandExit implements Command {

    public CommandExit(String args) throws Exception {
        if (args.length() > 0) {
            throw new Exception(Helper.ERROR_INVALID_ARGUMENT);
        }
    }
    
    @Override
    public String execute(TextContainer container) throws Exception {
        
        return "";
    }

}
