package com.scottsu.smovie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;
import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.module.main.MainActivity;
import com.scottsu.utils.ActivityLauncher;
import com.scottsu.utils.CircularRevealUtil;
import com.scottsu.utils.interfaces.SimpleAnimListener;

public class SplashActivity extends BaseActivity {
    private View mRevealView;
    private ProgressWheel mProgressWheel;
    private TextView mAppNameTextView;
    private boolean mFinishSplash;


    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected IMvpPresenter providePresenter() {
        return null;
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRevealView = findViewById(R.id.view_reveal);
        mProgressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
        mAppNameTextView = (TextView) findViewById(R.id.tv_app_name);

        startSplashAnimation(new Runnable() {

            @Override
            public void run() {
                ActivityLauncher.launch(SplashActivity.this, MainActivity.class);
                overridePendingTransition(R.anim.slide_in_right, android.R.anim.fade_out);

                mFinishSplash = true;
                onBackPressed();
            }
        });
    }

    private void startSplashAnimation(final Runnable endAction) {
        Animator scaleX = ObjectAnimator.ofFloat(mAppNameTextView, "scaleX", 1.0f, 1.5f, 1.6f, 1.5f, 1.2f, 1.1f, 1.0f);
        Animator scaleY = ObjectAnimator.ofFloat(mAppNameTextView, "scaleY", 1.0f, 1.5f, 1.6f, 1.5f, 1.2f, 1.1f, 1.0f);
        final AnimatorSet pop = new AnimatorSet();
        pop.playTogether(scaleX, scaleY);
        pop.setDuration(600);
        pop.setInterpolator(new FastOutSlowInInterpolator());
        pop.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);

                mRevealView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRevealView.setBackgroundColor(ContextCompat.getColor(SplashActivity.this, R.color.colorPrimary));
                        CircularRevealUtil.revealIn(mRevealView, CircularRevealUtil.CENTER, 900, null,
                                new SimpleAnimListener() {
                                    @Override
                                    public void onAnimStart() {
                                        mAppNameTextView.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                mAppNameTextView.setTextColor(Color.WHITE);
                                            }
                                        }, 100);
                                    }

                                    @Override
                                    public void onAnimEnd() {
                                        mAppNameTextView.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                mProgressWheel.setVisibility(View.VISIBLE);
                                            }
                                        }, 300);

                                        mAppNameTextView.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                endAction.run();
                                            }
                                        }, 2300);
                                    }
                                });
                    }
                }, 400);

            }
        });

        Animation slideInLeft = AnimationUtils.makeInChildBottomAnimation(this);
        slideInLeft.setDuration(800);
        slideInLeft.setInterpolator(new FastOutSlowInInterpolator());
        slideInLeft.setStartOffset(1200);

        slideInLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                pop.setStartDelay(300);
                pop.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mAppNameTextView.startAnimation(slideInLeft);
    }

    @Override
    public void onBackPressed() {
        if (mFinishSplash) {
            super.onBackPressed();
        }
    }


}
