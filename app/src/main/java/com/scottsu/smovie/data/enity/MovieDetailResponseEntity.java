package com.scottsu.smovie.data.enity;

import com.google.gson.annotations.SerializedName;

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
     * rating : {"max":10,"average":9.6,"details":{"1":526,"2":648,"3":11662,"4":92032,"5":479921},"stars":"50","min":0}
     * reviews_count : 5275
     * videos : [{"source":{"literal":"youku","pic":"http://img3.doubanio.com/f/movie/3bb15010bb66a89962a5faf0f7f071fec8aaa763/pics/movie/logo_youku_small.png","name":"优酷视频"},"sample_link":"http://cps.youku.com/redirect.html?id=0000a213&url=http://v.youku.com/v_show/id_XMjgwNDkwNzE2.html","video_id":"XMjgwNDkwNzE2","need_pay":true},{"source":{"literal":"iqiyi","pic":"http://img3.doubanio.com/f/movie/e59bf8556426206eab3591f88a6c8ef8bf371a56/pics/movie/video_icon_new.png","name":"爱奇艺视频"},"sample_link":"http://www.iqiyi.com/v_19rra0h3wg.html?vfm=m_331_dbdy&fv=4904d94982104144a1548dd9040df241","video_id":"19rra0h3wg","need_pay":true},{"source":{"literal":"qq","pic":"http://img7.doubanio.com/f/movie/38764466321ab88dfa19a1f826570367a19ce116/pics/movie/video-qq.png","name":"腾讯视频"},"sample_link":"http://v.qq.com/x/cover/1o29ui77e85grdr.html?ptag=douban.movie","video_id":"1o29ui77e85grdr","need_pay":true},{"source":{"literal":"sohu","pic":"http://img3.doubanio.com/f/movie/4d9f2399617a3b962e523b7019daedc65e0bdf2a/pics/movie/video-sohu.gif","name":"搜狐视频"},"sample_link":"http://film.sohu.com/album/1008593.html","video_id":"579957","need_pay":true}]
     * wish_count : 84001
     * original_title : The Shawshank Redemption
     * blooper_urls : []
     * collect_count : 1116718
     * images : {"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.webp","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.webp","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p480747492.webp"}
     * douban_site :
     * year : 1994
     * popular_comments : [{"rating":{"max":5,"value":5,"min":0},"useful_count":618,"author":{"uid":"jennyqueen","avatar":"http://img7.doubanio.com/icon/u1311269-2420.jpg","signature":"","alt":"http://www.douban.com/people/jennyqueen/","id":"1311269","name":"珍妮的肖像"},"subject_id":"1292052","content":"没有人会不喜欢吧！书和电影都好。","created_at":"2006-11-13 08:41:13","id":"7096858"},{"rating":{"max":5,"value":5,"min":0},"useful_count":534,"author":{"uid":"onshuway","avatar":"http://img3.doubanio.com/icon/u1215272-56.jpg","signature":"","alt":"http://www.douban.com/people/onshuway/","id":"1215272","name":"小耳朵图吗"},"subject_id":"1292052","content":"越狱我感觉就是改编自这个","created_at":"2007-08-21 06:50:24","id":"4982519"},{"rating":{"max":5,"value":4,"min":0},"useful_count":795,"author":{"uid":"wenzel","avatar":"http://img3.doubanio.com/icon/u1781395-107.jpg","signature":"谁能千里外 独寄八行书","alt":"http://www.douban.com/people/wenzel/","id":"1781395","name":"文泽尔"},"subject_id":"1292052","content":"人的生命不过是从一个洞穴通往另一个世界..然后在那个世界的雨中继续颤抖.i hope","created_at":"2008-01-14 01:53:08","id":"28737569"},{"rating":{"max":5,"value":5,"min":0},"useful_count":3429,"author":{"uid":"aixiaoke","avatar":"http://img3.doubanio.com/icon/u1182135-29.jpg","signature":"脚踏实地，朴素为人。","alt":"http://www.douban.com/people/aixiaoke/","id":"1182135","name":"艾小柯"},"subject_id":"1292052","content":"关于希望最强有力的注释。","created_at":"2006-06-20 03:18:55","id":"3728484"}]
     * alt : https://movie.douban.com/subject/1292052/
     * id : 1292052
     * mobile_url : https://movie.douban.com/subject/1292052/mobile
     * photos_count : 635
     * pubdate :
     * title : 肖申克的救赎
     * do_count : null
     * has_video : true
     * share_url : http://m.douban.com/movie/subject/1292052
     * seasons_count : null
     * languages : ["英语"]
     * schedule_url :
     * writers : [{"avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/230.jpg","large":"http://img7.doubanio.com/img/celebrity/large/230.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/230.jpg"},"name_en":"Frank Darabont","name":"弗兰克·德拉邦特","alt":"https://movie.douban.com/celebrity/1047973/","id":"1047973"},{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/439.jpg","large":"http://img3.doubanio.com/img/celebrity/large/439.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/439.jpg"},"name_en":"Stephen King","name":"斯蒂芬·金","alt":"https://movie.douban.com/celebrity/1049547/","id":"1049547"}]
     * pubdates : ["1994-09-10(多伦多电影节)","1994-10-14(美国)"]
     * website :
     * tags : ["经典","励志","信念","自由","美国","人性","人生","剧情","1994","希望"]
     * has_schedule : false
     * durations : ["142 分钟"]
     * genres : ["犯罪","剧情"]
     * collection : null
     * trailers : [{"medium":"http://img7.doubanio.com/img/trailer/medium/1433841022.jpg?","title":"预告片","subject_id":"1292052","alt":"https://movie.douban.com/trailer/108756/","small":"http://img7.doubanio.com/img/trailer/small/1433841022.jpg?","resource_url":"http://vt3.doubanio.com/201709072118/4b39a629114164486eba6c31734b6552/view/movie/M/301080756.mp4","id":"108756"}]
     * episodes_count : null
     * trailer_urls : ["http://vt3.doubanio.com/201709072118/4b39a629114164486eba6c31734b6552/view/movie/M/301080756.mp4"]
     * has_ticket : false
     * bloopers : []
     * clip_urls : []
     * current_season : null
     * casts : [{"avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/17525.jpg","large":"http://img7.doubanio.com/img/celebrity/large/17525.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/17525.jpg"},"name_en":"Tim Robbins","name":"蒂姆·罗宾斯","alt":"https://movie.douban.com/celebrity/1054521/","id":"1054521"},{"avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/34642.jpg","large":"http://img7.doubanio.com/img/celebrity/large/34642.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/34642.jpg"},"name_en":"Morgan Freeman","name":"摩根·弗里曼","alt":"https://movie.douban.com/celebrity/1054534/","id":"1054534"},{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/5837.jpg","large":"http://img3.doubanio.com/img/celebrity/large/5837.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/5837.jpg"},"name_en":"Bob Gunton","name":"鲍勃·冈顿","alt":"https://movie.douban.com/celebrity/1041179/","id":"1041179"},{"avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/7827.jpg","large":"http://img3.doubanio.com/img/celebrity/large/7827.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/7827.jpg"},"name_en":"William Sadler","name":"威廉姆·赛德勒","alt":"https://movie.douban.com/celebrity/1000095/","id":"1000095"}]
     * countries : ["美国"]
     * mainland_pubdate :
     * photos : [{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p712907932.webp","image":"http://img7.doubanio.com/view/photo/photo/public/p712907932.webp","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p712907932.webp","alt":"https://movie.douban.com/photos/photo/712907932/","id":"712907932","icon":"http://img7.doubanio.com/view/photo/icon/public/p712907932.webp"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p490571815.webp","image":"http://img7.doubanio.com/view/photo/photo/public/p490571815.webp","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p490571815.webp","alt":"https://movie.douban.com/photos/photo/490571815/","id":"490571815","icon":"http://img7.doubanio.com/view/photo/icon/public/p490571815.webp"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p450994579.webp","image":"http://img3.doubanio.com/view/photo/photo/public/p450994579.webp","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p450994579.webp","alt":"https://movie.douban.com/photos/photo/450994579/","id":"450994579","icon":"http://img3.doubanio.com/view/photo/icon/public/p450994579.webp"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p617951690.webp","image":"http://img7.doubanio.com/view/photo/photo/public/p617951690.webp","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p617951690.webp","alt":"https://movie.douban.com/photos/photo/617951690/","id":"617951690","icon":"http://img7.doubanio.com/view/photo/icon/public/p617951690.webp"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p617951743.webp","image":"http://img7.doubanio.com/view/photo/photo/public/p617951743.webp","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p617951743.webp","alt":"https://movie.douban.com/photos/photo/617951743/","id":"617951743","icon":"http://img7.doubanio.com/view/photo/icon/public/p617951743.webp"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p1004031025.webp","image":"http://img7.doubanio.com/view/photo/photo/public/p1004031025.webp","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p1004031025.webp","alt":"https://movie.douban.com/photos/photo/1004031025/","id":"1004031025","icon":"http://img7.doubanio.com/view/photo/icon/public/p1004031025.webp"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p490576110.webp","image":"http://img7.doubanio.com/view/photo/photo/public/p490576110.webp","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p490576110.webp","alt":"https://movie.douban.com/photos/photo/490576110/","id":"490576110","icon":"http://img7.doubanio.com/view/photo/icon/public/p490576110.webp"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p1225215490.webp","image":"http://img7.doubanio.com/view/photo/photo/public/p1225215490.webp","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p1225215490.webp","alt":"https://movie.douban.com/photos/photo/1225215490/","id":"1225215490","icon":"http://img7.doubanio.com/view/photo/icon/public/p1225215490.webp"},{"thumb":"http://img3.doubanio.com/view/photo/thumb/public/p825402537.webp","image":"http://img3.doubanio.com/view/photo/photo/public/p825402537.webp","cover":"http://img3.doubanio.com/view/photo/albumcover/public/p825402537.webp","alt":"https://movie.douban.com/photos/photo/825402537/","id":"825402537","icon":"http://img3.doubanio.com/view/photo/icon/public/p825402537.webp"},{"thumb":"http://img7.doubanio.com/view/photo/thumb/public/p456482220.webp","image":"http://img7.doubanio.com/view/photo/photo/public/p456482220.webp","cover":"http://img7.doubanio.com/view/photo/albumcover/public/p456482220.webp","alt":"https://movie.douban.com/photos/photo/456482220/","id":"456482220","icon":"http://img7.doubanio.com/view/photo/icon/public/p456482220.webp"}]
     * summary : 20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。未过多久，安迪尝试接近囚犯中颇有声望的瑞德（摩根·弗里曼 Morgan Freeman 饰），请求对方帮自己搞来小锤子。以此为契机，二人逐渐熟稔，安迪也仿佛在鱼龙混杂、罪恶横生、黑白混淆的牢狱中找到属于自己的求生之道。他利用自身的专业知识，帮助监狱管理层逃税、洗黑钱，同时凭借与瑞德的交往在犯人中间也渐渐受到礼遇。表面看来，他已如瑞德那样对那堵高墙从憎恨转变为处之泰然，但是对自由的渴望仍促使他朝着心中的希望和目标前进。而关于其罪行的真相，似乎更使这一切朝前推进了一步……
     本片根据著名作家斯蒂芬·金（Stephen Edwin King）的原著改编。©豆瓣
     * clips : []
     * subtype : movie
     * directors : [{"avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/230.jpg","large":"http://img7.doubanio.com/img/celebrity/large/230.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/230.jpg"},"name_en":"Frank Darabont","name":"弗兰克·德拉邦特","alt":"https://movie.douban.com/celebrity/1047973/","id":"1047973"}]
     * comments_count : 205326
     * popular_reviews : [{"rating":{"max":5,"value":5,"min":0},"title":"十年·肖申克的救赎","subject_id":"1292052","author":{"uid":"bighead","avatar":"http://img7.doubanio.com/icon/u1000152-22.jpg","signature":"微信公号：夜读症","alt":"http://www.douban.com/people/bighead/","id":"1000152","name":"大头绿豆"},"summary":"距离斯蒂芬·金（Stephen King）和德拉邦特（Frank Darabont）们缔造这部伟大的作品已经有十年了。我知道美好的东西想必大家都能感受，但是很抱歉，我的聒噪仍将一如既往。 在我眼里，肖申克的救赎与信念、自由和...","alt":"https://movie.douban.com/review/1000369/","id":"1000369"},{"rating":{"max":5,"value":5,"min":0},"title":"《肖申克的救赎》与斯德哥尔摩综合症－－你我都是患者！","subject_id":"1292052","author":{"uid":"1817888","avatar":"http://img7.doubanio.com/icon/u1817888-4.jpg","signature":"","alt":"http://www.douban.com/people/1817888/","id":"1817888","name":"中原狮子王"},"summary":"   斯德哥尔摩综合症（Stockholm syndrome），斯德哥尔摩效应，又称斯德哥尔摩症候群或者称为人质情结或人质综合症，是指犯罪的被害者对于犯罪者产生情感，甚至反过来帮助犯罪者的一种情结。这个情感造成被害人对...","alt":"https://movie.douban.com/review/1208594/","id":"1208594"},{"rating":{"max":5,"value":5,"min":0},"title":"终于找到了郁闷人生的原因\u2015\u2015观《肖申克的救赎》有感","subject_id":"1292052","author":{"uid":"lazywormzhao","avatar":"http://img7.doubanio.com/icon/u1000564-1.jpg","signature":"隐居云上","alt":"http://www.douban.com/people/lazywormzhao/","id":"1000564","name":"隱居雲上"},"summary":" 周末看了一部美国影片《肖申克的救赎》（《The Shawshank Redemption》） 讲的是一位因冤案入狱的年轻银行家在牢中如何追寻自由的故事。 不同的人看同样的影片可能都有不同的感受。对于目前无力改变现状的我，看...","alt":"https://movie.douban.com/review/1001258/","id":"1001258"},{"rating":{"max":5,"value":5,"min":0},"title":"Andy Dufresne","subject_id":"1292052","author":{"uid":"nakedfake","avatar":"http://img3.doubanio.com/icon/user_normal.jpg","signature":"","alt":"http://www.douban.com/people/nakedfake/","id":"1017620","name":"[已注销]"},"summary":"Andy Dufresne，一个永垂电影史册的名字。  1  关于《The Shawshank Redemption》的评论，太多，该说的差不多都已说了千万遍。对于这样一个热门的话题，再想要抒发一些个人的喜爱之情，不免有拾人牙慧之嫌。为了...","alt":"https://movie.douban.com/review/1019121/","id":"1019121"},{"rating":{"max":5,"value":5,"min":0},"title":"《肖申克的救赎》：1994\u20142007，希望就是现实","subject_id":"1292052","author":{"uid":"1317870","avatar":"http://img7.doubanio.com/icon/u1317870-33.jpg","signature":"","alt":"http://www.douban.com/people/1317870/","id":"1317870","name":"aratana"},"summary":"一、缘起  从来没想过给《肖申克的救赎》写一篇影评，也许是生怕暴露自己只是个不谙世事的初级影迷，也许是对这样一部无法复制的影片真的不愿去过多地提起。然而一场出其不意的重感冒让我只能卧床裹被，已没有了...","alt":"https://movie.douban.com/review/1127585/","id":"1127585"},{"rating":{"max":5,"value":5,"min":0},"title":"人生的过程就是一个摆脱institutionalization(体制化)的过程","subject_id":"1292052","author":{"uid":"suoliweng","avatar":"http://img7.doubanio.com/icon/u1026935-2.jpg","signature":"人乐有缘，诺以终身","alt":"http://www.douban.com/people/suoliweng/","id":"1026935","name":"蓑笠翁"},"summary":"现在好象比较时兴将人分为体制内和体制外的人,体制外的人通常有某种优越感,似乎自己的人格才是独立的.可实际上,真正愿意做体制外的人还是很少的,而且是很痛苦的.余杰北大硕士毕业后差一点进了他想进的国家图书馆...","alt":"https://movie.douban.com/review/1005528/","id":"1005528"},{"rating":{"max":5,"value":1,"min":0},"title":"没能力自由，谈什么自由 \u2014\u2014 其实你没那么渴望自由","subject_id":"1292052","author":{"uid":"58035060","avatar":"http://img7.doubanio.com/icon/u58035060-33.jpg","signature":"只想找到养好自己的灵魂","alt":"http://www.douban.com/people/58035060/","id":"58035060","name":"附离"},"summary":"打一颗星并不是因为这部片很差，只是不明白怎么会是豆瓣电影里的头牌。用极端的踩来平衡下极端的捧。  N年前看的片子，当时觉得真不错。具体不错在哪里？或许是因为结局不错，主人公最终成功越狱到达梦想之地，观...","alt":"https://movie.douban.com/review/5449290/","id":"5449290"},{"rating":{"max":5,"value":5,"min":0},"title":"《肖申克的救赎》的一些幕后花絮","subject_id":"1292052","author":{"uid":"erichuang","avatar":"http://img7.doubanio.com/icon/u1187841-1.jpg","signature":"","alt":"http://www.douban.com/people/erichuang/","id":"1187841","name":"油爆虾"},"summary":" * 是否记得片尾有一行字幕\"In memory of Allen Greene\"？翻译成中文就是\"纪念Allen Greene \"。Allen Greene是《肖申克的救赎》编导Frank Darabont的经纪人，在影片完成 的前夕死于AIDS的并发症。 　　 　　* 是...","alt":"https://movie.douban.com/review/1062920/","id":"1062920"},{"rating":{"max":5,"value":5,"min":0},"title":"自由之梦","subject_id":"1292052","author":{"uid":"iserlohnwind","avatar":"http://img3.doubanio.com/icon/u1360856-37.jpg","signature":"刚刚开始的往昔，尚未来临的回忆","alt":"http://www.douban.com/people/iserlohnwind/","id":"1360856","name":"伊谢尔伦的风"},"summary":"你知道，束缚越紧，梦也就会在心里勒下越深的痕迹。《肖申克的救赎》是一场关于笼中鸟如何飞往自由的梦，用我一位网友的话来说，看了它，甚至会让人觉得重生。  而在观影过程中，我反复想起的另一部电影，是《海...","alt":"https://movie.douban.com/review/1135514/","id":"1135514"},{"rating":{"max":5,"value":4,"min":0},"title":"肖申克的救赎","subject_id":"1292052","author":{"uid":"131929722","avatar":"http://img7.doubanio.com/icon/u131929722-23.jpg","signature":"","alt":"http://www.douban.com/people/131929722/","id":"131929722","name":"喵喵喵\u2026"},"summary":"These walls are kind of funny like that. First you hate them, then you get used to them. Enough time passed, get so you depend on them. That`s institution alized. \u201c监狱里的高墙实在是很有趣。刚入狱...","alt":"https://movie.douban.com/review/8578369/","id":"8578369"}]
     * ratings_count : 873346
     * aka : ["月黑高飞(港)","刺激1995(台)","地狱诺言","铁窗岁月","消香克的救赎"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String original_title;
    private int collect_count;
    private ImagesBean images;
    private String douban_site;
    private String year;
    private String alt;
    private String id;
    private String mobile_url;
    private int photos_count;
    private String pubdate;
    private String title;
    private Object do_count;
    private boolean has_video;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private String website;
    private boolean has_schedule;
    private Object collection;
    private Object episodes_count;
    private boolean has_ticket;
    private Object current_season;
    private String mainland_pubdate;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<VideosBean> videos;
    private List<?> blooper_urls;
    private List<PopularCommentsBean> popular_comments;
    private List<String> languages;
    private List<WritersBean> writers;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> durations;
    private List<String> genres;
    private List<TrailersBean> trailers;
    private List<String> trailer_urls;
    private List<?> bloopers;
    private List<?> clip_urls;
    private List<CastsBean> casts;
    private List<String> countries;
    private List<PhotosBean> photos;
    private List<?> clips;
    private List<DirectorsBean> directors;
    private List<PopularReviewsBean> popular_reviews;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public Object getCollection() {
        return collection;
    }

    public void setCollection(Object collection) {
        this.collection = collection;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public List<?> getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(List<?> blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public List<PopularCommentsBean> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<PopularCommentsBean> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<WritersBean> getWriters() {
        return writers;
    }

    public void setWriters(List<WritersBean> writers) {
        this.writers = writers;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<?> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<?> bloopers) {
        this.bloopers = bloopers;
    }

    public List<?> getClip_urls() {
        return clip_urls;
    }

    public void setClip_urls(List<?> clip_urls) {
        this.clip_urls = clip_urls;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<?> getClips() {
        return clips;
    }

    public void setClips(List<?> clips) {
        this.clips = clips;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<PopularReviewsBean> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<PopularReviewsBean> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 9.6
         * details : {"1":526,"2":648,"3":11662,"4":92032,"5":479921}
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

        public static class DetailsBean {
            /**
             * 1 : 526
             * 2 : 648
             * 3 : 11662
             * 4 : 92032
             * 5 : 479921
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

    public static class ImagesBean {
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

    public static class VideosBean {
        /**
         * source : {"literal":"youku","pic":"http://img3.doubanio.com/f/movie/3bb15010bb66a89962a5faf0f7f071fec8aaa763/pics/movie/logo_youku_small.png","name":"优酷视频"}
         * sample_link : http://cps.youku.com/redirect.html?id=0000a213&url=http://v.youku.com/v_show/id_XMjgwNDkwNzE2.html
         * video_id : XMjgwNDkwNzE2
         * need_pay : true
         */

        private SourceBean source;
        private String sample_link;
        private String video_id;
        private boolean need_pay;

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public String getSample_link() {
            return sample_link;
        }

        public void setSample_link(String sample_link) {
            this.sample_link = sample_link;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public boolean isNeed_pay() {
            return need_pay;
        }

        public void setNeed_pay(boolean need_pay) {
            this.need_pay = need_pay;
        }

        public static class SourceBean {
            /**
             * literal : youku
             * pic : http://img3.doubanio.com/f/movie/3bb15010bb66a89962a5faf0f7f071fec8aaa763/pics/movie/logo_youku_small.png
             * name : 优酷视频
             */

            private String literal;
            private String pic;
            private String name;

            public String getLiteral() {
                return literal;
            }

            public void setLiteral(String literal) {
                this.literal = literal;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class PopularCommentsBean {
        /**
         * rating : {"max":5,"value":5,"min":0}
         * useful_count : 618
         * author : {"uid":"jennyqueen","avatar":"http://img7.doubanio.com/icon/u1311269-2420.jpg","signature":"","alt":"http://www.douban.com/people/jennyqueen/","id":"1311269","name":"珍妮的肖像"}
         * subject_id : 1292052
         * content : 没有人会不喜欢吧！书和电影都好。
         * created_at : 2006-11-13 08:41:13
         * id : 7096858
         */

        private RatingBeanX rating;
        private int useful_count;
        private AuthorBean author;
        private String subject_id;
        private String content;
        private String created_at;
        private String id;

        public RatingBeanX getRating() {
            return rating;
        }

        public void setRating(RatingBeanX rating) {
            this.rating = rating;
        }

        public int getUseful_count() {
            return useful_count;
        }

        public void setUseful_count(int useful_count) {
            this.useful_count = useful_count;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanX {
            /**
             * max : 5
             * value : 5
             * min : 0
             */

            private int max;
            private int value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBean {
            /**
             * uid : jennyqueen
             * avatar : http://img7.doubanio.com/icon/u1311269-2420.jpg
             * signature :
             * alt : http://www.douban.com/people/jennyqueen/
             * id : 1311269
             * name : 珍妮的肖像
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class WritersBean {
        /**
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/230.jpg","large":"http://img7.doubanio.com/img/celebrity/large/230.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/230.jpg"}
         * name_en : Frank Darabont
         * name : 弗兰克·德拉邦特
         * alt : https://movie.douban.com/celebrity/1047973/
         * id : 1047973
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

        public static class AvatarsBean {
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

    public static class TrailersBean {
        /**
         * medium : http://img7.doubanio.com/img/trailer/medium/1433841022.jpg?
         * title : 预告片
         * subject_id : 1292052
         * alt : https://movie.douban.com/trailer/108756/
         * small : http://img7.doubanio.com/img/trailer/small/1433841022.jpg?
         * resource_url : http://vt3.doubanio.com/201709072118/4b39a629114164486eba6c31734b6552/view/movie/M/301080756.mp4
         * id : 108756
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class CastsBean {
        /**
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/17525.jpg","large":"http://img7.doubanio.com/img/celebrity/large/17525.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/17525.jpg"}
         * name_en : Tim Robbins
         * name : 蒂姆·罗宾斯
         * alt : https://movie.douban.com/celebrity/1054521/
         * id : 1054521
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

        public static class AvatarsBeanX {
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

    public static class PhotosBean {
        /**
         * thumb : http://img7.doubanio.com/view/photo/thumb/public/p712907932.webp
         * image : http://img7.doubanio.com/view/photo/photo/public/p712907932.webp
         * cover : http://img7.doubanio.com/view/photo/albumcover/public/p712907932.webp
         * alt : https://movie.douban.com/photos/photo/712907932/
         * id : 712907932
         * icon : http://img7.doubanio.com/view/photo/icon/public/p712907932.webp
         */

        private String thumb;
        private String image;
        private String cover;
        private String alt;
        private String id;
        private String icon;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class DirectorsBean {
        /**
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/230.jpg","large":"http://img7.doubanio.com/img/celebrity/large/230.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/230.jpg"}
         * name_en : Frank Darabont
         * name : 弗兰克·德拉邦特
         * alt : https://movie.douban.com/celebrity/1047973/
         * id : 1047973
         */

        private AvatarsBeanXX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanXX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanXX avatars) {
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

        public static class AvatarsBeanXX {
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

    public static class PopularReviewsBean {
        /**
         * rating : {"max":5,"value":5,"min":0}
         * title : 十年·肖申克的救赎
         * subject_id : 1292052
         * author : {"uid":"bighead","avatar":"http://img7.doubanio.com/icon/u1000152-22.jpg","signature":"微信公号：夜读症","alt":"http://www.douban.com/people/bighead/","id":"1000152","name":"大头绿豆"}
         * summary : 距离斯蒂芬·金（Stephen King）和德拉邦特（Frank Darabont）们缔造这部伟大的作品已经有十年了。我知道美好的东西想必大家都能感受，但是很抱歉，我的聒噪仍将一如既往。 在我眼里，肖申克的救赎与信念、自由和...
         * alt : https://movie.douban.com/review/1000369/
         * id : 1000369
         */

        private RatingBeanXX rating;
        private String title;
        private String subject_id;
        private AuthorBeanX author;
        private String summary;
        private String alt;
        private String id;

        public RatingBeanXX getRating() {
            return rating;
        }

        public void setRating(RatingBeanXX rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public AuthorBeanX getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBeanX author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
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

        public static class RatingBeanXX {
            /**
             * max : 5
             * value : 5
             * min : 0
             */

            private int max;
            private int value;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AuthorBeanX {
            /**
             * uid : bighead
             * avatar : http://img7.doubanio.com/icon/u1000152-22.jpg
             * signature : 微信公号：夜读症
             * alt : http://www.douban.com/people/bighead/
             * id : 1000152
             * name : 大头绿豆
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
