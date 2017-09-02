package com.scottsu.smovie.module.moviedetail;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;
import com.scottsu.smovie.data.enity.MovieDetailResponseEntity;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail
 * description:
 * author: Su
 * date: 2017/9/1 21:26
 */

public interface MovieDetailContract {
    interface View extends IMvpView {
        void onRequestSuccess(MovieDetailResponseEntity responseEntity);

        void onRequestFailed(String message);
    }

    interface Presenter extends IMvpPresenter<MovieDetailContract.View> {
        void requestMovieDetail(String movieId);
    }

}
