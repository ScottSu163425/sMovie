package com.scottsu.smovie.module.moviedetail.photos;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail.photos
 * description:
 * author: Su
 * date: 2017/9/8 11:55
 */

public class MoviePhoto {
    private String cover;
    private String bigImage;

    public MoviePhoto(String cover, String bigImage) {
        this.cover = cover;
        this.bigImage = bigImage;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }
}
