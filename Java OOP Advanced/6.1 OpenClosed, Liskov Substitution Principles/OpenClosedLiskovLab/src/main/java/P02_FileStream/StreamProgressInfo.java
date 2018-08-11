package P02_FileStream;

public class StreamProgressInfo {
    private Streamable sourceFile;

    // If we want to stream a music file, we can't
    public StreamProgressInfo(Streamable streamable) {
        this.sourceFile = streamable;
    }

    public int calculateCurrentPercent() {
        return (this.sourceFile.getBytesSent() * 100) / this.sourceFile.getLength();
    }
}
