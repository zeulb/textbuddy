package com.zeulb.textbuddy;

import java.util.Scanner;

public class TextBuddy {
    
    public static Scanner scanner = new Scanner(System.in);
    public static TextContainer container;
    public static boolean shouldExit;
    
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
    
    public static void start(String fileName) {
        container = new TextContainer(fileName);
        shouldExit = false;
        
        System.out.println(String.format(Helper.WELCOME_MESSAGE, fileName));
        
        do {
            System.out.print(Helper.COMMAND_PROMPT);
            String userResponse = scanner.nextLine();
            String feedback = process(userResponse);
            System.out.println(feedback);
        } while(!shouldExit);
    }
    
    public static void main(String[] args) {
        try {
            String fileName = args[0];
            start(fileName);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(Helper.ERROR_NO_OUTPUT_FILE);
        }
    }

}
