package com.hand.ln;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class IOTest {

    public static void main(String[] args) throws IOException {
        String path = "D:\\javaIO.txt";
        for (int i = 0; i < 10; i++) {
            writeFile(path, "中文中国\n", true);
        }

        List<String> contents = readFile(path);
        for (String s : contents) {
            System.out.println(s);
        }
    }

    public static boolean writeFile(String path, String content, boolean append) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, append);
        writer.write(content);
        writer.close();
        return true;
    }

    public static List<String> readFile(String path) throws IOException {
        List<String> contents = new LinkedList<String>();
        File file = new File(path);
        if (!file.exists()) {
            return contents;
        }
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (bufferedReader.ready()) {
            contents.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        return contents;
    }
}
