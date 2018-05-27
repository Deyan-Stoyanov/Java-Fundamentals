package app.Exercise;

import app.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\exercises\\input.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))){
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null){
                for (char c : line.toCharArray()) {
                    count += c;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
