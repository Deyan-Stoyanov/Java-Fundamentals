package problem5_online_radio_database;

import problem5_online_radio_database.exceptions.*;

public class Song {
    private String artist;
    private String songName;
    private Integer songMinutes;
    private Integer songSeconds;

    public Song() {
    }

    public Song(String artist, String songName, String songMinutes, String songSeconds) {
        this.setArtist(artist);
        this.setSongName(songName);
        this.setSongLength(songMinutes, songSeconds);
    }

    public String getArtist() {
        return artist;
    }

    private void setArtist(String artist) {
        if(artist.isEmpty() || artist.length() < 3 || artist.length() > 20){
            throw new InvalidArtistNameException();
        }
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    private void setSongName(String songName) {
        if(songName.isEmpty() || songName.length() < 3 || songName.length() > 20){
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    public Integer getSongMinutes() {
        return songMinutes;
    }

    private void setSongMinutes(Integer songMinutes) {
        if(songMinutes < 0 || songMinutes > 14){
            throw new InvalidSongMinutesException();
        }
        this.songMinutes = songMinutes;
    }

    public Integer getSongSeconds() {
        return songSeconds;
    }

    private void setSongSeconds(Integer songSeconds) {
        if(songSeconds < 0 || songSeconds > 59){
            throw new InvalidSongSecondsException();
        }
        this.songSeconds = songSeconds;
    }

    private void setSongLength(String minutes, String seconds){
        int minutesAsInteger;
        int secondsAsInteger;
        try {
            minutesAsInteger = Integer.parseInt(minutes);
            secondsAsInteger = Integer.parseInt(seconds);
        } catch (NumberFormatException nfe){
            throw new InvalidSongLengthException();
        }
        this.setSongMinutes(minutesAsInteger);
        this.setSongSeconds(secondsAsInteger);
    }
}
