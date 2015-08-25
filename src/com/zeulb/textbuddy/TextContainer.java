package com.zeulb.textbuddy;

import java.io.PrintWriter;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class TextContainer extends ArrayList<String> {
    
    public TextContainer(String fileName) {
        setFileName(fileName);
    }
    
    private String fileName;
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int index = 0; index < size(); index++) {
            sb.append(String.format(Helper.DISPLAY_FORMAT, index+1, get(index)));
        }
        return sb.toString();
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(fileName);
        out.println(toString());
        out.close();
    }
    
}
