package com.zeulb.textbuddy;

public class Helper {
    
    public static final String WELCOME_MESSAGE = "Welcome to TextBuddy. %1$s is ready for use\n";
    public static final String COMMAND_PROMPT = "command: ";
    public static final String NO_OUTPUT_FILE = "error: no file provided\n";
    
    public static final String DISPLAY_FORMAT = "%1$d. %2$s\n";
    public static final String ADD_TEXT_FORMAT = "added to %1$s: \"%2$s\"\n";
    public static final String IS_EMPTY_FORMAT = "%1$s is empty\n";
    public static final String DELETED_FORMAT = "deleted from %1$s: \"%2$s\"\n";
    public static final String CLEAR_FORMAT = "all content deleted from %1$s\n";
    
    public static final String INVALID_COMMAND = "unknown command '%1$s'";
    public static final String INVALID_ARGUMENT = "invalid number of arguments for command '%1$s'";
    public static final String NON_INTEGER_ARGUMENT = "argument for command '%1$s' is not an integer";
    public static final String OUT_OF_BOUNDS_ARGUMENT = "argument for command '%1$s' is out of bounds";
    
    public static final String EXIT = "EXIT";

    public static String getFirstWord(String text) {
        int spacePosition = text.indexOf(' ');
        if (spacePosition > -1) {
            return text.substring(0, spacePosition);
        }
        else {
            return text;
        }
    }

}
