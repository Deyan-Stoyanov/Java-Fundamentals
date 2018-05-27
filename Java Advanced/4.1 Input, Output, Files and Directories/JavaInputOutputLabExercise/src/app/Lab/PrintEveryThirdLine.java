package app.Lab;

import app.Config;

import java.io.*;

public class PrintEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\exercises\\input.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\outputEveryThirdLine.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))){
            int i = 1;
            String input;
            while((input = reader.readLine()) != null) {
                if(i % 3 == 0){
                    printWriter.println(input);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
