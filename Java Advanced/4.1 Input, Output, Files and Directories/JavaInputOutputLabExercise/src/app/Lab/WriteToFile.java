package app.Lab;

import app.Config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\exercises\\input.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\output.txt";
        try (FileInputStream inputStream = new FileInputStream(inputPath);
                FileOutputStream outputStream = new FileOutputStream(outputPath)){
            int oneByte = inputStream.read();
            while (oneByte >= 0){
                if(!Character.toString((char)oneByte).matches("[,.!?]")){
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
