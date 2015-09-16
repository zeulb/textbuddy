package com.zeulb.textbuddy;

import java.util.Collections;

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
        
        String fileName = container.getFileName();
        if (container.size() > 0) {
            Collections.sort(container);
            return String.format(Helper.MESSAGE_SORT, fileName);
        }
        else {
            return String.format(Helper.MESSAGE_IS_EMPTY, fileName);
        }
    }    

}
