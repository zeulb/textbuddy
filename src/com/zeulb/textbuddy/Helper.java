package com.zeulb.textbuddy;

/**
 * This class provides useful helper methods and string constants
 */
public class Helper {
    
    public static final String MESSAGE_WELCOME = "Welcome to TextBuddy. %1$s is ready for use";
    public static final String MESSAGE_PROMPT = "command: ";
    
    public static final String MESSAGE_DISPLAY = "%1$d. %2$s";
    public static final String MESSAGE_ADD_TEXT = "added to %1$s: \"%2$s\"";
    public static final String MESSAGE_IS_EMPTY = "%1$s is empty";
    public static final String MESSAGE_DELETE = "deleted from %1$s: \"%2$s\"";
    public static final String MESSAGE_CLEAR = "all content deleted from %1$s";
    public static final String MESSAGE_SORT = "%1$s has been sorted";

    public static final String ERROR_IMPORT_FAILED = "unable to import file";
    public static final String ERROR_NO_OUTPUT_FILE = "no file provided";
    public static final String ERROR_BLANK_TEXT = "unable to add blank text";
    public static final String ERROR_INVALID_COMMAND = "unknown command '%1$s'";
    public static final String ERROR_INVALID_ARGUMENT = "invalid number of arguments";
    public static final String ERROR_NON_INTEGER_ARGUMENT = "parameter is not an integer";
    public static final String ERROR_OUT_OF_BOUNDS_ARGUMENT = "index is out of bounds";

    /**
     * Return first word from given text
     * @return The first word
     */
    public static String getFirstWord(String text) {
        // Find the first whitespace position
        int spacePosition = text.indexOf(' ');
        if (spacePosition > -1) {
            return text.substring(0, spacePosition);
        }
        else {
            return text;
        }
    }
    
    /**
     * Remove first word from text
     * @return Text without its first word
     */
    public static String removeFirstWord(String text) {
        String firstWord = getFirstWord(text);
        return text.substring(firstWord.length());
    }
}
