package org.imanity.example.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.UUID;

@Entity // mark this as an Entity
@Table(name = "example") // Specific table
public class ExampleData {

    @Id // mark as the primary key, use this key to get data
    private UUID uuid; // The UUID of a player

    // Example stats to store
    private int kills;
    private int deaths;
    private int wins;

    @Transient // Ignore this field
    private Status status;

    public ExampleData() {
        this.status = Status.IN_LOBBY;
        // EMPTY CONSTRUCTOR ARE REQUIRED
    }

    public ExampleData(UUID uuid) {
        this();
        this.uuid = uuid;
        // Easier way to create data instance
    }

    // Getters and Setters
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static enum Status {

        IN_LOBBY,
        IN_GAME

    }

}
