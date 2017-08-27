package com.scottsu.smovie.base;

import android.view.View;

import com.scottsu.library.mvp.fragment.MvpFragment;
import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;
import com.scottsu.smovie.R;
import com.scottsu.utils.NetworkUtil;
import com.scottsu.utils.Snack;

/**
 * package: com.scottsu.smovie.base
 * description:
 * author: Su
 * date: 2017/8/27 17:03
 */

public abstract class BaseFragment<V extends IMvpView, P extends IMvpPresenter<V>>
        extends MvpFragment<V, P>
        implements BaseView{

    @Override
    public boolean checkConnection() {
        if (NetworkUtil.isNetworkConnected(getActivity())) {
            return true;
        }

        showSnackbar(getString(R.string.bad_connection));

        return false;
    }

    protected View getContentView() {
        return getView();
    }

    protected void showSnackbar(String text) {
        Snack.showShort(getContentView(), text);
    }

}
