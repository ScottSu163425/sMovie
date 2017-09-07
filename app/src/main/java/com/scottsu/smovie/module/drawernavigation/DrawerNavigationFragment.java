package com.scottsu.smovie.module.drawernavigation;

import android.view.ViewGroup;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseFragment;
import com.scottsu.utils.ScreenUtil;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.menu
 * 描述:
 * 作者: Su
 * 日期: 2017/8/31 10:01
 **/
public class DrawerNavigationFragment extends BaseFragment
{

    public static DrawerNavigationFragment newInstance()
    {
        DrawerNavigationFragment fragment = new DrawerNavigationFragment();
        return fragment;
    }

    @Override
    protected int provideContentLayoutRes()
    {
        return R.layout.header_drawer_navigation;
    }

    @Override
    protected IMvpPresenter providePresenter()
    {
        return null;
    }

    @Override
    protected void onFragmentCreated()
    {
        ViewGroup.LayoutParams params=getView().getLayoutParams();
        params.width= (int) (ScreenUtil.getScreenWidth(getContext())*0.82);
    }


}
