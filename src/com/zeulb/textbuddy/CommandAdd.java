package com.zeulb.textbuddy;

public class CommandAdd implements Command {
    
    private String text;
    /**
     * Class constructor specifying arguments for the command
     */
    public CommandAdd(String args) throws Exception {
        if (args.isEmpty()) {
            throw new Exception(Helper.ERROR_BLANK_TEXT);
        }
        text = args;
    }

    @Override
    public String execute(TextContainer container) {
        
        container.add(text);
        
        String fileName = container.getFileName();
        return String.format(Helper.MESSAGE_ADD_TEXT, fileName, text);
    }
}
