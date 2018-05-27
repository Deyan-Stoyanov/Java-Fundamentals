package app.Exercise;

import app.Config;

import java.io.*;

public class GetFolderSize {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\exercises\\Exercises Resources";
        File file = new File(inputPath);
        long size = 0;
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                size += file1.length();
            }
        }
        System.out.println("Folder size: " + size);
    }
}
