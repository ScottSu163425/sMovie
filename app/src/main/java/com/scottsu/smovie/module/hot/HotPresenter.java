package com.scottsu.smovie.module.hot;

import com.scottsu.library.mvp.presenter.BaseMvpPresenter;
import com.scottsu.smovie.data.source.HotResponseEntity;
import com.scottsu.smovie.data.source.MovieSubject;
import com.scottsu.smovie.data.source.remote.Api;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.hot
 * description:
 * author: Su
 * date: 2017/9/1 8:04
 */

public class HotPresenter extends BaseMvpPresenter<HotContract.View>
        implements HotContract.Presenter {

    @Override
    public void onViewSubscribed() {

    }

    @Override
    public void requestListData(final int start, final int count, final boolean showLoading, final boolean loadMore) {
        if (!getView().checkConnection()) {
            return;
        }

        Api.requestHot(start, count)
                .subscribe(new Observer<HotResponseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (showLoading) {
                            getView().showLoading();
                        }
                    }

                    @Override
                    public void onNext(HotResponseEntity value) {
                        List<MovieSubject> list = value.getSubjects();

                        if (list.isEmpty()) {
                            if (!loadMore) {
                                getView().showEmpty();
                            }
                        } else {
                            getView().showContent();
                        }

                        boolean hasNext = count == list.size() && (start + count + 1) < value.getTotal();

                        getView().showListData(value.getSubjects(), loadMore, hasNext);
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
}
