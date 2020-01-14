package com.myweather.hotdog;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<topNNews> mNewsList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView topnimage;
        TextView topnid;
        TextView newsname;
        String url;
        public ViewHolder(View view) {
            super(view);
//            topnimage = (ImageView) view.findViewById(R.id.topNImage);
            topnid = (TextView) view.findViewById(R.id.topnid);
            newsname = (TextView) view.findViewById(R.id.newsName);

            //添加点击事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),ContentPageActivity.class);
                    intent.putExtra("url", url);
                    v.getContext().startActivity(intent);
                }
            });

        }

    }

    public NewsAdapter(List<topNNews> newsList) {
        mNewsList = newsList;
        System.out.println(mNewsList.size()+"hahaha");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        topNNews topNNews = mNewsList.get(position);
//        holder.topnimage.setImageResource(topNNews.topNId);
        holder.topnid.setText(String.valueOf(topNNews.topn));
        holder.newsname.setText(topNNews.name);
        holder.url=topNNews.url;
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}