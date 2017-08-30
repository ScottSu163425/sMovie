package com.scottsu.smovie.common;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.common
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 9:08
 **/
public class PagingRequestManager
{
    private final int mFirstPage;
    private final int mPageSize;
    private int mCurrentPage;
    private boolean mHasNextPage;


    public PagingRequestManager(int firstPage, int pageSize)
    {
        mFirstPage = firstPage;
        mPageSize = pageSize;
        mCurrentPage=mFirstPage;
    }

    public int turnToFirstPage()
    {
        mCurrentPage = mFirstPage;
        return mCurrentPage;
    }

    public int turnToNextPage()
    {
        mCurrentPage++;
        mHasNextPage = true;
        return mCurrentPage;
    }

    public int setLastPage()
    {
        mHasNextPage = false;
        return mCurrentPage;
    }

    public int getFirstPage()
    {
        return mFirstPage;
    }

    public int getPageSize()
    {
        return mPageSize;
    }

    public int getCurrentPage()
    {
        return mCurrentPage;
    }

    public boolean hasNextPage()
    {
        return mHasNextPage;
    }

}
