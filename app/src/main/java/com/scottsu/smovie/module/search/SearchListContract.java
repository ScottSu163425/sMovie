package com.scottsu.smovie.module.search;

import com.scottsu.library.mvp.presenter.IListPresenter;
import com.scottsu.smovie.base.BaseListView;
import com.scottsu.smovie.data.enity.MovieSubject;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.search
 * description:
 * author: Su
 * date: 2017/9/1 9:52
 */

public interface SearchListContract {

    interface View extends BaseListView<MovieSubject> {
        String getSearchKeyword();
    }

    interface Presenter extends IListPresenter<MovieSubject, SearchListContract.View> {
    }

}
