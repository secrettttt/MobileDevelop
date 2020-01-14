package com.myweather.hotdog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TopsListActivity extends AppCompatActivity {

    private List<topNNews> newsList = new ArrayList<>();
    private NewsAdapter adapter;
    String id;
    String path;
    String detail;
    public static final int UPDATE_TEXT=1;
    private Handler handler=new Handler(){
        public void  handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    };
    private void initView() {

        //从MainActivity获取topListNameFromActivity字符串
        Intent intent = getIntent();
        String topListNameFromMainActivity = intent.getStringExtra("topListNameFromMainActivity");
        id = intent.getStringExtra("id");
        TextView topListName = (TextView) findViewById(R.id.topListName);
        topListName.setText(topListNameFromMainActivity);
        ImageView rt = findViewById(R.id.leftBarTopList);

        topListName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TopsListActivity.this,"请选择",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TopsListActivity.this, Menu.class);
                startActivity(intent);
            }
        });
        rt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops_list);

        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initView();
        initNews();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_topList);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        getType();
    }

    private void initNews() {
        topNNews n1 = new topNNews("如何看待乔碧萝殿下首次露脸采访，称自己十年抑郁，大众是否能原谅接受她呢？","https://www.zhihu.com/question/286229191",1, R.drawable.logo);
        newsList.add(n1);
        topNNews n2 = new topNNews("男生健身真的可以变好看吗？","https://www.zhihu.com/question/286229191",2, R.drawable.logo);
        newsList.add(n2);
        topNNews n3 = new topNNews("大学老师上课时没人听是什么感觉？","https://www.zhihu.com/question/286229191",3, R.drawable.logo);
        newsList.add(n3);
        topNNews n4 = new topNNews("年轻爸爸从感情上更喜欢女儿吗？","https://www.zhihu.com/question/286229191",4,R.drawable.logo);
        newsList.add(n4);
        topNNews n5 = new topNNews("高冈由佳案（「不死鸟事件」）的由来是什么？如何看待双方的行为？","https://www.zhihu.com/question/286229191",5, R.drawable.logo);
        newsList.add(n5);
        topNNews n6 = new topNNews("我爱你，后面加什么最虐心？","https://www.zhihu.com/question/286229191",6,R.drawable.logo);
        newsList.add(n6);
        topNNews n7 = new topNNews("霸王龙前面两只小手手是干嘛用的？","https://www.zhihu.com/question/286229191",7, R.drawable.logo);
        newsList.add(n7);
        topNNews n8 = new topNNews("怕痒真的是所有女生的弱点么？","https://www.zhihu.com/question/286229191",8, R.drawable.logo);
        newsList.add(n8);
        topNNews n9 = new topNNews("《南方车站的聚会》中有哪些意味深长或细思恐及的细节？","https://www.zhihu.com/question/286229191",9, R.drawable.logo);
        newsList.add(n9);
        topNNews n10 = new topNNews("有哪些女孩子用的干净头像？","https://www.zhihu.com/question/286229191",10, R.drawable.logo);
        newsList.add(n10);
        for(int j=0;j<newsList.size();j++)
        {
            System.out.println("test"+newsList.get(j).getName());
        }
    }

    public void getType(){
        path = "https://www.tophub.fun:8080/GetAllInfoGzip?id=" + id;
        ThreadData threadData = new ThreadData();
        threadData.start();
    }

    public class ThreadData extends Thread {
        public void run() {
            super.run();
            try {
                detail = GetData.getHtml(path);
                Log.d("mine", path);
                Log.d("mine", detail);
                mHandlertime.sendEmptyMessage(0x001);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    Handler mHandlertime = new Handler(){
        //handleMessage为处理消息的方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:{
                    AllInfoBean allInfoBean = new Gson().fromJson(detail,AllInfoBean.class);
                    List<AllInfoBean.DataBean> datas = allInfoBean.getData();
                    newsList.clear();
                    for(int i=0;i<datas.size();i++){
                        topNNews n= new topNNews(datas.get(i).getTitle(),datas.get(i).getUrl(),i + 1, R.drawable.logo);
                        newsList.add(n);
                    }
                    Message message=new Message();
                    message.what=UPDATE_TEXT;
                    handler.sendMessage(message);
                    break;
                }
                default:
                    break;

            }
        };
    };
}
