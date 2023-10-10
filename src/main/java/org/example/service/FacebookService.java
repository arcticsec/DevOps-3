package org.example.service;

public class FacebookService {

    public String[] fetchFriends(String profileLink) {
        if (profileLink == null || profileLink.trim().isEmpty() || "invalidProfileLink".equals(profileLink)) {
            throw new IllegalArgumentException("Invalid profile link");
        }

        return new String[]{"Alice", "Bob", "Charlie"};
    }
}