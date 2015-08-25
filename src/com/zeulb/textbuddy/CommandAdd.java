package com.zeulb.textbuddy;

public class CommandAdd implements Command {
    
    String text;
    
    public CommandAdd(String args) {
        this.text = args.trim();
    }

    @Override
    public String execute(TextContainer tc) {
        String fileName = tc.getFileName();
        tc.add(text);
        
        return "added to " + fileName + ": \"" + text + "\"";
    }
}
