package com.zeulb.textbuddy;

import java.util.Scanner;

public class TextBuddy {
    
    public static void start(String fileName) {
        Scanner sc = new Scanner(System.in);
        TextContainer container = new TextContainer(fileName);
        
        System.out.format(Helper.WELCOME_MESSAGE, fileName);
        
        boolean isDone = false;
        
        do {
            System.out.print(Helper.COMMAND_PROMPT);
            String text = sc.nextLine();
            
            Command command = null;
            try {
                command = Command.parseCommand(text);
                
                String successMessage = command.execute(container);
                System.out.print(successMessage);
                
                container.save();
            } catch (Exception e) {
                
                String errorMessage = e.getMessage();
                System.out.println(errorMessage);
            }
            
            if (command instanceof CommandExit) {
                isDone = true;
            }
            
        } while(!isDone);
        sc.close();
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
