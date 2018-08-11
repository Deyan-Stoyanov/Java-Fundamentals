package p01_system_resources;

public class ConsoleWriter implements Writer{
    public ConsoleWriter() {
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
