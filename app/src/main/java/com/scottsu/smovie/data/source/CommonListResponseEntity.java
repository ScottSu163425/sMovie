package com.scottsu.smovie.data.source;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source
 * 描述:
 * 作者: Su
 * 日期: 2017/8/24 16:26
 **/
public class CommonListResponseEntity
{
    private int count;
    private int start;
    private int total;

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public boolean hasNextPage(){
       return  ((start + 1) * count) < total;
    }

}
