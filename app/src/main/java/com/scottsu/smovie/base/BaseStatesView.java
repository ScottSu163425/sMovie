package com.scottsu.smovie.base;

/**
 * package: com.scottsu.smovie.base
 * description:
 * author: Su
 * date: 2017/8/27 17:33
 */

public interface BaseStatesView {
    void showLoading();

    void showEmpty();

    void showError();

    void showContent();
}
