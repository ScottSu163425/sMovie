package com.scottsu.smovie.data.source.local;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * project: sMovie
 * package: com.scottsu.smovie.data.source.local
 * description:
 * author: Su
 * date: 2017/9/5 17:44
 */

@Entity
public class MovieSubjectInDb {
    @Id
    private Long id;

    @Property(nameInDb = "json")
    private String json; 

    public MovieSubjectInDb() {
    }

    @Generated(hash = 1732242875)
    public MovieSubjectInDb(Long id, String json) {
        this.id = id;
        this.json = json;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJson() {
        return this.json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
