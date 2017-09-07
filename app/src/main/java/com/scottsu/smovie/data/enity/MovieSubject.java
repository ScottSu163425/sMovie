package com.scottsu.smovie.data.enity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source
 * 描述:
 * 作者: Su
 * 日期: 2017/8/23 16:50
 **/

public class MovieSubject implements Serializable {


    /**
     * rating : {"max":10,"average":9.6,"details":{"1":526,"2":648,"3":11662,"4":92032,"5":479915},"stars":"50","min":0}
     * genres : ["犯罪","剧情"]
     * title : 肖申克的救赎
     * casts : [{"avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/17525.jpg","large":"http://img7.doubanio.com/img/celebrity/large/17525.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/17525.jpg"},"name_en":"Tim Robbins","name":"蒂姆·罗宾斯","alt":"https://movie.douban.com/celebrity/1054521/","id":"1054521"},{"avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/34642.jpg","large":"http://img7.doubanio.com/img/celebrity/large/34642.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/34642.jpg"},"name_en":"Morgan Freeman","name":"摩根·弗里曼","alt":"https://movie.douban.com/celebrity/1054534/","id":"1054534"},{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/5837.jpg","large":"http://img3.doubanio.com/img/celebrity/large/5837.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/5837.jpg"},"name_en":"Bob Gunton","name":"鲍勃·冈顿","alt":"https://movie.douban.com/celebrity/1041179/","id":"1041179"}]
     * durations : ["142 分钟"]
     * collect_count : 1116710
     * mainland_pubdate :
     * has_video : true
     * original_title : The Shawshank Redemption
     * subtype : movie
     * directors : [{"avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/230.jpg","large":"http://img7.doubanio.com/img/celebrity/large/230.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/230.jpg"},"name_en":"Frank Darabont","name":"弗兰克·德拉邦特","alt":"https://movie.douban.com/celebrity/1047973/","id":"1047973"}]
     * pubdates : ["1994-09-10(多伦多电影节)","1994-10-14(美国)"]
     * year : 1994
     * images : {"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.webp","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.webp","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p480747492.webp"}
     * alt : https://movie.douban.com/subject/1292052/
     * id : 1292052
     */

    private RatingBean rating;
    private String title;
    private int collect_count;
    private String mainland_pubdate;
    private boolean has_video;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<String> durations;
    private List<DirectorsBean> directors;
    private List<String> pubdates;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public static class RatingBean implements Serializable {
        /**
         * max : 10
         * average : 9.6
         * details : {"1":526,"2":648,"3":11662,"4":92032,"5":479915}
         * stars : 50
         * min : 0
         */

        private int max;
        private double average;
        private DetailsBean details;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public static class DetailsBean implements Serializable{
            /**
             * 1 : 526
             * 2 : 648
             * 3 : 11662
             * 4 : 92032
             * 5 : 479915
             */

            @SerializedName("1")
            private int _$1;
            @SerializedName("2")
            private int _$2;
            @SerializedName("3")
            private int _$3;
            @SerializedName("4")
            private int _$4;
            @SerializedName("5")
            private int _$5;

            public int get_$1() {
                return _$1;
            }

            public void set_$1(int _$1) {
                this._$1 = _$1;
            }

            public int get_$2() {
                return _$2;
            }

            public void set_$2(int _$2) {
                this._$2 = _$2;
            }

            public int get_$3() {
                return _$3;
            }

            public void set_$3(int _$3) {
                this._$3 = _$3;
            }

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }

            public int get_$5() {
                return _$5;
            }

            public void set_$5(int _$5) {
                this._$5 = _$5;
            }
        }
    }

    public static class ImagesBean implements Serializable {
        /**
         * small : http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.webp
         * large : http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.webp
         * medium : http://img7.doubanio.com/view/movie_poster_cover/spst/public/p480747492.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean implements Serializable {
        /**
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/17525.jpg","large":"http://img7.doubanio.com/img/celebrity/large/17525.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/17525.jpg"}
         * name_en : Tim Robbins
         * name : 蒂姆·罗宾斯
         * alt : https://movie.douban.com/celebrity/1054521/
         * id : 1054521
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean implements Serializable {
            /**
             * small : http://img7.doubanio.com/img/celebrity/small/17525.jpg
             * large : http://img7.doubanio.com/img/celebrity/large/17525.jpg
             * medium : http://img7.doubanio.com/img/celebrity/medium/17525.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean implements Serializable {
        /**
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/230.jpg","large":"http://img7.doubanio.com/img/celebrity/large/230.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/230.jpg"}
         * name_en : Frank Darabont
         * name : 弗兰克·德拉邦特
         * alt : https://movie.douban.com/celebrity/1047973/
         * id : 1047973
         */

        private AvatarsBeanX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX implements Serializable{
            /**
             * small : http://img7.doubanio.com/img/celebrity/small/230.jpg
             * large : http://img7.doubanio.com/img/celebrity/large/230.jpg
             * medium : http://img7.doubanio.com/img/celebrity/medium/230.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
