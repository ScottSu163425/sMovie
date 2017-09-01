package com.scottsu.smovie.data.enity;

import java.util.List;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source
 * 描述:
 * 作者: Su
 * 日期: 2017/8/23 16:58
 **/
public class HotResponseEntity extends CommonListResponseEntity
{

    /**
     * count : 2
     * start : 0
     * total : 46
     * subjects : [{"rating":{"max":10,"average":7.4,"stars":"40","min":0},"genres":["动作"],"title":"战狼2","casts":[{"alt":"https://movie.douban.com/celebrity/1000525/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/39105.jpg","large":"http://img7.doubanio.com/img/celebrity/large/39105.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/39105.jpg"},"name":"吴京","id":"1000525"},{"alt":"https://movie.douban.com/celebrity/1100321/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1415801312.29.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1415801312.29.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1415801312.29.jpg"},"name":"弗兰克·格里罗","id":"1100321"},{"alt":"https://movie.douban.com/celebrity/1274840/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1401440361.14.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1401440361.14.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1401440361.14.jpg"},"name":"吴刚","id":"1274840"}],"collect_count":357038,"original_title":"战狼2","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1000525/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/39105.jpg","large":"http://img7.doubanio.com/img/celebrity/large/39105.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/39105.jpg"},"name":"吴京","id":"1000525"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2485983612.webp","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2485983612.webp","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2485983612.webp"},"alt":"https://movie.douban.com/subject/26363254/","id":"26363254"},{"rating":{"max":10,"average":7.5,"stars":"40","min":0},"genres":["剧情","动作"],"title":"杀破狼·贪狼","casts":[{"alt":"https://movie.douban.com/celebrity/1027577/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1419164187.6.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1419164187.6.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1419164187.6.jpg"},"name":"古天乐","id":"1027577"},{"alt":"https://movie.douban.com/celebrity/1314321/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/45924.jpg","large":"http://img7.doubanio.com/img/celebrity/large/45924.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/45924.jpg"},"name":"吴樾","id":"1314321"},{"alt":"https://movie.douban.com/celebrity/1004643/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/4862.jpg","large":"http://img7.doubanio.com/img/celebrity/large/4862.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/4862.jpg"},"name":"托尼·贾","id":"1004643"}],"collect_count":33814,"original_title":"殺破狼\u2027貪狼","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274472/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1379340288.41.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1379340288.41.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1379340288.41.jpg"},"name":"叶伟信","id":"1274472"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2494948513.webp","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2494948513.webp","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2494948513.webp"},"alt":"https://movie.douban.com/subject/26826398/","id":"26826398"}]
     * title : 正在上映的电影-北京
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
