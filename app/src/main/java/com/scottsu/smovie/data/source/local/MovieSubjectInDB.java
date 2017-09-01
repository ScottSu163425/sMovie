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
 * date: 2017/9/1 14:51
 */

@Entity
public class MovieSubjectInDB {
    @Id
    private Long id;

    @Property(nameInDb = "json")
    private String json;

    public MovieSubjectInDB(String json) {
        this.json = json;
    }

    @Generated(hash = 1466674125)
    public MovieSubjectInDB(Long id, String json) {
        this.id = id;
        this.json = json;
    }

    @Generated(hash = 318746104)
    public MovieSubjectInDB() {
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
