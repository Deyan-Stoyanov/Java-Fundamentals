package app.Lab;


import app.Config;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromFile {
    public static void main(String[] args) {
        String path = Config.RESOURCES + "\\exercises\\inputLineNumbers.txt";
        try(FileInputStream stream = new FileInputStream(path)){
            int oneByte = stream.read();
            while(oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = stream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
