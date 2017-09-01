package com.scottsu.smovie.data.source.remote;

import com.scottsu.smovie.data.enity.ComingSoonResponseEntity;
import com.scottsu.smovie.data.enity.HotResponseEntity;
import com.scottsu.smovie.data.enity.MovieDetailResponseEntity;
import com.scottsu.smovie.data.enity.SearchResponseEntity;
import com.scottsu.smovie.data.enity.Top250ResponseEntity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * package: com.scottsu.smovie.data.source.remote
 * description:
 * author: Su
 * date: 2017/8/27 11:13
 */

public class Api {
    private static final String API_KEY = "0b2bdeda43b5688921839c8ecb20399b";


    private static ApiService getApiService() {
        return RetrofitClient.getInstance().createService(ApiService.class);
    }

    private static <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static Observable<HotResponseEntity> requestHot(int start, int count) {
        return getApiService().requestHot(API_KEY,start, count)
                .compose(Api.<HotResponseEntity>applySchedulers());
    }

    public static Observable<Top250ResponseEntity> requestTop250(int start, int count) {
        return getApiService().requestTop250(API_KEY,start, count)
                .compose(Api.<Top250ResponseEntity>applySchedulers());
    }

    public static Observable<ComingSoonResponseEntity> requestComingSoon(int start, int count) {
        return getApiService().requestComingSoon(API_KEY,start, count)
                .compose(Api.<ComingSoonResponseEntity>applySchedulers());
    }

    public static Observable<SearchResponseEntity> requestSearch(String keyword, int start, int count) {
        return getApiService().requestSearch(API_KEY,keyword, start, count)
                .compose(Api.<SearchResponseEntity>applySchedulers());
    }

    public static Observable<MovieDetailResponseEntity> requestDetail(String movieId) {
        return getApiService().requestDetail(API_KEY,movieId)
                .compose(Api.<MovieDetailResponseEntity>applySchedulers());
    }

}
