package com.myweather.hotdog;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TitleSelect extends AppCompatActivity implements AdapterView.OnItemClickListener{
    List<String> titles = new ArrayList<>();
    String path;
    String path_detail;
    String detail;
    Map<String, String[]> title_map = new HashMap();
    private List<Titles> mData = null;
    private Context mContext;
    private TitlesAdapter mTitlesAdapter = null;
    private ListView list_titles;
//    private int[] imgIds = new int[]{R.mipmap.head_icon1, R.mipmap.head_icon2, R.mipmap.head_icon3};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_select);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intent intent = getIntent();
        getType();
        setAdapter();
        ImageView rt = findViewById(R.id.menu_rt);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TitleSelect.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void setAdapter(){
        mContext = TitleSelect.this;
        list_titles = (ListView) findViewById(R.id.list_test);
        mData = new LinkedList<Titles>();
        for (int i = 0; i < titles.size(); i++){
            mData.add(new Titles(titles.get(i), "" ));
        }

        mTitlesAdapter = new TitlesAdapter((LinkedList<Titles>) mData, mContext);
        list_titles.setAdapter(mTitlesAdapter);
        list_titles.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext,"你点击了第" + position + "项",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TitleSelect.this, TopsListActivity.class);
        intent.putExtra("topListNameFromMainActivity", titles.get(position));
        intent.putExtra("id", title_map.get(titles.get(position))[0]);
        startActivity(intent);
    }

    public void getType(){
        path = "https://www.tophub.fun:8080/GetType";
        ThreadData threadTime = new ThreadData();
        threadTime.start();
    }

    public void getDetail(String title){
    }

    public class ThreadData extends Thread {
        public void run() {
            super.run();
            while (true) {
                try {
                    detail = GetData.getHtml(path);
                    Log.d("mine", path);
                    Log.d("mine", detail);
                    mHandlertime.sendEmptyMessage(0x001);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                refreshMSG();
            }
        }
    }

    public void refreshMSG() {
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
        }
    }


    Handler mHandlertime = new Handler(){
        //handleMessage为处理消息的方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:{
                    GetTypeBean getTypeBean = new Gson().fromJson(detail,GetTypeBean.class);
                    title_map.clear();
                    titles.clear();
                    List<GetTypeBean.DataBean> datas = getTypeBean.getData();
                    for(GetTypeBean.DataBean data: datas){
                        String[] i = new String[2];
                        i[0] = data.getId();
                        i[1] = data.getSort();
                        title_map.put(data.getTitle(),i);
                        titles.add(data.getTitle());
                    }
                    setAdapter();
                    break;
                }

                default:
                    break;

            }
        };
    };

}
