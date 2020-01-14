package com.myweather.hotdog;

import java.util.List;

public class GetTypeBean {
    /**
     * Code : 0
     * Message : 获取数据成功
     * Data : [{"id":"1","sort":"491063","title":"知乎"},{"id":"2","sort":"164342","title":"虎扑"},{"id":"6","sort":"53603","title":"天涯"},{"id":"7","sort":"84977","title":"知乎日报"},{"id":"8","sort":"46936","title":"虎嗅"},{"id":"9","sort":"34635","title":"水木社区"},{"id":"10","sort":"48529","title":"网易"},{"id":"11","sort":"55948","title":"微信"},{"id":"12","sort":"61407","title":"36Kr"},{"id":"56","sort":"38818","title":"贴吧"},{"id":"57","sort":"66634","title":"豆瓣"},{"id":"58","sort":"100030","title":"微博"},{"id":"59","sort":"181822","title":"V2EX"},{"id":"60","sort":"25041","title":"Segmentfault"},{"id":"61","sort":"38756","title":"好奇心"},{"id":"62","sort":"37173","title":"黑客派"},{"id":"83","sort":"41290","title":"百度热搜"},{"id":"85","sort":"84053","title":"GitHub"},{"id":"86","sort":"35975","title":"果壳"},{"id":"105","sort":"15199","title":"凯迪"},{"id":"106","sort":"20719","title":"NGA"},{"id":"108","sort":"16844","title":"猫扑"},{"id":"109","sort":"21571","title":"Chiphell"},{"id":"110","sort":"17840","title":"抽屉"},{"id":"111","sort":"36691","title":"煎蛋"},{"id":"112","sort":"50535","title":"IT之家"},{"id":"113","sort":"19879","title":"涨姿势"},{"id":"114","sort":"22478","title":"开源中国"},{"id":"115","sort":"47693","title":"Bilibili"},{"id":"116","sort":"38463","title":"少数派"},{"id":"117","sort":"76432","title":"什么值得买"},{"id":"118","sort":"17996","title":"汽车之家"},{"id":"119","sort":"16533","title":"雷科技"},{"id":"120","sort":"36691","title":"澎湃新闻"},{"id":"121","sort":"14515","title":"亿欧"},{"id":"122","sort":"20577","title":"篝火"},{"id":"123","sort":"34835","title":"观察者"},{"id":"124","sort":"15671","title":"CbnData"},{"id":"125","sort":"86964","title":"吾爱破解"},{"id":"126","sort":"33001","title":"凤凰网"},{"id":"127","sort":"35284","title":"腾讯科技"},{"id":"128","sort":"15776","title":"界面新闻"},{"id":"129","sort":"17504","title":"机核"},{"id":"130","sort":"33492","title":"马蜂窝"},{"id":"131","sort":"16897","title":"投资界"},{"id":"132","sort":"18316","title":"数字尾巴"},{"id":"133","sort":"15963","title":"极客公园"},{"id":"134","sort":"15197","title":"时光网"},{"id":"135","sort":"17379","title":"每日趣图"},{"id":"136","sort":"19017","title":"每日GIF"},{"id":"137","sort":"14507","title":"WikiHow"},{"id":"138","sort":"32603","title":"蜂鸟网"},{"id":"139","sort":"32663","title":"TED"},{"id":"140","sort":"10176","title":"每日一文"},{"id":"141","sort":"17249","title":"ReadHub"},{"id":"142","sort":"43813","title":"AcFun"},{"id":"143","sort":"17472","title":"一亩三分地"},{"id":"144","sort":"11409","title":"巴比特"},{"id":"145","sort":"10183","title":"币世界"},{"id":"146","sort":"10734","title":"火星财经"},{"id":"147","sort":"10868","title":"星球日报"},{"id":"148","sort":"39066","title":"抖音"},{"id":"149","sort":"31927","title":"梨视频"},{"id":"150","sort":"53008","title":"今日头条"},{"id":"151","sort":"16071","title":"Zaker"},{"id":"152","sort":"38422","title":"简书"},{"id":"153","sort":"33717","title":"国家地理"},{"id":"154","sort":"46222","title":"掘金"},{"id":"155","sort":"14720","title":"上观"},{"id":"156","sort":"15012","title":"打喷嚏"},{"id":"157","sort":"15352","title":"壹心理"},{"id":"158","sort":"16170","title":"知识精选"},{"id":"159","sort":"15200","title":"收趣"},{"id":"160","sort":"14353","title":"360Doc"},{"id":"161","sort":"14329","title":"看看"},{"id":"162","sort":"15573","title":"今日看点"},{"id":"163","sort":"14449","title":"东方网"},{"id":"164","sort":"14792","title":"新京报"},{"id":"1007","sort":"15585","title":"爱范"},{"id":"1008","sort":"20087","title":"InfoQ最热"},{"id":"1009","sort":"18633","title":"InfoQ每日"},{"id":"1010","sort":"14651","title":"百度日报"},{"id":"1011","sort":"13721","title":"博海拾贝"},{"id":"1012","sort":"14937","title":"威峰网"},{"id":"1013","sort":"15482","title":"科普中国"},{"id":"1014","sort":"15392","title":"中关村在线"},{"id":"1015","sort":"14816","title":"钛媒体"},{"id":"1016","sort":"13987","title":"场库"},{"id":"1017","sort":"31073","title":"B站专栏"},{"id":"1018","sort":"14345","title":"CnBeta"},{"id":"1019","sort":"29060","title":"站酷"},{"id":"1020","sort":"13639","title":"飞客茶馆"},{"id":"1021","sort":"11532","title":"数英每日"},{"id":"1022","sort":"11703","title":"数英最热"},{"id":"1024","sort":"11166","title":"机器之心最新"},{"id":"1025","sort":"11418","title":"机器之心"},{"id":"1026","sort":"11068","title":"威锋社区"},{"id":"1027","sort":"10084","title":"金色财经"},{"id":"1028","sort":"10271","title":"淘宝实时跑量榜"},{"id":"1029","sort":"9351","title":"买买买羊毛线报"},{"id":"1030","sort":"8550","title":"惠惠热门折扣"},{"id":"1031","sort":"9869","title":"淘宝TOP销售榜"},{"id":"1033","sort":"5814","title":"微信阅读"},{"id":"1034","sort":"3965","title":"开发者头条"},{"id":"1035","sort":"3723","title":"Linux中国"},{"id":"1036","sort":"1519","title":"京东热销榜"},{"id":"1037","sort":"853","title":"京东秒杀"},{"id":"1038","sort":"839","title":"京东拼团"},{"id":"1039","sort":"878","title":"京东自营(热销榜)"},{"id":"1040","sort":"875","title":"京东自营(秒杀榜)"},{"id":"1042","sort":"43","title":"懂球帝"},{"id":"1043","sort":"50","title":"正在上映的电影（豆瓣）"},{"id":"1044","sort":"37","title":"虎扑NBA"},{"id":"1045","sort":"43","title":"雪球"},{"id":"1046","sort":"39","title":"好奇怪"},{"id":"1047","sort":"30","title":"趣头条"},{"id":"1048","sort":"23","title":"快科技"},{"id":"1049","sort":"30","title":"老司机"}]
     */

    private int Code;
    private String Message;
    private List<DataBean> Data;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * id : 1
         * sort : 491063
         * title : 知乎
         */

        private String id;
        private String sort;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
