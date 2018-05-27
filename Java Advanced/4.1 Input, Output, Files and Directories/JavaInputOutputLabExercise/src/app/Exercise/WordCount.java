package app.Exercise;

import app.Config;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String inputPathWords = Config.RESOURCES + "\\exercises\\words.txt";
        String inputPathText = Config.RESOURCES + "\\exercises\\text.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\result.txt";
        try (BufferedReader readerWords = new BufferedReader(new InputStreamReader(new FileInputStream(inputPathWords)));
             BufferedReader readerText = new BufferedReader(new InputStreamReader(new FileInputStream(inputPathText)));
             PrintWriter printWriter = new PrintWriter( new FileOutputStream(outputPath))){
            Map<String, Integer> words = new HashMap<>();
            String line;
            while((line = readerWords.readLine()) != null) {
                String[] wordsArray = line.split("\\s+");
                for (String s : wordsArray) {
                    words.put(s, 0);
                }
            }
            while ((line = readerText.readLine()) != null){
                String[] wordsFromText = line.split("\\s+");
                for (String s : words.keySet()) {
                    for (String word : wordsFromText) {
                        if(s.equals(word)){
                            words.put(s, words.get(s) + 1);
                        }
                    }
                }

            }
            words.entrySet().stream().sorted((x, y) -> y.getValue() - x.getValue()).forEach(x -> printWriter.println(x.getKey() + " - " + x.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
