import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentlyPlayedStoreTest {
    private RecentlyPlayedStore store;

    @BeforeEach
    public void setUp() {
        store = new RecentlyPlayedStore(3);
    }

    @Test
    public void testAddSongAndFetchRecentlyPlayedSongs() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");

        List<String> expected = Arrays.asList("S1", "S2", "S3");
        assertEquals(expected, store.getRecentlyPlayedSongs("user1"));

        store.addSong("user1", "S4");
        expected = Arrays.asList("S2", "S3", "S4");
        assertEquals(expected, store.getRecentlyPlayedSongs("user1"));

        store.addSong("user1", "S2");
        expected = Arrays.asList("S3", "S4", "S2");
        assertEquals(expected, store.getRecentlyPlayedSongs("user1"));

        store.addSong("user1", "S1");
        expected = Arrays.asList("S4", "S2", "S1");
        assertEquals(expected, store.getRecentlyPlayedSongs("user1"));
    }

    @Test
    public void testDifferentUsers() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user2", "S3");
        store.addSong("user2", "S4");

        List<String> expectedUser1 = Arrays.asList("S1", "S2");
        List<String> expectedUser2 = Arrays.asList("S3", "S4");

        assertEquals(expectedUser1, store.getRecentlyPlayedSongs("user1"));
        assertEquals(expectedUser2, store.getRecentlyPlayedSongs("user2"));
    }

    @Test
    public void testCapacity() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        store.addSong("user1", "S4");
        store.addSong("user1", "S5");

        List<String> expected = Arrays.asList("S3", "S4", "S5");
        assertEquals(expected, store.getRecentlyPlayedSongs("user1"));
    }
}
