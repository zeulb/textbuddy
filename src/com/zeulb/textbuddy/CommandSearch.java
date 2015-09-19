package com.zeulb.textbuddy;

import java.util.ArrayList;

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
    
    /**
     * Check if keyword inside sentence
     * @param sentence
     * @return true if keyword inside sentence otherwise false
     */
    private boolean search(String sentence) {
        String[] words = sentence.split("\\W+");
        for (String word : words) {
            if (word.equals(keyword)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Display texts that contains specific keyword
     */
    @Override
    public String execute(TextContainer container) throws Exception {
        ArrayList<String> filteredList = new ArrayList<String>();
        for (String sentence : container) {
            // check all sentence inside the container
            if (search(sentence)) {
                // if the sentence contains the keyword
                filteredList.add(sentence);
            }
        }
        
        if (filteredList.isEmpty()) {
            String fileName = container.getFileName();
            return String.format(Helper.MESSAGE_KEYWORD_NOT_FOUND, keyword, fileName);
        }
        else {
            return Helper.getFormattedList(filteredList);
        }
    }

}
