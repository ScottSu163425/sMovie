package com.scottsu.smovie.data.source.local;

import com.scottsu.slist.library.interfaces.Judgment;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.data.source.local
 * description:
 * author: Su
 * date: 2017/9/1 13:58
 */

public interface IFavoritestDataSource<E> {
    boolean save(E entity);

    boolean save(List<E> entities);

    boolean remove(E entity);

    boolean remove(Judgment<E> judgment);

    boolean remove(List<E> entities);

    boolean update(E entity);

    boolean isExist(E entity);

    List<E> queryAll();

    List<E> query(Judgment<E> judgment);

    boolean clear();
}
