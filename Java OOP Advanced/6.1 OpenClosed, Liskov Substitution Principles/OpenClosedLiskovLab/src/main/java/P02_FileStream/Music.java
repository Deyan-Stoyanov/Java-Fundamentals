package P02_FileStream;

public class Music extends StreamableFile{

    private String artist;
    private String album;

    public Music(int length, int bytesSent) {
        super(length, bytesSent);
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    @Override
    public int getBytesSent() {
        return super.getBytesSent();
    }
}
