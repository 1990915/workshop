package com.misc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            File file = new File("text.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append("hamed");
            //fileWriter.flush();
            fileWriter.close();
            Thread.sleep(5000);
        }
    }
}
