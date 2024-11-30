package com.example.airlinerating.DTO;

public class UserDTO {
    String email;
    String name;
    String nickName;
    String profilePictureUrl;
    double rating;
    TierDTO tier;

    String title;

    public UserDTO(String email, String name, String nickName, String profilePictureUrl, int rating, TierDTO tier, String title) {
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.profilePictureUrl = profilePictureUrl;
        this.rating = rating;
        this.tier = tier;
        this.title = title;
    }

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public void setRating(double rating) {
        this.rating = rating;
    }

    public TierDTO getTier() {
        return tier;
    }

    public void setTier(TierDTO tierDTO) {
        this.tier = tierDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
