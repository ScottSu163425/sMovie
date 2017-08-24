package com.scottsu.smovie.data.source;

import java.util.List;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source
 * 描述:
 * 作者: Su
 * 日期: 2017/8/24 16:45
 **/
public class MovieDetailResponseEntity
{

    /**
     * rating : {"max":10,"average":9.4,"stars":"50","min":0}
     * reviews_count : 2734
     * wish_count : 52007
     * douban_site :
     * year : 1994
     * images : {"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p510876377.webp","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p510876377.webp","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p510876377.webp"}
     * alt : https://movie.douban.com/subject/1292720/
     * id : 1292720
     * mobile_url : https://movie.douban.com/subject/1292720/mobile
     * title : 阿甘正传
     * do_count : null
     * share_url : http://m.douban.com/movie/subject/1292720
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["美国"]
     * genres : ["剧情","爱情"]
     * collect_count : 947242
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054450/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/551.jpg","large":"http://img7.doubanio.com/img/celebrity/large/551.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/551.jpg"},"name":"汤姆·汉克斯","id":"1054450"},{"alt":"https://movie.douban.com/celebrity/1002676/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/51737.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51737.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51737.jpg"},"name":"罗宾·怀特","id":"1002676"},{"alt":"https://movie.douban.com/celebrity/1031848/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1345.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1345.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1345.jpg"},"name":"加里·西尼斯","id":"1031848"},{"alt":"https://movie.douban.com/celebrity/1031912/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/10896.jpg","large":"http://img3.doubanio.com/img/celebrity/large/10896.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/10896.jpg"},"name":"麦凯尔泰·威廉逊","id":"1031912"}]
     * current_season : null
     * original_title : Forrest Gump
     * summary : 阿甘（汤姆·汉克斯 饰）于二战结束后不久出生在美国南方阿拉巴马州一个闭塞的小镇，他先天弱智，智商只有75，然而他的妈妈是一个性格坚强的女性，她常常鼓励阿甘“傻人有傻福”，要他自强不息。
     阿甘像普通孩子一样上学，并且认识了一生的朋友和至爱珍妮（罗宾·莱特·潘 饰），在珍妮和妈妈的爱护下，阿甘凭着上帝赐予的“飞毛腿”开始了一生不停的奔跑。
     阿甘成为橄榄球巨星、越战英雄、乒乓球外交使者、亿万富翁，但是，他始终忘不了珍妮，几次匆匆的相聚和离别，更是加深了阿甘的思念。
     有一天，阿甘收到珍妮的信，他们终于又要见面……©豆瓣
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1053564/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/505.jpg","large":"http://img7.doubanio.com/img/celebrity/large/505.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/505.jpg"},"name":"罗伯特·泽米吉斯","id":"1053564"}]
     * comments_count : 142461
     * ratings_count : 706952
     * aka : ["福雷斯特·冈普"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating()
    {
        return rating;
    }

    public void setRating(RatingBean rating)
    {
        this.rating = rating;
    }

    public int getReviews_count()
    {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count)
    {
        this.reviews_count = reviews_count;
    }

    public int getWish_count()
    {
        return wish_count;
    }

    public void setWish_count(int wish_count)
    {
        this.wish_count = wish_count;
    }

    public String getDouban_site()
    {
        return douban_site;
    }

    public void setDouban_site(String douban_site)
    {
        this.douban_site = douban_site;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public ImagesBean getImages()
    {
        return images;
    }

    public void setImages(ImagesBean images)
    {
        this.images = images;
    }

    public String getAlt()
    {
        return alt;
    }

    public void setAlt(String alt)
    {
        this.alt = alt;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getMobile_url()
    {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url)
    {
        this.mobile_url = mobile_url;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Object getDo_count()
    {
        return do_count;
    }

    public void setDo_count(Object do_count)
    {
        this.do_count = do_count;
    }

    public String getShare_url()
    {
        return share_url;
    }

    public void setShare_url(String share_url)
    {
        this.share_url = share_url;
    }

    public Object getSeasons_count()
    {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count)
    {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url()
    {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url)
    {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count()
    {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count)
    {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count()
    {
        return collect_count;
    }

    public void setCollect_count(int collect_count)
    {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season()
    {
        return current_season;
    }

    public void setCurrent_season(Object current_season)
    {
        this.current_season = current_season;
    }

    public String getOriginal_title()
    {
        return original_title;
    }

    public void setOriginal_title(String original_title)
    {
        this.original_title = original_title;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSubtype()
    {
        return subtype;
    }

    public void setSubtype(String subtype)
    {
        this.subtype = subtype;
    }

    public int getComments_count()
    {
        return comments_count;
    }

    public void setComments_count(int comments_count)
    {
        this.comments_count = comments_count;
    }

    public int getRatings_count()
    {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count)
    {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries()
    {
        return countries;
    }

    public void setCountries(List<String> countries)
    {
        this.countries = countries;
    }

    public List<String> getGenres()
    {
        return genres;
    }

    public void setGenres(List<String> genres)
    {
        this.genres = genres;
    }

    public List<CastsBean> getCasts()
    {
        return casts;
    }

    public void setCasts(List<CastsBean> casts)
    {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors()
    {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors)
    {
        this.directors = directors;
    }

    public List<String> getAka()
    {
        return aka;
    }

    public void setAka(List<String> aka)
    {
        this.aka = aka;
    }

    public static class RatingBean
    {
        /**
         * max : 10
         * average : 9.4
         * stars : 50
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax()
        {
            return max;
        }

        public void setMax(int max)
        {
            this.max = max;
        }

        public double getAverage()
        {
            return average;
        }

        public void setAverage(double average)
        {
            this.average = average;
        }

        public String getStars()
        {
            return stars;
        }

        public void setStars(String stars)
        {
            this.stars = stars;
        }

        public int getMin()
        {
            return min;
        }

        public void setMin(int min)
        {
            this.min = min;
        }
    }

    public static class ImagesBean
    {
        /**
         * small : http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p510876377.webp
         * large : http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p510876377.webp
         * medium : http://img3.doubanio.com/view/movie_poster_cover/spst/public/p510876377.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall()
        {
            return small;
        }

        public void setSmall(String small)
        {
            this.small = small;
        }

        public String getLarge()
        {
            return large;
        }

        public void setLarge(String large)
        {
            this.large = large;
        }

        public String getMedium()
        {
            return medium;
        }

        public void setMedium(String medium)
        {
            this.medium = medium;
        }
    }

    public static class CastsBean
    {
        /**
         * alt : https://movie.douban.com/celebrity/1054450/
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/551.jpg","large":"http://img7.doubanio.com/img/celebrity/large/551.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/551.jpg"}
         * name : 汤姆·汉克斯
         * id : 1054450
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt()
        {
            return alt;
        }

        public void setAlt(String alt)
        {
            this.alt = alt;
        }

        public AvatarsBean getAvatars()
        {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars)
        {
            this.avatars = avatars;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public static class AvatarsBean
        {
            /**
             * small : http://img7.doubanio.com/img/celebrity/small/551.jpg
             * large : http://img7.doubanio.com/img/celebrity/large/551.jpg
             * medium : http://img7.doubanio.com/img/celebrity/medium/551.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall()
            {
                return small;
            }

            public void setSmall(String small)
            {
                this.small = small;
            }

            public String getLarge()
            {
                return large;
            }

            public void setLarge(String large)
            {
                this.large = large;
            }

            public String getMedium()
            {
                return medium;
            }

            public void setMedium(String medium)
            {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean
    {
        /**
         * alt : https://movie.douban.com/celebrity/1053564/
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/505.jpg","large":"http://img7.doubanio.com/img/celebrity/large/505.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/505.jpg"}
         * name : 罗伯特·泽米吉斯
         * id : 1053564
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt()
        {
            return alt;
        }

        public void setAlt(String alt)
        {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars()
        {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars)
        {
            this.avatars = avatars;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public static class AvatarsBeanX
        {
            /**
             * small : http://img7.doubanio.com/img/celebrity/small/505.jpg
             * large : http://img7.doubanio.com/img/celebrity/large/505.jpg
             * medium : http://img7.doubanio.com/img/celebrity/medium/505.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall()
            {
                return small;
            }

            public void setSmall(String small)
            {
                this.small = small;
            }

            public String getLarge()
            {
                return large;
            }

            public void setLarge(String large)
            {
                this.large = large;
            }

            public String getMedium()
            {
                return medium;
            }

            public void setMedium(String medium)
            {
                this.medium = medium;
            }
        }
    }

    @Override
    public String toString()
    {
        return "MovieDetailResponseEntity{" +
                "rating=" + rating +
                ", reviews_count=" + reviews_count +
                ", wish_count=" + wish_count +
                ", douban_site='" + douban_site + '\'' +
                ", year='" + year + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", mobile_url='" + mobile_url + '\'' +
                ", title='" + title + '\'' +
                ", do_count=" + do_count +
                ", share_url='" + share_url + '\'' +
                ", seasons_count=" + seasons_count +
                ", schedule_url='" + schedule_url + '\'' +
                ", episodes_count=" + episodes_count +
                ", collect_count=" + collect_count +
                ", current_season=" + current_season +
                ", original_title='" + original_title + '\'' +
                ", summary='" + summary + '\'' +
                ", subtype='" + subtype + '\'' +
                ", comments_count=" + comments_count +
                ", ratings_count=" + ratings_count +
                ", countries=" + countries +
                ", genres=" + genres +
                ", casts=" + casts +
                ", directors=" + directors +
                ", aka=" + aka +
                '}';
    }
}
