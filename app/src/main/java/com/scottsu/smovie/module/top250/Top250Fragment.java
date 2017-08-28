package com.scottsu.smovie.module.top250;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseFragment;

/**
 * package: com.scottsu.smovie.module.top250
 * description:
 * author: Su
 * date: 2017/8/27 17:10
 */

public class Top250Fragment extends BaseFragment<Top250Contract.View,Top250Contract.Presenter> {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private Top250ListAdapter mListAdapter;



    public static Top250Fragment newInstance() {
        Top250Fragment fragment = new Top250Fragment();
        return fragment;
    }

    @Override
    protected int provideContentLayoutRes() {
        return R.layout.fragment_top_250;
    }

    @Override
    protected Top250Contract.Presenter providePresenter()
    {
return null;
    }


    @Override
    protected void onFragmentCreated() {
        showSnackbar("Top 250!");
    }

}
