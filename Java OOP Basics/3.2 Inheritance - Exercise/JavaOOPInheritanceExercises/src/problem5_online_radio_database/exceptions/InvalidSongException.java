package problem5_online_radio_database.exceptions;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException() {
        super();
    }

    public InvalidSongException(String s) {
        super(s);
    }
}
