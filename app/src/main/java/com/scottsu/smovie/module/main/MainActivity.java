package com.scottsu.smovie.module.main;

import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;

/**
 * package: com.scottsu.smovie.module.main
 * description:
 * author: Su
 * date: 2017/8/27 10:21
 */
public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;


    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.Presenter providePresenter() {
        return new MainPresenter(MainActivity.this);
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //init toolbar.
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.app_name));

        setSupportActionBar(mToolbar);

        //init drawer.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();

        mDrawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (R.id.action_search == id) {
            getPresenter().onActionSearchClick();
        }

        return true;
    }

    @Override
    public void openDrawer() {
        mDrawerLayout.openDrawer(Gravity.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawer(Gravity.START);
    }

    @Override
    public void openSearch() {
        Toast.makeText(MainActivity.this, "openSearch", Toast.LENGTH_SHORT).show();
    }

}
