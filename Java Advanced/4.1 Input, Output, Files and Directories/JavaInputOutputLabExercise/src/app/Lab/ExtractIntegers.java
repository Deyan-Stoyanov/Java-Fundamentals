package app.Lab;

import app.Config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\lab\\input.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\outputIntegers.txt";
        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath))){
            while(scanner.hasNext()) {
                if(scanner.hasNextInt()){
                    printWriter.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
