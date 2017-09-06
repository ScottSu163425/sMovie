package com.scottsu.smovie.data.source.local;

import com.scottsu.slist.library.interfaces.Judgment;
import com.scottsu.smovie.module.celebrity.Celebrity;

import java.util.ArrayList;
import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.data.source.local
 * description:
 * author: Su
 * date: 2017/9/6 22:32
 */

public class FavoriteCelebrityRepository implements IFavoritestDataSource<Celebrity> {

    @Override
    public boolean save(Celebrity entity) {
        if (isExist(entity)) {
            return false;
        }

        DbHelper.getsInstance()
                .getsDaoSession()
                .getCelebrityDao()
                .insert(entity);

        return true;
    }

    @Override
    public boolean save(List<Celebrity> entities) {
        for (int i = 0, n = entities.size(); i < n; i++) {
            save(entities.get(i));
        }

        return true;
    }

    @Override
    public boolean remove(Celebrity entity) {
        if (isExist(entity)) {
            DbHelper.getsInstance().getsDaoSession()
                    .getCelebrityDao()
                    .delete(entity);
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Judgment<Celebrity> judgment) {
        return remove(query(judgment));
    }

    @Override
    public boolean remove(List<Celebrity> entities) {
        for (int i = 0, n = entities.size(); i < n; i++) {
            remove(entities.get(i));
        }

        return true;
    }

    @Override
    public boolean update(Celebrity entity) {
        return false;
    }

    @Override
    public boolean isExist(final Celebrity entity) {
        return query(new Judgment<Celebrity>() {
            @Override
            public boolean test(Celebrity obj) {
                return obj.getId().equals(entity.getId());
            }
        }).size() > 0;
    }

    @Override
    public List<Celebrity> queryAll() {

        List<Celebrity> all = DbHelper.getsInstance()
                .getsDaoSession()
                .getCelebrityDao()
                .loadAll();

        if (all == null) {
            all = new ArrayList<>();
        }
        return all;
    }

    @Override
    public List<Celebrity> query(Judgment<Celebrity> judgment) {
        List<Celebrity> all = queryAll();
        List<Celebrity> result = new ArrayList<>();

        for (int i = 0, n = all.size(); i < n; i++) {
            Celebrity Celebrity = all.get(i);

            if (judgment.test(all.get(i))) {
                result.add(Celebrity);
            }
        }

        return result;
    }

    @Override
    public boolean clear() {
        DbHelper.getsInstance().getsDaoSession()
                .getCelebrityDao()
                .deleteAll();
        return true;
    }


}
