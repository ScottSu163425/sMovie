package com.scottsu.smovie.module.top250;


import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseFragment;

/**
 * package: com.scottsu.smovie.module.top250
 * description:
 * author: Su
 * date: 2017/8/27 17:10
 */

public class Top250Fragment extends BaseFragment {

    public static Top250Fragment newInstance() {
        Top250Fragment fragment = new Top250Fragment();
        return fragment;
    }

    @Override
    protected int provideContentLayoutRes() {
        return R.layout.fragment_top_250;
    }

    @Override
    protected IMvpPresenter providePresenter() {
        return null;
    }

    @Override
    protected void onFragmentCreated() {
        showSnackbar("Top 250!");
    }

}
