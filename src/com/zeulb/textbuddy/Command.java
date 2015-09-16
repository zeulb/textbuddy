package com.zeulb.textbuddy;

/**
 * All command class will implement this interface
 * This interface also provide static method to parse command text
 */
public interface Command {
    
    /*
     * Parses the string argument as a command object
     * @param text The text that needs to be parsed as command
     * @return An suitable instance of Object that implements Command based on command type
     */
    public static Command parseCommand(String text) throws Exception {
        String commandType = Helper.getFirstWord(text);
        String arguments = Helper.removeFirstWord(text).trim();
        
        Command command;
        
        switch (commandType.toLowerCase()) {
            case "add":
                command = new CommandAdd(arguments);
                break;
            case "display":
                command = new CommandDisplay(arguments);
                break;
            case "delete":
                command = new CommandDelete(arguments);
                break;
            case "clear":
                command = new CommandClear(arguments);
                break;
            case "sort":
                command = new CommandSort(arguments);
                break;
            case "search":
                command = new CommandSearch(arguments);
                break;
            case "exit":
                command = new CommandExit(arguments);
                break;
            default:
                // throw exception if it is not a valid command
                throw new Exception(String.format(Helper.ERROR_INVALID_COMMAND, commandType));
        }
        return command;
    }
    
    /*
     * Execute command
     * @param container The container where the operation will be executed
     * @return Feedback from execution
     */
    public String execute(TextContainer container) throws Exception;
}
