package com.zeulb.textbuddy;

public class CommandDisplay implements Command {
    
    public CommandDisplay(String args) throws Exception {
        if (args.length() > 0) {
            throw new Exception(String.format(Helper.INVALID_ARGUMENT, "display"));
        }
    }

    @Override
    public String execute(TextContainer container) {
        
        if (container.size() > 0) {
            return container.toString();
        }
        else {
            String fileName = container.getFileName();
            return String.format(Helper.IS_EMPTY_FORMAT, fileName);
        }
    }

}
