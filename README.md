# Recently Played Store

## Overview
This project implements an in-memory store for recently played songs that can accommodate a fixed number of songs per user. It supports adding songs and fetching recently played songs, ensuring that the least recently played songs are eliminated when the store reaches its capacity.

## Requirements
- Java 8 or higher
- JUnit 5 for testing

## Usage

### Adding Songs
To add a song for a user:
```java
RecentlyPlayedStore store = new RecentlyPlayedStore(3);
store.addSong("user1", "S1");
