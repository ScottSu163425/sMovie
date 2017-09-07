package com.scottsu.smovie.base;

import android.content.Context;
import android.view.View;

import com.scottsu.library.mvp.fragment.MvpFragment;
import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;
import com.scottsu.smovie.R;
import com.scottsu.utils.NetworkUtil;
import com.scottsu.utils.Snack;

import org.greenrobot.eventbus.EventBus;

/**
 * package: com.scottsu.smovie.base
 * description:
 * author: Su
 * date: 2017/8/27 17:03
 */

public abstract class BaseFragment<V extends IMvpView, P extends IMvpPresenter<V>>
        extends MvpFragment<V, P>
        implements BaseView, View.OnClickListener {

    protected boolean subscribeEvents() {
        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (subscribeEvents()) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (subscribeEvents()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onClick(View v) {

    }

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
