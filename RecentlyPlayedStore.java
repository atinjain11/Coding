import java.util.*;

public class RecentlyPlayedStore {
    private final int capacity;
    private final Map<String, LinkedList<String>> userSongsMap;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.userSongsMap = new HashMap<>();
    }

    public void addSong(String user, String song) {
        LinkedList<String> songs = userSongsMap.getOrDefault(user, new LinkedList<>());

        if (songs.contains(song)) {
            songs.remove(song);
        } else if (songs.size() == capacity) {
            songs.removeFirst();
        }

        songs.addLast(song);
        userSongsMap.put(user, songs);
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        return userSongsMap.getOrDefault(user, new LinkedList<>());
    }
}
