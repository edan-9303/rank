package com.example.airlinerating.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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
    private String gameDate;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Game(String gameId, String email, int ranking, int rebuyins, String gameDate) {
        this.gameId = gameId;
        this.email = email;
        this.ranking = ranking;
        this.rebuyins = rebuyins;
        this.gameDate = gameDate;
    }

    public Game() {

    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
