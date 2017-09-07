package com.scottsu.smovie.module.favorites.celebrity;

import com.scottsu.library.mvp.presenter.BaseMvpPresenter;
import com.scottsu.smovie.data.source.local.FavoriteCelebrityRepository;
import com.scottsu.smovie.module.celebrity.Celebrity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.celebrity
 * description:
 * author: Su
 * date: 2017/9/7 10:00
 */

public class FavoriteCelebrityPresenter extends BaseMvpPresenter<FavoriteCelebrityContract.View>
        implements FavoriteCelebrityContract.Presenter {

    private FavoriteCelebrityRepository mFavoriteCelebrityRepository;

    public FavoriteCelebrityPresenter() {
        mFavoriteCelebrityRepository = new FavoriteCelebrityRepository();
    }

    @Override
    public void requestListData(int start, int count, final boolean showLoading, boolean loadMore) {
        Observable.create(new ObservableOnSubscribe<List<Celebrity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Celebrity>> e) throws Exception {
                e.onNext(mFavoriteCelebrityRepository.queryAll());
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
                .subscribe(new Observer<List<Celebrity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Celebrity> value) {
                        getView().showListData(value, false, false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onViewSubscribed() {

    }

    @Override
    public void removeMovie(Celebrity celebrity, int position) {
        if (mFavoriteCelebrityRepository.remove(celebrity)) {
            getView().onMovieRemoved(celebrity, position);
        }
    }

}
