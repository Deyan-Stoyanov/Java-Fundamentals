package problem5_online_radio_database.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException{
    public InvalidSongMinutesException() {
        super("Song minutes should be between 0 and 14.");
    }
}
