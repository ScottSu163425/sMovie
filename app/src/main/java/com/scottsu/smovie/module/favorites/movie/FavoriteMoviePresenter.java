package com.scottsu.smovie.module.favorites.movie;


import com.scottsu.library.mvp.presenter.BaseMvpPresenter;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.data.source.local.FavoriteMovieRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.movie
 * description:
 * author: Su
 * date: 2017/9/5 21:00
 */

public class FavoriteMoviePresenter extends BaseMvpPresenter<FavoriteMovieContract.View>
        implements FavoriteMovieContract.Presenter {
    private FavoriteMovieRepository mFavoriteMovieRepository;


    public FavoriteMoviePresenter() {
        mFavoriteMovieRepository = new FavoriteMovieRepository();
    }

    @Override
    public void requestListData(int start, int count, final boolean showLoading, boolean loadMore) {
        Observable.create(new ObservableOnSubscribe<List<MovieSubject>>() {
            @Override
            public void subscribe(ObservableEmitter<List<MovieSubject>> e) throws Exception {
                e.onNext(mFavoriteMovieRepository.queryAll());
            }
        })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (showLoading) {
                            getView().showLoading();
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MovieSubject>>() {
                    @Override
                    public void accept(List<MovieSubject> movieSubjects) throws Exception {
                        getView().showListData(movieSubjects,false,false);
                    }
                });
    }

    @Override
    public void onViewSubscribed() {

    }
}
