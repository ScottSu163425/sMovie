package com.scottsu.smovie.module.comingsoon;

import com.scottsu.library.mvp.presenter.BaseMvpPresenter;
import com.scottsu.smovie.data.source.ComingSoonResponseEntity;
import com.scottsu.smovie.data.source.MovieSubject;
import com.scottsu.smovie.data.source.remote.Api;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.comingsoon
 * description:
 * author: Su
 * date: 2017/9/1 9:25
 */

public class ComingSoonPresenter extends BaseMvpPresenter<ComingSoonContract.View>
        implements ComingSoonContract.Presenter {

    @Override
    public void onViewSubscribed() {

    }

    @Override
    public void requestListData(final int start, final int count, final boolean showLoading, final boolean loadMore) {
        if (!getView().checkConnection()) {
            return;
        }

        Api.requestComingSoon(start, count)
                .subscribe(new Observer<ComingSoonResponseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (showLoading) {
                            getView().showLoading();
                        }
                    }

                    @Override
                    public void onNext(ComingSoonResponseEntity value) {
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

