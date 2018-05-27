package app.Exercise;

import app.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\exercises\\input.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))){
            String line;
            while ((line = reader.readLine()) != null){
                int count = 0;
                for (char c : line.toCharArray()) {
                    count += c;
                }
                System.out.println(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
