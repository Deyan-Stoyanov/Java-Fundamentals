package abstractions;

public interface File {
    void write(String message);

    long getSize();
}
