package P02_FileStream;

public abstract class StreamableFile implements Streamable {
    private int length;
    private int bytesSent;

    protected StreamableFile(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
