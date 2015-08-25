package com.zeulb.textbuddy;

public class CommandDisplay implements Command {
    
    public CommandDisplay(String args) throws Exception {
        if (args.trim().length() > 0) {
            throw new Exception("Command 'display' doesn't need any arguments");
        }
    }

    @Override
    public String execute(TextContainer container) {
        return container.toString();
    }

}
