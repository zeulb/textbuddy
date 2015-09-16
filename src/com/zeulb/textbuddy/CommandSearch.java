package com.zeulb.textbuddy;

public class CommandSearch implements Command {

    /**
     * Class constructor specifying arguments for the command
     */
    public CommandSearch(String args) throws Exception {
        if (!args.trim().isEmpty()) {
            throw new Exception(Helper.ERROR_INVALID_ARGUMENT);
        }
    }
    
    @Override
    public String execute(TextContainer container) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
