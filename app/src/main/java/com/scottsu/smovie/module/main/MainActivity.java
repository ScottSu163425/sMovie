package com.scottsu.smovie.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.common.events.ListDraggingEvent;
import com.scottsu.smovie.common.events.ListReleasedEvent;
import com.scottsu.smovie.module.comingsoon.ComingSoonFragment;
import com.scottsu.smovie.module.favorites.FavoritesActivity;
import com.scottsu.smovie.module.hot.HotFragment;
import com.scottsu.smovie.module.search.SearchActivity;
import com.scottsu.smovie.module.top250.Top250Fragment;
import com.scottsu.utils.ActivityLauncher;
import com.scottsu.utils.CircularRevealUtil;
import com.scottsu.utils.FragmentUtil;

import org.greenrobot.eventbus.Subscribe;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/**
 * package: com.scottsu.smovie.module.main
 * description:
 * author: Su
 * date: 2017/8/27 10:21
 */
public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View, NavigationView.OnNavigationItemSelectedListener {

    private static final int ID_NAVIGATION_ITEM_HOT = R.id.action_hot;
    private static final int ID_NAVIGATION_ITEM_COMING_SOON = R.id.action_coming_soon;
    private static final int ID_NAVIGATION_ITEM_TOP250 = R.id.action_top250;

    private static final int NAVIGATION_ITEM_HOT = 0x1;
    private static final int NAVIGATION_ITEM_COMING_SOON = 0x2;
    private static final int NAVIGATION_ITEM_TOP250 = 0x3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({NAVIGATION_ITEM_HOT,
            NAVIGATION_ITEM_COMING_SOON,
            NAVIGATION_ITEM_TOP250,
    })

    private @interface NavigationItem {

    }

    private static final Map<Integer, Integer> NAVIGATION_ITEMS = new HashMap<Integer, Integer>() {
        {
            put(NAVIGATION_ITEM_HOT, ID_NAVIGATION_ITEM_HOT);
            put(NAVIGATION_ITEM_COMING_SOON, ID_NAVIGATION_ITEM_COMING_SOON);
            put(NAVIGATION_ITEM_TOP250, ID_NAVIGATION_ITEM_TOP250);
        }
    };

    private static final int ID_MAIN_CONTENT_CONTAINER = R.id.fl_container_main_content;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private CardView mSearchCardView;
    private View mSearchCardIcon;
    private FloatingActionButton mFab;

    /*Content Fragments.*/
    private Fragment mCurrentFragment;
    private HotFragment mHotFragment;
    private ComingSoonFragment mComingSoonFragment;
    private Top250Fragment mTop250Fragment;


    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.Presenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (isLollipop()) {
            getWindow().setEnterTransition(new Slide(Gravity.RIGHT));
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation);

        mSearchCardView = (CardView) findViewById(R.id.card_search);
        mSearchCardIcon = findViewById(R.id.iv_search_icon);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        mSearchCardView.setOnClickListener(this);
        mFab.setOnClickListener(this);

        //setup toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        //setup drawer.
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);

        //setup navigation.
        mNavigationView.setNavigationItemSelectedListener(this);

        //setup navigation.
        mHotFragment = HotFragment.newInstance();
        mComingSoonFragment = ComingSoonFragment.newInstance();
        mTop250Fragment = Top250Fragment.newInstance();

        StatusBarUtil.setColorForDrawerLayout(MainActivity.this, mDrawerLayout,
                ContextCompat.getColor(this, R.color.colorPrimary), 60);

        selectNavigationItem(NAVIGATION_ITEM_HOT);
        showContentFragment(mHotFragment);

        getPresenter().subscribe(this);
    }

    @Override
    public void onClick(View view) {
        if (mFab == view) {
            launchFavoriteWithReveal(mFab);
        } else if (mSearchCardView == view) {
            launchSearch();
        }
    }

    @Subscribe
    public void onListDragging(ListDraggingEvent event) {
        hideFAB();
    }

    @Subscribe
    public void onListReleased(ListReleasedEvent event) {
        showFAB();
    }

    @Override
    protected boolean subscribeEvents() {
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (R.id.action_about == id) {

        } else if (R.id.action_hot == id) {
            selectNavigationItem(NAVIGATION_ITEM_HOT);
            showContentFragment(mHotFragment);

        } else if (R.id.action_coming_soon == id) {
            selectNavigationItem(NAVIGATION_ITEM_COMING_SOON);
            showContentFragment(mComingSoonFragment);

        } else if (R.id.action_top250 == id) {
            selectNavigationItem(NAVIGATION_ITEM_TOP250);
            showContentFragment(mTop250Fragment);

        } else if (R.id.action_favorite == id) {
            launchFavorite();
        }

        closeDrawer();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            closeDrawer();
            return;
        }

        Snackbar.make(getContentView(), R.string.exit_app_confirm, Snackbar.LENGTH_LONG)
                .setAction(R.string.confirm, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                })
                .show();
    }

    private void showContentFragment(Fragment content) {
        FragmentUtil.showAndHideFragment(MainActivity.this, ID_MAIN_CONTENT_CONTAINER, content, mCurrentFragment);
        mCurrentFragment = content;
    }

    private void showFAB() {
        mFab.animate()
                .translationY(0)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(600)
                .start();
    }

    private void hideFAB() {
        mFab.animate()
                .translationY(mFab.getBottom())
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(600)
                .start();
    }

    private void openDrawer() {
        mDrawerLayout.openDrawer(Gravity.START);
    }

    private void closeDrawer() {
        mDrawerLayout.closeDrawer(Gravity.START);
    }

    private void selectNavigationItem(@NavigationItem int item) {
        mNavigationView.setCheckedItem(NAVIGATION_ITEMS.get(item));
    }

    private void launchSearch() {
        ActivityLauncher.launchWithSharedElements(MainActivity.this,
                new Intent(MainActivity.this, SearchActivity.class),
                new View[]{mSearchCardView, mSearchCardIcon},
                new String[]{ViewCompat.getTransitionName(mSearchCardView), ViewCompat.getTransitionName(mSearchCardIcon)});
    }

    private void launchFavorite() {
        startActivity(new Intent(MainActivity.this, FavoritesActivity.class));
    }

    private void launchFavoriteWithReveal(@NonNull View starter) {
        Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);

        CircularRevealUtil.startActivity(MainActivity.this, intent, null, starter,
                ContextCompat.getColor(MainActivity.this, R.color.colorAccent)
                , true, 700, 800, null, null);
    }


}
