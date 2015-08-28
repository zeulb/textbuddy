package com.zeulb.textbuddy;

import java.util.Scanner;

public class TextBuddy {
    
    public static Scanner scanner = new Scanner(System.in);
    public static TextContainer container;
    public static boolean shouldExit;
    
    /**
     * Process user input
     * @param userResponse string entered by user
     */
    public static String process(String userResponse) {
        Command command = null;
        String feedback;
        try {
            command = Command.parseCommand(userResponse);
            feedback = command.execute(container);
            container.save();
        } catch (Exception e) {
            feedback = e.getMessage();
        }
        
        if (command instanceof CommandExit) {
            shouldExit = true;
        }
        return feedback;
    }
    
    /**
     * Start communication between program and user
     * @param fileName name of file that will be used for storage
     */
    public static void start(String fileName) {
        container = new TextContainer(fileName);
        shouldExit = false;
        
        System.out.println(String.format(Helper.MESSAGE_WELCOME, fileName));
        
        do {
            System.out.print(Helper.MESSAGE_PROMPT);
            String userResponse = scanner.nextLine();
            String feedback = process(userResponse);
            System.out.println(feedback);
        } while(!shouldExit);
    }
    
    /**
     * Get file name from parameter provided by user
     * @param args arguments provided by user
     */
    public static void main(String[] args) {
        try {
            String fileName = args[0];
            start(fileName);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println(Helper.ERROR_NO_OUTPUT_FILE);
        }
    }

}
