package problem5_online_radio_database.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException{
    public InvalidSongSecondsException() {
        super("Song seconds should be between 0 and 59.");
    }
}
