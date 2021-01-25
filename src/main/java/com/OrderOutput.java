package com;

import java.io.FileWriter;
import java.io.IOException;

public class OrderOutput {
    public void writeFile(String s, String path) {
        FileWriter writer;
        try {
            writer = new FileWriter(path);
            writer.write(s);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
