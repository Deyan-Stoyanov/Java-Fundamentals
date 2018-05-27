package app.Lab;

import app.Config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        Path inputPath = Paths.get(Config.RESOURCES + "\\exercises\\inputUnsorted.txt");
        Path outputPath = Paths.get(Config.RESOURCES + "\\exercises\\outputSorted.txt");
        try(PrintWriter printWriter = new PrintWriter(new FileOutputStream(String.valueOf(outputPath)))) {
            List<String> lines = Files.readAllLines(inputPath);
            Collections.sort(lines);
            for (String s:lines) {
                printWriter.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
