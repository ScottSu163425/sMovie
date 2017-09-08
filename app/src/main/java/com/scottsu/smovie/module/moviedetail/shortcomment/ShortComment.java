package com.scottsu.smovie.module.moviedetail.shortcomment;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail.shortcomment
 * description:
 * author: Su
 * date: 2017/9/8 16:27
 */

public class ShortComment {
    private String userName;
    private String avatar;
    private String date;
    private float rating;
    private String content;


    public ShortComment() {
    }

    public ShortComment(String userName, String avatar, String date, float rating, String content) {
        this.userName = userName;
        this.avatar = avatar;
        this.date = date;
        this.rating = rating;
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
