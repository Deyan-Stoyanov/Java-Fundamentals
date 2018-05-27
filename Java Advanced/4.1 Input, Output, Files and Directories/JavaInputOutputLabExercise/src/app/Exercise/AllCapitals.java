package app.Exercise;

import app.Config;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\exercises\\input.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\outputAllCapitals.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
        PrintWriter printWriter = new PrintWriter( new FileOutputStream(outputPath))){
            String line;
            while ((line = reader.readLine()) != null){
                printWriter.println(line.toUpperCase());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
