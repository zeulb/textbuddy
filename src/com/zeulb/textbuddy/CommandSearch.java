package com.zeulb.textbuddy;

public class CommandSearch implements Command {
    
    private String keyword;
    /**
     * Class constructor specifying arguments for the command
     */
    public CommandSearch(String args) throws Exception {
        String[] argList = args.trim().split("\\W+");
        if (args.trim().length() == 0 || argList.length > 1) {
            throw new Exception(Helper.ERROR_INVALID_ARGUMENT);
        }
        keyword = argList[0];
    }
    
    @Override
    public String execute(TextContainer container) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
