package com.zeulb.textbuddy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class extends ArrayList<String>
 * This class is used for storage and retrieval from text file and program
 */
@SuppressWarnings("serial")
public class TextContainer extends ArrayList<String> {
    
    /**
     * Class constructor specifying file for storage
     */
    public TextContainer(String fileName) {
        setFileName(fileName);
        // Try to import texts from file
        try {
            importFromFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private String fileName;
    
    /**
     * Get current file name
     * @return current file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Set current file name
     * @param fileName New file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Import texts from file to container
     */
    public void importFromFile() throws Exception {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            int currentNumber = 0;
            boolean isFailed = false;
            
            while(scanner.hasNextLine() && !isFailed) {
                String text = scanner.nextLine().trim();
                
                // Check if text is blank
                if (!text.isEmpty()) {
                    // Increase line counter
                    currentNumber++;
                    String numberingPrefix = Integer.toString(currentNumber) + ". ";
                    
                    // Check if text is in a valid format
                    if (text.startsWith(numberingPrefix)) {
                        String message = Helper.removeFirstWord(text).trim();
                        // Add to current container
                        add(message);
                    }
                    else {
                        isFailed = true;
                    }
                }
            }
            scanner.close();
            if (isFailed) {
                throw new Exception(Helper.ERROR_IMPORT_FAILED);
            }
        } catch (FileNotFoundException fnfe) {
            // There is nothing to import, do nothing
        }
    }
    
    /**
     * Append all texts
     * @return Human readable string of all texts inside container
     */
    @Override
    public String toString() {
        return Helper.getFormattedList(this);
    }
    
    /**
     * Import texts from container to file
     */
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(fileName);
        out.print(toString());
        out.close();
    }
    
    
}
