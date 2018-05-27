package app.Lab;

import app.Config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    private static final int ASCII_CODE_SPACE = 32;
    private static final int ASCII_CODE_NEWLINE = 10;
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\lab\\input.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\outputCopyBytes.txt";
        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)){
            int oneByte = inputStream.read();
            while (oneByte >= 0){
                if(oneByte == ASCII_CODE_NEWLINE || oneByte == ASCII_CODE_SPACE){
                    outputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (Character c:digits.toCharArray()) {
                        outputStream.write(c);
                    }
                }
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
