package app.Lab;

import app.Config;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class NestedFolders {
    public static void main(String[] args) {
        File file = new File(Config.RESOURCES + "\\lab\\Files-and-Streams");
        int count = 0;
        Queue<File> directories = new ArrayDeque<>();
        directories.add(file);
        System.out.println(file.getName());
        count++;
        while(!directories.isEmpty()) {
            File currentFile = directories.remove();
            if(file.exists() && file.isDirectory()){
                File[] nestedFiles = Objects.requireNonNull(currentFile).listFiles();
                for (File nestedFile : Objects.requireNonNull(nestedFiles)) {
                    if(nestedFile.isDirectory()){
                        directories.add(nestedFile);
                        System.out.println(nestedFile.getName());
                        count++;
                    }
                }
            }
        }
        System.out.println(count + " folders");
    }
}
