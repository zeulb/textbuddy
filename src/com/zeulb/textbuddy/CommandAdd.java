package com.zeulb.textbuddy;

public class CommandAdd implements Command {
    
    String text;
    
    public CommandAdd(String args) {
        this.text = args.trim();
    }

    @Override
    public String execute(TextContainer container) {
        String fileName = container.getFileName();
        container.add(text);
        
        return "added to " + fileName + ": \"" + text + "\"";
    }
}
