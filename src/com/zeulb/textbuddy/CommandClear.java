package com.zeulb.textbuddy;

public class CommandClear implements Command {

    public CommandClear(String args) throws Exception {
        if (args.length() > 0) {
            throw new Exception(String.format(Helper.INVALID_ARGUMENT, "clear"));
        }
    }

    @Override
    public String execute(TextContainer container) {
        
        container.clear();
        
        String fileName = container.getFileName();
        return String.format(Helper.CLEAR_FORMAT, fileName);
    }

}
