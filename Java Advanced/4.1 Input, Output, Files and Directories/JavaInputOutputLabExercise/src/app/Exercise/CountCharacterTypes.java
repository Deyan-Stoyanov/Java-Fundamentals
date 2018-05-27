package app.Exercise;

import app.Config;

import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = Config.RESOURCES + "\\exercises\\input.txt";
        String outputPath = Config.RESOURCES + "\\exercises\\outputCharacterTypes.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
             PrintWriter printWriter = new PrintWriter( new FileOutputStream(outputPath))){
            String line;
            int vowelCount = 0;
            int consonantCount = 0;
            int punctuationCount = 0;
            while ((line = reader.readLine()) != null){
                for (char c : line.toCharArray()) {
                    if(Character.toString(c).matches("[aeoui]")){
                        vowelCount++;
                    } else if(Character.toString(c).matches("[!?.,]")){
                        punctuationCount++;
                    } else if(!Character.toString(c).matches("[\\s]")){
                        consonantCount++;
                    }
                }
            }
            printWriter.println("Vowels: " + vowelCount);
            printWriter.println("Consonants: " + consonantCount);
            printWriter.println("Punctuation: " + punctuationCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
