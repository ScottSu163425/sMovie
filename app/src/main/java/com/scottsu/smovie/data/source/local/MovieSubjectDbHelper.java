package com.scottsu.smovie.data.source.local;

import android.content.Context;

/**
 * project: sMovie
 * package: com.scottsu.smovie.data.source.local
 * description:
 * author: Su
 * date: 2017/9/1 14:35
 */

public class MovieSubjectDbHelper {
    private static final String DB_NAME = "FavoriteMovies.db";


    private MovieSubjectDbHelper() {
    }

    private static DaoMaster.DevOpenHelper devOpenHelper;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public static void init(Context context) {
        if (devOpenHelper == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
            daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            daoSession = daoMaster.newSession();
        }
    }

    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            throw new IllegalStateException("You must call init() first.");
        }
        return daoSession;
    }

}
