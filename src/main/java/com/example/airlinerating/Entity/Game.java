package com.example.airlinerating.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entryId;

    private String gameId;
    private String email;
    private int ranking;
    private int rebuyins;
    private double earnedRating;
    private double lostRating;

    public Game(String gameId, String email, int ranking, int rebuyins) {
        this.gameId = gameId;
        this.email = email;
        this.ranking = ranking;
        this.rebuyins = rebuyins;
    }

    public Game() {

    }

    public double getEarnedRating() {
        return earnedRating;
    }

    public void setEarnedRating(double earnedRating) {
        this.earnedRating = earnedRating;
    }

    public double getLostRating() {
        return lostRating;
    }

    public void setLostRating(double lostRating) {
        this.lostRating = lostRating;
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    // Getters and Setters
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRebuyins() {
        return rebuyins;
    }

    public void setRebuyins(int rebuyins) {
        this.rebuyins = rebuyins;
    }
}
