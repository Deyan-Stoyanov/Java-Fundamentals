package app.Exercise;

import app.Config;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\exercises\\inputLineNumbers.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\outputLineNumbers.txt";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))){
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null){
                printWriter.println(++i + ". " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
