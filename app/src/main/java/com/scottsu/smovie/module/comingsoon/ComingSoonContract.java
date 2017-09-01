package com.scottsu.smovie.module.comingsoon;

import com.scottsu.library.mvp.presenter.IListPresenter;
import com.scottsu.smovie.base.BaseListView;
import com.scottsu.smovie.data.source.MovieSubject;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.comingsoon
 * description:
 * author: Su
 * date: 2017/9/1 9:23
 */

public interface ComingSoonContract {
    interface View extends BaseListView<MovieSubject> {

    }

    interface Presenter extends IListPresenter<MovieSubject, ComingSoonContract.View> {

    }
}
