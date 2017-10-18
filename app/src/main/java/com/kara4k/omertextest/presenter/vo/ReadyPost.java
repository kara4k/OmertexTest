package com.kara4k.omertextest.presenter.vo;


import java.io.Serializable;

public class ReadyPost implements Serializable {

    public static final long serialVersionUID = 42L;

    private String mBody;
    private Long mId;
    private String mTitle;
    private Long mUserId;
    private String mThumbUrl;
    private String mPhotoSmallUrl;

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getThumbUrl() {
        return mThumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        mThumbUrl = thumbUrl;
    }

    public String getPhotoSmallUrl() {
        return mPhotoSmallUrl;
    }

    public void setPhotoSmallUrl(String photoSmallUrl) {
        mPhotoSmallUrl = photoSmallUrl;
    }
}
