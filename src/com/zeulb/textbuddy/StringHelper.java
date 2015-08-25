package com.zeulb.textbuddy;

public class StringHelper {

    public static String getFirstWord(String text) {
        int spacePosition = text.indexOf(' ');
        if (spacePosition > -1) {
            return text.substring(0, spacePosition);
        }
        else {
            return text;
        }
    }
    
}
