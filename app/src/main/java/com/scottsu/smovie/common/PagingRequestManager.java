package com.scottsu.smovie.common;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.common
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 9:08
 **/
public class PagingRequestManager {
    private final int mFirstPage;
    private final int mFirstIndex;
    private final int mPageSize;
    private int mCurrentPage;
    private int mCurrentIndex;
    private boolean mHasNextPage;


    public PagingRequestManager(int firstPage, int firstIndex, int pageSize) {
        mFirstPage = firstPage;
        mFirstIndex = firstIndex;
        mPageSize = pageSize;
        mCurrentPage = mFirstPage;
        mCurrentIndex = mCurrentPage;
    }

    public int turnToFirstPage() {
        mCurrentPage = mFirstPage;
        mCurrentIndex = mFirstIndex;
        return mCurrentPage;
    }

    public int turnToNextPage() {
        mCurrentPage++;
        mCurrentIndex += mPageSize;
        mHasNextPage = true;
        return mCurrentPage;
    }

    public int setLastPage() {
        mHasNextPage = false;
        return mCurrentPage;
    }

    public int getFirstPage() {
        return mFirstPage;
    }

    public int getFirstIndex() {
        return mFirstIndex;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public int getCurrentPage() {
        return mCurrentPage;
    }

    public int getCurrentIndex() {
        return mCurrentIndex;
    }

    public boolean hasNextPage() {
        return mHasNextPage;
    }

}
