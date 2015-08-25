package com.zeulb.textbuddy;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TextContainer extends ArrayList<String> {
    
    String fileName;
    
    public TextContainer(String fileName) {
        this.fileName = fileName;
        
    }
    
    public void save() throws Exception {
        try {
            PrintWriter pw = new PrintWriter(fileName);
            for (int index = 0; index < size(); index++) {
                // Print the index number
                pw.print(index);
                // Print the dot and space and its content
                pw.print(". " + get(index));
            }
            pw.close();
        } catch (FileNotFoundException e) {
            throw new Exception("File not found"); 
        }
        
    }
    
}
