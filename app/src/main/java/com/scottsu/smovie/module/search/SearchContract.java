package com.scottsu.smovie.module.search;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.search
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 17:19
 **/
public interface SearchContract
{
    interface View extends IMvpView{

    }

    interface Presenter extends IMvpPresenter<SearchContract.View>{

    }
}
