package com.example.airlinerating.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    private String email;

    private String name;

    private String nickName;
    private LocalDateTime ratingUpdatedAt;

    private String profilePictureUrl;
    private double rating;

    private String title;

    public User(String email, String name, String nickName, String profilePictureUrl, int rating, String title) {
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.profilePictureUrl = profilePictureUrl;
        this.rating = rating;
        this.title = "none";
    }


    public User() {

    }

    // Getters and Setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rank) {
        this.rating = rank;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getRatingUpdatedAt() {
        return ratingUpdatedAt;
    }

    public void setRatingUpdatedAt(LocalDateTime ratingUpdatedAt) {
        this.ratingUpdatedAt = ratingUpdatedAt;
    }
}
