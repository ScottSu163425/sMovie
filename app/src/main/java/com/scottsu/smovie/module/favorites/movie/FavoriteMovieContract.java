package com.scottsu.smovie.module.favorites.movie;

import com.scottsu.library.mvp.presenter.IListPresenter;
import com.scottsu.library.mvp.view.IListView;
import com.scottsu.smovie.data.enity.MovieSubject;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.movie
 * description:
 * author: Su
 * date: 2017/9/5 20:59
 */

public interface FavoriteMovieContract {
    interface View extends IListView<MovieSubject> {

    }

    interface Presenter extends IListPresenter<MovieSubject, FavoriteMovieContract.View> {

    }

}
