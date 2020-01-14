package com.myweather.hotdog;

public class topNNews {
    public String name;
    public String url;
    public int topNId;
    public int topn;

    public topNNews(String name,String url, int topN ,int topNId) {
        this.name = name;
        this.url=url;
        this.topn = topN;
        this.topNId = topNId;
    }

    public String getName() {
        return name;
    }

    public int getTopNId() {
        return topNId;
    }
}