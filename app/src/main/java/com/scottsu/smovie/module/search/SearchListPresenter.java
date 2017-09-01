package com.scottsu.smovie.module.search;

import com.scottsu.library.mvp.presenter.BaseMvpPresenter;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.data.enity.SearchResponseEntity;
import com.scottsu.smovie.data.source.remote.Api;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.search
 * description:
 * author: Su
 * date: 2017/9/1 9:55
 */

public class SearchListPresenter extends BaseMvpPresenter<SearchListContract.View>
        implements SearchListContract.Presenter {

    @Override
    public void onViewSubscribed() {

    }

    @Override
    public void requestListData(final int start, final int count, final boolean showLoading, final boolean loadMore) {
        if (!getView().checkConnection()) {
            return;
        }

        Api.requestSearch(getView().getSearchKeyword(), start, count)
                .subscribe(new Observer<SearchResponseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (showLoading) {
                            getView().showLoading();
                        }
                    }

                    @Override
                    public void onNext(SearchResponseEntity value) {
                        if (!isInSubscription()) {
                            return;
                        }

                        List<MovieSubject> list = value.getSubjects();

//                        if (list.isEmpty()) {
//                            if (!loadMore) {
//                                getView().showEmpty();
//                            }
//
//                            getView().setSearchSuccess(false);
//                        } else {
//                            getView().showContent();
//                            getView().setSearchSuccess(true);
//                        }

                        boolean hasNext = count == list.size() && (start + count + 1) < value.getTotal();

                        getView().showListData(value.getSubjects(), loadMore, hasNext);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isInSubscription()) {
                            return;
                        }

                        getView().showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
