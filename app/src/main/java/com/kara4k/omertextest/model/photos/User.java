
package com.kara4k.omertextest.model.photos;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class User {

    @SerializedName("bio")
    private String mBio;
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("id")
    private String mId;
    @SerializedName("last_name")
    private String mLastName;
    @SerializedName("links")
    private Links mLinks;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("name")
    private String mName;
    @SerializedName("portfolio_url")
    private String mPortfolioUrl;
    @SerializedName("profile_image")
    private ProfileImage mProfileImage;
    @SerializedName("total_collections")
    private Long mTotalCollections;
    @SerializedName("total_likes")
    private Long mTotalLikes;
    @SerializedName("total_photos")
    private Long mTotalPhotos;
    @SerializedName("twitter_username")
    private Object mTwitterUsername;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("username")
    private String mUsername;

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public Links getLinks() {
        return mLinks;
    }

    public void setLinks(Links links) {
        mLinks = links;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPortfolioUrl() {
        return mPortfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        mPortfolioUrl = portfolioUrl;
    }

    public ProfileImage getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        mProfileImage = profileImage;
    }

    public Long getTotalCollections() {
        return mTotalCollections;
    }

    public void setTotalCollections(Long totalCollections) {
        mTotalCollections = totalCollections;
    }

    public Long getTotalLikes() {
        return mTotalLikes;
    }

    public void setTotalLikes(Long totalLikes) {
        mTotalLikes = totalLikes;
    }

    public Long getTotalPhotos() {
        return mTotalPhotos;
    }

    public void setTotalPhotos(Long totalPhotos) {
        mTotalPhotos = totalPhotos;
    }

    public Object getTwitterUsername() {
        return mTwitterUsername;
    }

    public void setTwitterUsername(Object twitterUsername) {
        mTwitterUsername = twitterUsername;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

}
