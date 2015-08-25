package com.zeulb.textbuddy;

public class CommandExit implements Command {

    public CommandExit(String args) throws Exception {
        if (args.trim().length() > 0) {
            throw new Exception("Command 'exit' doesn't need any arguments");
        }
    }
    
    @Override
    public String execute(TextContainer tc) throws Exception {
        throw new Exception(".exit");
    }

}
