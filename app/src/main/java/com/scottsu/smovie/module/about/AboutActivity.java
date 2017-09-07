package com.scottsu.smovie.module.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.View;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.utils.ViewUtil;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.about
 * description:
 * author: Su
 * date: 2017/9/7 19:47
 */

public class AboutActivity extends BaseActivity {

    private View mAuthorView, mVersionView, mProjectPageView;


    @Override
    protected View provideSnackBarParent() {
        return null;
    }

    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_about;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(getString(R.string.action_about));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mAuthorView = findViewById(R.id.fl_author);
        mVersionView = findViewById(R.id.fl_version);
        mProjectPageView = findViewById(R.id.fl_project_page);

        mProjectPageView.setOnClickListener(this);
        mVersionView.setOnClickListener(this);
        mAuthorView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (ViewUtil.isFastClick()) {
            return;
        }

        if (v == mAuthorView) {
            openBrowser(getString(R.string.url_author));
        } else if (v == mProjectPageView) {
            openBrowser(getString(R.string.url_project));
        }

    }

    private void openBrowser(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        startActivity(Intent.createChooser(intent, getString(R.string.choose_browser)));
    }


}
