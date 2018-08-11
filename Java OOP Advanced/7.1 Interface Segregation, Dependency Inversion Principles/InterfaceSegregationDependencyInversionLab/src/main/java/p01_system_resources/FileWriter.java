package p01_system_resources;

import java.io.IOException;

public class FileWriter implements Writer {
    @Override
    public void writeLine(String line) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("result.txt");
            writer.write(line);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
