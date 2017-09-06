package com.scottsu.smovie.data.source.local;

import com.google.gson.Gson;
import com.scottsu.slist.library.interfaces.Judgment;
import com.scottsu.smovie.data.enity.MovieSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.data.source.local
 * description:
 * author: Su
 * date: 2017/9/1 13:56
 */

public class FavoriteMovieRepository implements IFavoritestDataSource<MovieSubject> {
    private static final Gson sGson = new Gson();

    @Override
    public boolean save(MovieSubject entity) {
        if (isExist(entity)) {
            return false;
        }

        DbHelper.getsInstance()
                .getsDaoSession()
                .getMovieSubjectInDbDao()
                .insert(convertToDb(entity));

        return true;
    }

    @Override
    public boolean save(List<MovieSubject> entities) {
        for (int i = 0, n = entities.size(); i < n; i++) {
            save(entities.get(i));
        }
        return true;
    }

    @Override
    public boolean remove(MovieSubject entity) {
        if (isExist(entity)) {
            List<MovieSubjectInDb> dbList = queryAllRaw();
            MovieSubjectInDb target = null;

            for (MovieSubjectInDb subjectInDb : dbList) {
                if (convert(subjectInDb).getId().equals(entity.getId())) {
                    target = subjectInDb;
                }
            }

            if (target != null) {
                DbHelper.getsInstance()
                        .getsDaoSession()
                        .getMovieSubjectInDbDao()
                        .delete(target);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Judgment<MovieSubject> judgment) {
        return remove(query(judgment));
    }

    @Override
    public boolean remove(List<MovieSubject> entities) {
        for (int i = 0, n = entities.size(); i < n; i++) {
            remove(entities.get(i));
        }

        return true;
    }

    @Override
    public boolean update(MovieSubject entity) {
        return false;
    }

    @Override
    public boolean isExist(final MovieSubject entity) {
        return query(new Judgment<MovieSubject>() {
            @Override
            public boolean test(MovieSubject obj) {
                return obj.getId().equals(entity.getId());
            }
        }).size() > 0;
    }

    @Override
    public List<MovieSubject> queryAll() {
        List<MovieSubject> all = new ArrayList<>();

        List<MovieSubjectInDb> dbList = DbHelper.getsInstance()
                .getsDaoSession()
                .getMovieSubjectInDbDao()
                .loadAll();

        for (int i = 0, n = dbList.size(); i < n; i++) {
            all.add(convert(dbList.get(i)));
        }

        return all;
    }

    private List<MovieSubjectInDb> queryAllRaw() {
        List<MovieSubjectInDb> dbList = DbHelper.getsInstance()
                .getsDaoSession()
                .getMovieSubjectInDbDao()
                .loadAll();

        if (dbList == null) {
            dbList = new ArrayList<>();
        }
        return dbList;
    }

    private MovieSubject convert(MovieSubjectInDb subjectInDb) {
        return sGson.fromJson(subjectInDb.getJson(), MovieSubject.class);
    }

    private MovieSubjectInDb convertToDb(MovieSubject subject) {
        MovieSubjectInDb db = new MovieSubjectInDb();
//        db.setId(Long.valueOf(subject.getId()));
        db.setJson(sGson.toJson(subject));
        return db;
    }

    @Override
    public List<MovieSubject> query(Judgment<MovieSubject> judgment) {
        List<MovieSubject> all = queryAll();
        List<MovieSubject> result = new ArrayList<>();

        for (int i = 0, n = all.size(); i < n; i++) {
            MovieSubject movie = all.get(i);

            if (judgment.test(all.get(i))) {
                result.add(movie);
            }
        }

        return result;
    }

    @Override
    public boolean clear() {
        DbHelper.getsInstance()
                .getsDaoSession()
                .getMovieSubjectInDbDao()
                .deleteAll();

        return true;
    }


}
