package com.scottsu.smovie.data.enity;

import java.util.List;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source
 * 描述:
 * 作者: Su
 * 日期: 2017/8/24 16:41
 **/
public class SearchResponseEntity extends CommonListResponseEntity
{

    /**
     * subjects : [{"rating":{"max":10,"average":9.2,"stars":"50","min":0},"genres":["剧情","爱情","灾难"],"title":"泰坦尼克号","casts":[{"alt":"https://movie.douban.com/celebrity/1041029/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/470.jpg","large":"http://img7.doubanio.com/img/celebrity/large/470.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/470.jpg"},"name":"莱昂纳多·迪卡普里奥","id":"1041029"},{"alt":"https://movie.douban.com/celebrity/1054446/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/53358.jpg","large":"http://img3.doubanio.com/img/celebrity/large/53358.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/53358.jpg"},"name":"凯特·温丝莱特","id":"1054446"},{"alt":"https://movie.douban.com/celebrity/1031864/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/45186.jpg","large":"http://img3.doubanio.com/img/celebrity/large/45186.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/45186.jpg"},"name":"比利·赞恩","id":"1031864"}],"collect_count":871052,"original_title":"Titanic","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1022571/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/33715.jpg","large":"http://img7.doubanio.com/img/celebrity/large/33715.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/33715.jpg"},"name":"詹姆斯·卡梅隆","id":"1022571"}],"year":"1997","images":{"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p457760035.webp","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p457760035.webp","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p457760035.webp"},"alt":"https://movie.douban.com/subject/1292722/","id":"1292722"},{"rating":{"max":10,"average":8.2,"stars":"40","min":0},"genres":["剧情","灾难"],"title":"泰坦尼克号","casts":[{"alt":"https://movie.douban.com/celebrity/1025422/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/15418.jpg","large":"http://img3.doubanio.com/img/celebrity/large/15418.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/15418.jpg"},"name":"大卫·卡尔德","id":"1025422"},{"alt":null,"avatars":null,"name":"Steven Waddington","id":null},{"alt":"https://movie.douban.com/celebrity/1319224/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/46269.jpg","large":"http://img3.doubanio.com/img/celebrity/large/46269.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/46269.jpg"},"name":"李·罗斯","id":"1319224"}],"collect_count":7773,"original_title":"Titanic","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1287875/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"Jon Jones","id":"1287875"}],"year":"2012","images":{"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p1496529651.webp","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p1496529651.webp","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p1496529651.webp"},"alt":"https://movie.douban.com/subject/6087553/","id":"6087553"}]
     * title : 搜索 "titanic" 的结果
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
