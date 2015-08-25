package com.zeulb.textbuddy;

public class CommandAdd implements Command {
    
    private String text;
    
    public CommandAdd(String args) {
        text = args;
    }

    @Override
    public String execute(TextContainer container) {
        
        container.add(text);
        
        String fileName = container.getFileName();
        return String.format(Helper.MESSAGE_ADD_TEXT, fileName, text);
    }
}
