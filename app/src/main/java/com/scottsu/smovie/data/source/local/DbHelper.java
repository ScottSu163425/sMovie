package com.scottsu.smovie.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

//import com.scottsu.smovie.data.enity.DaoMaster;
//import com.scottsu.smovie.data.enity.DaoSession;

/**
 * project: sMovie
 * package: com.scottsu.smovie.data.source.local
 * description:
 * author: Su
 * date: 2017/9/1 14:35
 */

public class DbHelper {
    private static final String DB_NAME = "FavoriteMovies.db";
    private static DaoMaster.DevOpenHelper sOpenHelper;
    private static SQLiteDatabase sDb;
    private static DaoMaster sDaoMaster;
    private static DbHelper sInstance;
    private DaoSession mDaoSession;


    public static void init(Context context) {
        if (sDaoMaster == null) {
            sOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
            sDb = sOpenHelper.getWritableDatabase();
            sDaoMaster = new DaoMaster(sDb);
        }
    }

    public static DbHelper getsInstance() {
        if (sInstance == null) {

            synchronized (DbHelper.class) {
                if (sInstance == null) {
                    sInstance = new DbHelper();
                }
            }
        }
        return sInstance;
    }

    private DbHelper() {
    }

    public DaoSession getsDaoSession() {
        if (mDaoSession == null) {
            mDaoSession = sDaoMaster.newSession();
        }
        return mDaoSession;
    }

}
