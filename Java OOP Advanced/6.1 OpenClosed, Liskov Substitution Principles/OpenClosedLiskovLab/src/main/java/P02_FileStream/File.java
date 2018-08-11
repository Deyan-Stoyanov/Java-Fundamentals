package P02_FileStream;

public class File extends StreamableFile {

    private String name;

    public File(int length, int bytesSent) {
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
