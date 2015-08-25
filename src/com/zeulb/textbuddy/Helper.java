package com.zeulb.textbuddy;

public class Helper {
    
    public static final String WELCOME_MESSAGE = "Welcome to TextBuddy. %1$s is ready for use\n";
    public static final String COMMAND_PROMPT = "command: ";
    
    public static final String MESSAGE_DISPLAY = "%1$d. %2$s\n";
    public static final String MESSAGE_ADD_TEXT = "added to %1$s: \"%2$s\"\n";
    public static final String MESSAGE_IS_EMPTY = "%1$s is empty\n";
    public static final String MESSAGE_DELETE = "deleted from %1$s: \"%2$s\"\n";
    public static final String MESSAGE_CLEAR = "all content deleted from %1$s\n";

    public static final String ERROR_NO_OUTPUT_FILE = "no file provided";
    public static final String ERROR_INVALID_COMMAND = "unknown command '%1$s'";
    public static final String ERROR_INVALID_ARGUMENT = "invalid number of arguments for command '%1$s'";
    public static final String ERROR_NON_INTEGER_ARGUMENT = "argument for command '%1$s' is not an integer";
    public static final String ERROR_OUT_OF_BOUNDS_ARGUMENT = "argument for command '%1$s' is out of bounds";
    
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
