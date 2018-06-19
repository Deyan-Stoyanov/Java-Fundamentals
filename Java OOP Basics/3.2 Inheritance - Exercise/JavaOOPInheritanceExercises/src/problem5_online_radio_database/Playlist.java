package problem5_online_radio_database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private List<Song> songs;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    public Playlist() {
        this.songs = new ArrayList<>();
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public void addSong(Song song){
        this.songs.add(song);
        this.seconds += song.getSongSeconds();
        this.minutes += song.getSongMinutes();
    }

    private void calculateOverallTime(){
        while(this.seconds >= 60) {
            this.seconds -= 60;
            this.minutes++;
        }
        while(this.minutes >= 60) {
            this.minutes -= 60;
            this.hours++;
        }
    }

    protected List<Song> getSongs() {
        return Collections.unmodifiableList(this.songs);
    }

    protected Integer getHours() {
        return hours;
    }

    protected Integer getMinutes() {
        return minutes;
    }

    protected Integer getSeconds() {
        return seconds;
    }

    protected int getSongCount(){
        return this.songs.size();
    }

    @Override
    public String toString() {
        this.calculateOverallTime();
        return String.format("Playlist length: %dh %dm %ds", this.getHours(), this.getMinutes(), this.getSeconds());
    }
}
