package com.scottsu.smovie.common.events;

/**
 * project: sMovie
 * package: com.scottsu.smovie.common.events
 * description:
 * author: Su
 * date: 2017/9/1 10:05
 */

public class SearchEvent {
    private String keyword;

    public SearchEvent(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

}
