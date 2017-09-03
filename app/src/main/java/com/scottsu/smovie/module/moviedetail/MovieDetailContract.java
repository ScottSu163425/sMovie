package com.scottsu.smovie.module.moviedetail;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;
import com.scottsu.smovie.data.enity.MovieDetailResponseEntity;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.module.celebrity.Celebrity;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail
 * description:
 * author: Su
 * date: 2017/9/1 21:26
 */

public interface MovieDetailContract {
    interface View extends IMvpView {
        void onRequestDetailSuccess(MovieDetailResponseEntity responseEntity);

        void onRequestDetailFailed(String message);

        void onFavoriteMovieSuccess();

        void onFavoriteMovieExists();
    }

    interface Presenter extends IMvpPresenter<MovieDetailContract.View> {
        void requestMovieDetail(String movieId);

        void favoriteMovie(MovieSubject movie);

        void favoriteCelebrity(Celebrity celebrity);
    }

}
