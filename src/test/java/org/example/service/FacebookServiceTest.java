package org.example.service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacebookServiceTest {

    FacebookService service = new FacebookService();

    @Test
    public void testFetchFriendsPositive() {
        String[] expected = {"Alice", "Bob", "Charlie"};
        assertArrayEquals(expected, service.fetchFriends("validProfileLink"));
    }

    @Test
    public void testFetchFriendsNegative() {
        // Assuming an exception is thrown for invalid profile links
        assertThrows(IllegalArgumentException.class, () ->
                service.fetchFriends("invalidProfileLink"));
    }

    @Test
    public void testPerformance() {
        long startTime = System.currentTimeMillis();
        service.fetchFriends("validProfileLink");
        long elapsedTime = System.currentTimeMillis() - startTime;

        // Assume we want the function to return in less than 2 seconds
        assertTrue(elapsedTime < 2000, "Performance test failed");
    }

    @Test
    public void testFetchFriendsWithNullLink() {
        // Assuming an exception is thrown for null profile links
        assertThrows(IllegalArgumentException.class, () -> {
            service.fetchFriends(null);
        });
    }

    @Test
    public void testFetchFriendsWithEmptyLink() {
        // Assuming an exception is thrown for empty profile links
        assertThrows(IllegalArgumentException.class, () -> {
            service.fetchFriends("");
        });
    }

    @Test
    public void testFetchFriendsWithOnlySpaces() {
        // Assuming an exception is thrown for profile links with only spaces
        assertThrows(IllegalArgumentException.class, () -> {
            service.fetchFriends("     ");
        });
    }
}
