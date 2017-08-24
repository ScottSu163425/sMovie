package com.scottsu.smovie.data.source;

import java.util.List;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source
 * 描述:
 * 作者: Su
 * 日期: 2017/8/24 16:23
 **/
public class ComingSoonResponseEntity extends CommonListResponseEntity
{

    /**
     * count : 2
     * start : 0
     * total : 140
     * subjects : [{"rating":{"max":10,"average":8.6,"stars":"45","min":0},"genres":["剧情","家庭"],"title":"海边的曼彻斯特","casts":[{"alt":"https://movie.douban.com/celebrity/1022593/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/2199.jpg","large":"http://img3.doubanio.com/img/celebrity/large/2199.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/2199.jpg"},"name":"卡西·阿弗莱克","id":"1022593"},{"alt":"https://movie.douban.com/celebrity/1340596/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1487925258.18.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1487925258.18.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1487925258.18.jpg"},"name":"卢卡斯·赫奇斯","id":"1340596"},{"alt":"https://movie.douban.com/celebrity/1049491/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/19972.jpg","large":"http://img7.doubanio.com/img/celebrity/large/19972.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/19972.jpg"},"name":"米歇尔·威廉姆斯","id":"1049491"}],"collect_count":136424,"original_title":"Manchester by the Sea","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1027514/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/20335.jpg","large":"http://img7.doubanio.com/img/celebrity/large/20335.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/20335.jpg"},"name":"肯尼思·洛纳根","id":"1027514"}],"year":"2016","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2496940327.webp","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2496940327.webp","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2496940327.webp"},"alt":"https://movie.douban.com/subject/25980443/","id":"25980443"},{"rating":{"max":10,"average":7.7,"stars":"40","min":0},"genres":["动作","犯罪","音乐"],"title":"极盗车神","casts":[{"alt":"https://movie.douban.com/celebrity/1335176/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1410576603.62.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1410576603.62.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1410576603.62.jpg"},"name":"安塞尔·艾尔高特","id":"1335176"},{"alt":"https://movie.douban.com/celebrity/1054432/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/5491.jpg","large":"http://img7.doubanio.com/img/celebrity/large/5491.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/5491.jpg"},"name":"凯文·史派西","id":"1054432"},{"alt":"https://movie.douban.com/celebrity/1036329/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1374587274.39.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1374587274.39.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1374587274.39.jpg"},"name":"杰米·福克斯","id":"1036329"}],"collect_count":3766,"original_title":"Baby Driver","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1002716/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/40583.jpg","large":"http://img7.doubanio.com/img/celebrity/large/40583.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/40583.jpg"},"name":"埃德加·赖特","id":"1002716"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2496901482.webp","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2496901482.webp","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2496901482.webp"},"alt":"https://movie.douban.com/subject/25933890/","id":"25933890"}]
     * title : 即将上映的电影
     */

    private String title;
    private List<MovieSubject> subjects;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<MovieSubject> getSubjects()
    {
        return subjects;
    }

    public void setSubjects(List<MovieSubject> subjects)
    {
        this.subjects = subjects;
    }

}
