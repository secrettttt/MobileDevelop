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
import com.myweather.hotdog.ui.dashboard.DashboardFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    List<String> titles = new ArrayList<>();
    String path;
    String path_detail;
    String detail;
    Map<String, String> title_map = new HashMap();
    String title;
    String id;
    private String info;
//    private List<Titles> mData = null;
    private Context mContext;
//    private TitlesAdapter mTitlesAdapter = null;
//    private ListView list_titles;
    private SharedHelper sh;
//    private int[] imgIds = new int[]{R.mipmap.head_icon1, R.mipmap.head_icon2, R.mipmap.head_icon3};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intent intent = getIntent();
        if (intent == null || intent.getStringExtra("info") == null){
            info = "";
        }else{
            info = intent.getStringExtra("info");
        }
        ;
        mContext = getApplicationContext();
        sh = new SharedHelper(mContext);
        getType();
//        setAdapter();
        ImageView rt = findViewById(R.id.menu_rt);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.menu_36kr).setOnClickListener(this);
        findViewById(R.id.menu_bilibili_2).setOnClickListener(this);
        findViewById(R.id.menu_bilibili).setOnClickListener(this);
        findViewById(R.id.menu_douyin).setOnClickListener(this);
        findViewById(R.id.menu_zhihu).setOnClickListener(this);
        findViewById(R.id.menu_toutiao).setOnClickListener(this);
        findViewById(R.id.menu_itzhijia).setOnClickListener(this);
        findViewById(R.id.menu_zhongguancun).setOnClickListener(this);
        findViewById(R.id.menu_guoke).setOnClickListener(this);
        findViewById(R.id.menu_huxiu).setOnClickListener(this);
        findViewById(R.id.menu_shaoshupai).setOnClickListener(this);
        findViewById(R.id.menu_leikeji).setOnClickListener(this);
        findViewById(R.id.menu_kuaikeji).setOnClickListener(this);
        findViewById(R.id.menu_aifan).setOnClickListener(this);
        findViewById(R.id.menu_taimeiti).setOnClickListener(this);
        findViewById(R.id.menu_jiqizhixin).setOnClickListener(this);
        findViewById(R.id.menu_zhangzishi).setOnClickListener(this);
        findViewById(R.id.menu_acfun).setOnClickListener(this);
        findViewById(R.id.menu_qutoutiao).setOnClickListener(this);
        findViewById(R.id.menu_changku).setOnClickListener(this);
        findViewById(R.id.menu_mafengwo).setOnClickListener(this);
        findViewById(R.id.menu_jihe).setOnClickListener(this);
        findViewById(R.id.menu_maopu).setOnClickListener(this);
        findViewById(R.id.menu_jiandan).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.menu_36kr)){
            id = "12";
            title = "36Kr";
        }else if (v == findViewById(R.id.menu_bilibili) || v == findViewById(R.id.menu_bilibili_2)){
            id = "115";
            title = "哔哩哔哩";
        }else if (v == findViewById(R.id.menu_douyin)){
            id = "148";
            title = "抖音";
        }else if (v == findViewById(R.id.menu_zhihu)){
            id = "1";
            title = "知乎";
        }else if (v == findViewById(R.id.menu_toutiao)){
            id = "150";
            title = "今日头条";
        }else if (v == findViewById(R.id.menu_itzhijia)){
            id = "112";
            title = "IT之家";
        }else if (v == findViewById(R.id.menu_zhongguancun)){
            id = "1014";
            title = "中关村在线";
        }else if (v == findViewById(R.id.menu_guoke)){
            id = "86";
            title = "果壳";
        }else if (v == findViewById(R.id.menu_huxiu)){
            id = "8";
            title = "虎嗅";
        }else if (v == findViewById(R.id.menu_shaoshupai)){
            id = "116";
            title = "少数派";
        }else if (v == findViewById(R.id.menu_leikeji)){
            id = "119";
            title = "雷科技";
        }else if (v == findViewById(R.id.menu_kuaikeji)){
            id = "1048";
            title = "快科技";
        }else if (v == findViewById(R.id.menu_aifan)){
            id = "1007";
            title = "爱范";
        }else if (v == findViewById(R.id.menu_taimeiti)){
            id = "1015";
            title = "钛媒体";
        }else if (v == findViewById(R.id.menu_jiqizhixin)){
            id = "1025";
            title = "机器之心";
        }else if (v == findViewById(R.id.menu_zhangzishi)){
            id = "113";
            title = "涨姿势";
        }else if (v == findViewById(R.id.menu_acfun)){
            id = "142";
            title = "AcFun";
        }else if (v == findViewById(R.id.menu_qutoutiao)){
            id = "1047";
            title = "趣头条";
        }else if (v == findViewById(R.id.menu_changku)){
            id = "1016";
            title = "场库";
        }else if (v == findViewById(R.id.menu_mafengwo)){
            id = "130";
            title = "马蜂窝";
        }else if (v == findViewById(R.id.menu_jihe)){
            id = "129";
            title = "机核";
        }else if (v == findViewById(R.id.menu_maopu)){
            id = "108";
            title = "猫扑";
        }else if (v == findViewById(R.id.menu_jiandan)){
            id = "111";
            title = "煎蛋";
        }
        Intent intent = new Intent(Menu.this, TopsListActivity.class);
        if (info.equals("sub")){
            intent = new Intent(Menu.this, MainActivity.class);
        }
        intent.putExtra("title", title);
        intent.putExtra("id", id);
        intent.putExtra("info","sub");
        startActivity(intent);
    }
//
//    public void setAdapter(){
//        mContext = Menu.this;
//        list_titles = (ListView) findViewById(R.id.list_test);
//        mData = new LinkedList<Titles>();
//        for (int i = 0; i < titles.size(); i++){
//            mData.add(new Titles(titles.get(i), "" ));
//        }
//
//        mTitlesAdapter = new TitlesAdapter((LinkedList<Titles>) mData, mContext);
//        list_titles.setAdapter(mTitlesAdapter);
//        list_titles.setOnItemClickListener(this);
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(mContext,"你点击了第" + position + "项",Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(Menu.this, TopsListActivity.class);
//        intent.putExtra("topListNameFromMainActivity", titles.get(position));
//        intent.putExtra("id", title_map.get(titles.get(position))[0]);
//        startActivity(intent);
//    }
//
    public void getType(){
        path = "https://www.tophub.fun:8080/GetType";
        ThreadData threadTime = new ThreadData();
        threadTime.start();
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
                    List<GetTypeBean.DataBean> datas = getTypeBean.getData();
                    for(GetTypeBean.DataBean data: datas){
                        sh.saveId(data.getTitle(),data.getId());
                    }
                    break;
                }

                default:
                    break;

            }
        };
    };

}
