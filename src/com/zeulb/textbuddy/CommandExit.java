package com.zeulb.textbuddy;

/**
 * All exit command is instantiated from this class
 * Exit command accepts no argument 
 */
public class CommandExit implements Command {

    /**
     * Class constructor specifying arguments for the command
     */
    public CommandExit(String args) throws Exception {
        if (!args.isEmpty()) {
            throw new Exception(Helper.ERROR_INVALID_ARGUMENT);
        }
    }
    
    /**
     * Do nothing
     * @return An empty string
     */
    @Override
    public String execute(TextContainer container) throws Exception {
        // No need to give feedback to user
        return "";
    }

}
