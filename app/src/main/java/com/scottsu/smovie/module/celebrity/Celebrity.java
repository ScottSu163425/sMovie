package com.scottsu.smovie.module.celebrity;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.Celebrity
 * description:
 * author: Su
 * date: 2017/9/2 10:52
 */

public class Celebrity {
    private String id;
    private String name;
    private String avatar;
    private String url;

    public Celebrity() {
    }

    public Celebrity(String id, String name, String avatar, String url) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
