package problem5_online_radio_database.exceptions;

public class InvalidArtistNameException extends InvalidSongException {
    public InvalidArtistNameException() {
        super("Artist name should be between 3 and 20 symbols.");
    }
}
