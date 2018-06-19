package problem5_online_radio_database.exceptions;

public class InvalidSongLengthException extends InvalidSongException{
    public InvalidSongLengthException(String s) {
        super(s);
    }

    public InvalidSongLengthException() {
        super("Invalid song length.");
    }
}
