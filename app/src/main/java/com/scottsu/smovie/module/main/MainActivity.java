package com.scottsu.smovie.module.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.common.events.ListDraggingEvent;
import com.scottsu.smovie.common.events.ListReleasedEvent;
import com.scottsu.smovie.common.events.ScrollToTopEvent;
import com.scottsu.smovie.module.drawernavigation.DrawerNavigationFragment;
import com.scottsu.smovie.module.search.SearchActivity;
import com.scottsu.smovie.module.top250.Top250Fragment;
import com.scottsu.utils.ActivityLauncher;
import com.scottsu.utils.FragmentUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * package: com.scottsu.smovie.module.main
 * description:
 * author: Su
 * date: 2017/8/27 10:21
 */
public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View
{

    private static final int ID_MAIN_CONTENT_CONTAINER = R.id.fl_container_main_content;

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private CardView mSearchCardView;
    private View mSearchCardIcon;
    private FloatingActionButton mFab;

    /*Content Fragments.*/
    private Top250Fragment mTop250Fragment;


    @Override
    protected int provideContentLayoutRes()
    {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.Presenter providePresenter()
    {
        return new MainPresenter();
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mSearchCardView = (CardView) findViewById(R.id.card_search);
        mSearchCardIcon = findViewById(R.id.iv_search_icon);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        //init toolbar.
        mToolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(mToolbar);

        //init drawer.
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);

        mTop250Fragment = Top250Fragment.newInstance();
        FragmentUtil.show(MainActivity.this, ID_MAIN_CONTENT_CONTAINER, mTop250Fragment);

        mSearchCardView.setOnClickListener(this);
        mFab.setOnClickListener(this);

        StatusBarUtil.setColorForDrawerLayout(MainActivity.this, mDrawerLayout,
                ContextCompat.getColor(this,R.color.colorPrimary),60);

        getPresenter().subscribe(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();


        return true;
    }

    private void openDrawer()
    {
        mDrawerLayout.openDrawer(Gravity.START);
    }

    private void closeDrawer()
    {
        mDrawerLayout.closeDrawer(Gravity.START);
    }

    private void openSearch()
    {

    }

    @Override
    public void onClick(View view)
    {
        if (mFab == view)
        {
            notifyScrollToTop();
        } else if (mSearchCardView == view)
        {
            launchSearch();
        }
    }

    private void notifyScrollToTop()
    {
        postEvent(new ScrollToTopEvent());
    }

    private void launchSearch()
    {
        ActivityLauncher.launchWithSharedElements(MainActivity.this,
                new Intent(MainActivity.this,SearchActivity.class),
                new View[]{mSearchCardView,mSearchCardIcon},
                new String[]{ViewCompat.getTransitionName(mSearchCardView),ViewCompat.getTransitionName(mSearchCardIcon)});
    }

    @Subscribe
    public void onListDragging(ListDraggingEvent event)
    {
        hideFAB();
    }

    @Subscribe
    public void onListReleased(ListReleasedEvent event)
    {
        showFAB();
    }

    private void showFAB()
    {
        mFab.animate()
                .translationY(0)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(600)
                .start();
    }

    private void hideFAB()
    {
        mFab.animate()
                .translationY(mFab.getBottom())
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(600)
                .start();
    }

    @Override
    protected boolean subscribeEvents()
    {
        return true;
    }

}
