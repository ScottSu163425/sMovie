package com.scottsu.smovie.module.moviedetail.celebrity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.Celebrity
 * description:
 * author: Su
 * date: 2017/9/2 10:52
 */

@Entity(nameInDb = "")
public class Celebrity {
    @Id
    private String id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "avatar")
    private String avatar;

    @Property(nameInDb = "url")
    private String url;

    public Celebrity() {
    }

    public Celebrity(String name, String avatar, String url) {
        this.name = name;
        this.avatar = avatar;
        this.url = url;
    }

    @Generated(hash = 1200019402)
    public Celebrity(String id, String name, String avatar, String url) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.url = url;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
