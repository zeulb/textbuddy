package com.zeulb.textbuddy;

import java.io.PrintWriter;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class TextContainer extends ArrayList<String> {
    
    private String fileName;
    
    public TextContainer(String fileName) {
        setFileName(fileName);
    }
    
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
            if (index > 0) {
                sb.append("\n");
            }
            sb.append(index+1);
            sb.append(". ");
            sb.append(get(index));
        }
        return sb.toString();
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(fileName);
        out.println(toString());
        out.close();
    }
    
}
