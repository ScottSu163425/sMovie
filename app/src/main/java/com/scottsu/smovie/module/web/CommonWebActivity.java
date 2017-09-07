package com.scottsu.smovie.module.web;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.web
 * description:
 * author: Su
 * date: 2017/9/3 9:39
 */

public class CommonWebActivity extends BaseActivity {
    public static final String KEY_EXTRA_URL = "KEY_EXTRA_URL";
    private WebView mWebView;
    private ProgressBar mProgressBar;


    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_common_web;
    }

    @Override
    protected IMvpPresenter providePresenter() {
        return null;
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (isLollipop()) {
            getWindow().setEnterTransition(new Explode());
        }

        mWebView = (WebView) findViewById(R.id.wv);
        mProgressBar = (ProgressBar) findViewById(R.id.pb);

        //Setup toolbar.
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Setup web view.
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                if (newProgress < 100) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                } else {
                    mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }
        });

        mWebView.loadUrl(getIntent().getStringExtra(KEY_EXTRA_URL));
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected View provideSnackBarParent() {
        return mProgressBar;
    }
}
