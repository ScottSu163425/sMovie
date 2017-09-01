package com.scottsu.smovie.module.moviedetail;

import com.scottsu.library.mvp.presenter.BaseMvpPresenter;
import com.scottsu.smovie.data.enity.MovieDetailResponseEntity;
import com.scottsu.smovie.data.source.remote.Api;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail
 * description:
 * author: Su
 * date: 2017/9/1 21:27
 */

public class MovieDetailPresenter extends BaseMvpPresenter<MovieDetailContract.View>
        implements MovieDetailContract.Presenter {
    @Override
    public void onViewSubscribed() {

    }

    @Override
    public void requestMovieDetail(String movieId) {
        Api.requestMovieDetail(movieId)
                .subscribe(new Observer<MovieDetailResponseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDetailResponseEntity value) {
                        if (!isInSubscription()) {
                            return;
                        }

                        getView().onRequestSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isInSubscription()) {
                            return;
                        }

                        getView().onRequestFailed();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
