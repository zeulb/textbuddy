package com.zeulb.textbuddy;

public class CommandSort implements Command {
    
    /**
     * Class constructor specifying arguments for the command
     */
    public CommandSort(String args) throws Exception {
        if (!args.trim().isEmpty()) {
            throw new Exception(Helper.ERROR_INVALID_ARGUMENT);
        }
    }

    @Override
    public String execute(TextContainer container) throws Exception {
        // TODO Add execution of sort command
        return null;
    }    

}
