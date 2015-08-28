package com.zeulb.textbuddy;

/**
 * All display command is instantiated from this class
 * Display command accepts no argument 
 */
public class CommandDisplay implements Command {
    
    /**
     * Class constructor specifying arguments for the command
     */
    public CommandDisplay(String args) throws Exception {
        if (!args.isEmpty()) {
            throw new Exception(Helper.ERROR_INVALID_ARGUMENT);
        }
    }
    
    /**
     * Retrieve all texts from container
     * @return All texts from container 
     */
    @Override
    public String execute(TextContainer container) {
        if (container.size() > 0) {
            return container.toString();
        }
        else {
            String fileName = container.getFileName();
            return String.format(Helper.MESSAGE_IS_EMPTY, fileName);
        }
    }

}
