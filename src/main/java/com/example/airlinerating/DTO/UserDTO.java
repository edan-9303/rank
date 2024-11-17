package com.example.airlinerating.DTO;

public class UserDTO {
    String email;
    String name;
    String nickName;
    String profilePictureUrl;
    int rating;
    TierDTO tier;

    public UserDTO(String email, String name, String nickName, String profilePictureUrl, int rating, TierDTO tier) {
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.profilePictureUrl = profilePictureUrl;
        this.rating = rating;
        this.tier = tier;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public TierDTO getTier() {
        return tier;
    }

    public void setTier(TierDTO tierDTO) {
        this.tier = tierDTO;
    }
}
