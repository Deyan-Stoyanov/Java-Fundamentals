package app.Exercise;

import app.Config;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class MergeFiles {
    public static void main(String[] args) {
        String inputPathOne = Config.RESOURCES + "\\exercises\\inputOne.txt";
        String inputPathTwo = Config.RESOURCES + "\\exercises\\inputTwo.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\merged.txt";
        try (PrintWriter printWriter = new PrintWriter( new FileOutputStream(outputPath))){
            BufferedReader readerOne = new BufferedReader(new InputStreamReader(new FileInputStream(inputPathOne)));
            Set<String> elements = new TreeSet<>();
            String line;
            while ((line = readerOne.readLine()) != null) {
                elements.add(line);
            }
            readerOne = new BufferedReader(new InputStreamReader(new FileInputStream(inputPathTwo)));
            while ((line = readerOne.readLine()) != null) {
                elements.add(line);
            }
            for (String element : elements) {
                printWriter.println(element);
            }
            readerOne.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
