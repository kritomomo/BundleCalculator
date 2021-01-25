package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class OrderInput {
    public OrderInput() {
    }

    public ArrayList<String> readFile(String path) {
        File file = new File(path);
        long fileLength = file.length();
        byte[] buff = new byte[(int) fileLength];
        try {
            FileInputStream fin = new FileInputStream(file);
            int len = fin.read(buff);
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = new String(buff);
        ArrayList<String> ls = new ArrayList<>();
        for (String o : s.split("\n")) {
            Collections.addAll(ls, o.split(" "));
        }
        return ls;
    }
}