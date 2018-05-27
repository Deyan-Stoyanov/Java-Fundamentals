package app.Lab;

import app.Config;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File(Config.RESOURCES + "\\lab\\Files-and-Streams");
        if(file.exists() && file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                if(!f.isDirectory()){
                    System.out.println(f.getName() + ": [" + f.length() + "]");
                }
            }
        }
    }
}
