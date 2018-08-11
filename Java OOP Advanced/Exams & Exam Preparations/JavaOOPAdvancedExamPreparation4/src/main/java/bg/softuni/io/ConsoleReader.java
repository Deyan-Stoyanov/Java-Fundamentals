package bg.softuni.io;

import bg.softuni.abstractions.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader {
    BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }
}
