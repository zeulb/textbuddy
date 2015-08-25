package com.zeulb.textbuddy;

import java.util.Scanner;

public class TextBuddy {
    
    public static void main(String[] args) {
        String fileName;
        try {
            fileName = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please provide text file location");
            return;
        }
        
        TextContainer tc = new TextContainer(fileName);
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Welcome to TextBuddy. " + fileName + " is ready for use");
        boolean isDone = false;
        do {
            System.out.print("command: ");
            String text = sc.nextLine();
            try {
                Command command = Command.parseCommand(text);
                System.out.println(command.execute(tc));
                tc.save();
            } catch (Exception e) {
                if (e.getMessage().equals(".exit")) {
                    isDone = true;
                }
                else {
                    System.out.println(e.getMessage());
                }
            }
        } while(!isDone);
        sc.close();
    }

}
