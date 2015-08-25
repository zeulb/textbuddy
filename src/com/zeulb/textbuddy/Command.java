package com.zeulb.textbuddy;

public interface Command {
    
    public static Command parseCommand(String text) throws Exception {
        String commandText = Helper.getFirstWord(text);
        String argumentText = text.substring(commandText.length()).trim();
        
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
                throw new Exception(String.format(Helper.INVALID_COMMAND, commandText));
        }
        return command;
    }

    public String execute(TextContainer container) throws Exception;
}
