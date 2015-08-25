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
        
    }

}
