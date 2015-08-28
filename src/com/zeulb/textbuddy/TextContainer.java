package com.zeulb.textbuddy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class TextContainer extends ArrayList<String> {
    
    public TextContainer(String fileName) {
        setFileName(fileName);
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
    
    public void importFromFile() throws Exception {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            boolean isFailed = false;
            while(scanner.hasNextLine() && !isFailed) {
                String text = scanner.nextLine().trim();
                if (!text.isEmpty()) {
                    i++;
                    String numberingPrefix = Integer.toString(i) + ". ";
                    if (text.startsWith(numberingPrefix)) {
                        String message = text.substring(numberingPrefix.length());
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
            // Do nothing
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
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(fileName);
        out.print(toString());
        out.close();
    }
    
}
