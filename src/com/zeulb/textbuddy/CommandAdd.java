package com.zeulb.textbuddy;

/**
 * All add command is instantiated from this class
 * Add command accepts one non-blank string argument 
 */
public class CommandAdd implements Command {
    
    private String text;
    
    /**
     * Class constructor specifying arguments for the command
     */
    public CommandAdd(String args) throws Exception {
        if (args.trim().isEmpty()) {
            throw new Exception(Helper.ERROR_BLANK_TEXT);
        }
        text = args.trim();
    }
    
    /**
     * Insert text to the container
     * @return Successfully added message
     */
    @Override
    public String execute(TextContainer container) {
        container.add(text);
        
        String fileName = container.getFileName();
        return String.format(Helper.MESSAGE_ADD_TEXT, fileName, text);
    }
}
