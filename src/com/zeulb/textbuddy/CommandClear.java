package com.zeulb.textbuddy;

/**
 * All clear command is instantiated from this class
 * Clear command accepts no argument 
 */
public class CommandClear implements Command {

    /**
     * Class constructor specifying arguments for the command
     */
    public CommandClear(String args) throws Exception {
        if (!args.isEmpty()) {
            throw new Exception(Helper.ERROR_INVALID_ARGUMENT);
        }
    }
    
    /**
     * Clear container
     * @return Successfully cleared message
     */
    @Override
    public String execute(TextContainer container) {
        container.clear();
        
        String fileName = container.getFileName();
        return String.format(Helper.MESSAGE_CLEAR, fileName);
    }

}
