package com.zeulb.textbuddy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Import texts from file to container
     * @throws Exception
     */
    public void importFromFile() throws Exception {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            int currentNumber = 0;
            boolean isFailed = false;
            while(scanner.hasNextLine() && !isFailed) {
                String text = scanner.nextLine().trim();
                
                if (!text.isEmpty()) {
                    currentNumber++;
                    String numberingPrefix = Integer.toString(currentNumber) + ". ";
                    
                    // Check if text in valid format
                    if (text.startsWith(numberingPrefix)) {
                        String message = Helper.removeFirstWord(text).trim();
                        this.add(message);
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
            // Import nothing
        }
        
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size(); i++) {
            if (i > 0) {
                sb.append("\n");
            }
            sb.append(String.format(Helper.MESSAGE_DISPLAY, i+1, get(i)));
        }
        return sb.toString();
    }
    
    /**
     * Import texts from container to file
     * @throws Exception
     */
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(fileName);
        out.print(toString());
        out.close();
    }
    
}
