package problem5_online_radio_database.exceptions;

public class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException() {
        super("Song name should be between 3 and 30 symbols.");
    }
}
