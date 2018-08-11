package bg.softuni.abstractions;

public interface OutputWriter {
    void print(String line);
    void printLine(String line);
    void printf(String format, String... data);
}
