package com.scottsu.smovie.module.search;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Transition;

import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.search
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 17:18
 **/
public class SearchActivity extends BaseActivity<SearchContract.View, SearchContract.Presenter>
        implements SearchContract.View
{
    @Override
    protected boolean subscribeEvents()
    {
        return false;
    }

    @Override
    protected int provideContentLayoutRes()
    {
        return R.layout.activity_search;
    }

    @Override
    protected SearchContract.Presenter providePresenter()
    {
        return new SearchPresenter();
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setSharedElementEnterTransition(getWindow().getSharedElementEnterTransition().excludeTarget(android.R.id.statusBarBackground,true));
            getWindow().setSharedElementEnterTransition(getWindow().getSharedElementEnterTransition().excludeTarget(android.R.id.navigationBarBackground,true));
        }

        getPresenter().subscribe(this);
    }

}
