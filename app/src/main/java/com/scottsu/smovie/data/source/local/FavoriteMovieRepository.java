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

public class FavoriteMovieRepository implements FavoritestDataSource<MovieSubject> {
    private static final Gson sGson = new Gson();

    private List<MovieSubject> convert(List<MovieSubjectInDB> list) {
        List<MovieSubject> result = new ArrayList<>();

        for (int i = 0, n = list.size(); i < n; i++) {
            result.add(sGson.fromJson(list.get(i).getJson(), MovieSubject.class));
        }
        return result;
    }


    @Override
    public boolean save(MovieSubject entity) {
        if (isExist(entity)) {
            return false;
        }

        MovieSubjectDbHelper.getDaoSession()
                .getMovieSubjectInDBDao()
                .save(new MovieSubjectInDB(sGson.toJson(entity)));
        return true;
    }

    @Override
    public boolean save(List<MovieSubject> entities) {
        return true;
    }

    @Override
    public boolean remove(MovieSubject entity) {
        return false;
    }

    @Override
    public boolean remove(Judgment<MovieSubject> judgment) {
        return false;
    }

    @Override
    public boolean remove(List<MovieSubject> entities) {
        return false;
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
        List<MovieSubjectInDB> all = MovieSubjectDbHelper.getDaoSession()
                .getMovieSubjectInDBDao()
                .loadAll();

        if (null == all) {
            all = new ArrayList<>();
        }

        return convert(all);
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
        MovieSubjectDbHelper.getDaoSession().getMovieSubjectInDBDao().deleteAll();
        return true;
    }


}
