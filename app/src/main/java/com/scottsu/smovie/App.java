package com.scottsu.smovie;

import android.app.Application;

import com.scottsu.smovie.data.source.local.DbHelper;

/**
 * project: sMovie
 * package: com.scottsu.smovie
 * description:
 * author: Su
 * date: 2017/9/1 14:44
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        DbHelper.init(this);
    }

}
