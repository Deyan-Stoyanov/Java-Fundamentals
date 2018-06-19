package problem5_online_radio_database;

import problem5_online_radio_database.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Playlist playlist = new Playlist();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("[:;]");
            String artistName = data[0];
            String songName = data[1];
            try {
                Song song = new Song(artistName, songName, data[2], data[3]);
                playlist.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException ise){
                System.out.println(ise.getMessage());
            }
        }
        System.out.println("Songs added: " + playlist.getSongCount());
        System.out.println(playlist);
    }
}
