package com.zeulb.textbuddy;

public interface Command {
    
    /*
     * Parses the string argument as a command object
     * @param text the text that needs to be parsed as command
     */
    public static Command parseCommand(String text) throws Exception {
        String commandText = Helper.getFirstWord(text);
        String argumentText = Helper.removeFirstWord(text).trim();
        
        Command command;
        
        switch (commandText) {
            case "add":
                command = new CommandAdd(argumentText);
                break;
            case "display":
                command = new CommandDisplay(argumentText);
                break;
            case "delete":
                command = new CommandDelete(argumentText);
                break;
            case "clear":
                command = new CommandClear(argumentText);
                break;
            case "exit":
                command = new CommandExit(argumentText);
                break;
            default:
                throw new Exception(String.format(Helper.ERROR_INVALID_COMMAND, commandText));
        }
        return command;
    }
    
    /*
     * Execute command
     * @param container the container where the operation will be executed
     */
    public String execute(TextContainer container) throws Exception;
}
