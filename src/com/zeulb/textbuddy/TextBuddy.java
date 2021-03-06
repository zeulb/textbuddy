package com.zeulb.textbuddy;

import java.util.Scanner;

/**
 * This class is the main class used to handle communication between program and the user
 */
public class TextBuddy {
    
    private static Scanner scanner = new Scanner(System.in);
    private static TextContainer container;
    private static boolean shouldExit;
    
    /**
     * Process user input
     * @param userResponse Text entered by user
     * @return Feedback from program
     */
    private static String executeResponse(String userResponse) {
        Command command = null;
        String feedback;
        try {
            command = Command.parseCommand(userResponse);
            feedback = command.execute(container);
            // Save to file after every successful operation
            container.save();
        } catch (Exception e) {
            feedback = e.getMessage();
        }
        
        // Check if the last command is an exit command
        if (command instanceof CommandExit) {
            shouldExit = true;
        }
        return feedback;
    }
    
    /**
     * Start communication between program and user
     * @param fileName Name of file that will be used for storage
     */
    private static void startPrompt(String fileName) {
        container = new TextContainer(fileName);
        shouldExit = false;
        
        System.out.println(String.format(Helper.MESSAGE_WELCOME, fileName));
        
        do {
            System.out.print(Helper.MESSAGE_PROMPT);
            String userResponse = scanner.nextLine();
            String feedback = executeResponse(userResponse);
            System.out.println(feedback);
        } while(!shouldExit);
    }
    
    /**
     * Get file name from parameter provided by user
     * @param args Arguments provided by user
     */
    public static void main(String[] args) {
        try {
            String fileName = args[0];
            startPrompt(fileName);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println(Helper.ERROR_NO_OUTPUT_FILE);
        }
    }

}
