package com.zeulb.textbuddy;

import java.util.Scanner;

public class TextBuddy {
    
    public static void main(String[] args) {
        String fileName;
        try {
            fileName = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.out.format(Helper.NO_OUTPUT_FILE);
            return;
        }
        
        TextContainer container = new TextContainer(fileName);
        Scanner sc = new Scanner(System.in);
        
        System.out.format(Helper.WELCOME_MESSAGE, fileName);
        
        boolean isDone = false;
        
        do {
            System.out.print(Helper.COMMAND_PROMPT);
            String text = sc.nextLine();
            
            Command command = null;
            try {
                command = Command.parseCommand(text);
                System.out.print(command.execute(container));
                
                container.save();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            if (command instanceof CommandExit) {
                isDone = true;
            }
            
        } while(!isDone);
        sc.close();
    }

}
