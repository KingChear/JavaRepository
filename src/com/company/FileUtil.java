package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    private static FileUtil instance;

    private FileUtil() {

    }

    public static FileUtil getInstance() {
        if (instance == null) {
            instance = new FileUtil();
        }
        return instance;
    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("E:/临时/temp.txt");
            fileWriter.write("Mike Mike@163.com");
            fileWriter.write("John John@163.com");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeByLine() {

    }

    public void readFile() {

    }

}
