package com.scottsu.smovie.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.scottsu.library.mvp.activity.MvpActivity;
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
 * date: 2017/8/27 11:01
 */

public abstract class BaseActivity<V extends IMvpView, P extends IMvpPresenter<V>>
        extends MvpActivity<V, P>
        implements BaseView, View.OnClickListener {

    protected abstract View provideSnackBarParent();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (subscribeEvents()) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (subscribeEvents()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onClick(View v) {

    }

    protected void postEvent(Object event) {
        EventBus.getDefault().post(event);
    }

    @Override
    public boolean checkConnection() {
        if (NetworkUtil.isNetworkConnected(BaseActivity.this)) {
            return true;
        }

        showSnackbar(getString(R.string.bad_connection));

        return false;
    }

    protected boolean subscribeEvents() {
        return false;
    }

    protected View getContentView() {
        return findViewById(android.R.id.content);
    }

    protected void showSnackbar(String text) {
        Snack.showShort(provideSnackBarParent(), text);
    }

    protected void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

}
