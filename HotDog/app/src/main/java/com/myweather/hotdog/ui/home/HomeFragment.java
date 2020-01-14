package com.myweather.hotdog.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.myweather.hotdog.GetData;
import com.myweather.hotdog.R;
import com.myweather.hotdog.Menu;
import com.myweather.hotdog.TopsListActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private View rt;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();
    public static final int UPDATE_TEXT=1;
    private Handler handler=new Handler(){
        public void  handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    adapter.notifyDataSetChanged();
                    setListViewHeightBasedOnChildren(listView);
                    break;
                default:
                    break;
            }
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        this.rt = root;
        ImageButton zhihu = root.findViewById(R.id.home_zhihu);
        ImageButton weibo = root.findViewById(R.id.home_weibo);
        ImageButton douyin = root.findViewById(R.id.home_douyin);
        ImageButton bili = root.findViewById(R.id.home_bilibili);
        ImageButton github = root.findViewById(R.id.home_git);
        ImageButton toutiao = root.findViewById(R.id.home_toutiao);
        ImageButton douban = root.findViewById(R.id.home_douban);
        ImageButton menu = root.findViewById(R.id.home_more);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Menu.class);
                startActivity(intent);
            }
        });
        zhihu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TopsListActivity.class);
                intent.putExtra("topListNameFromMainActivity", "知乎");
                intent.putExtra("id", "1");
                startActivity(intent);
            }
        });
        weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TopsListActivity.class);
                intent.putExtra("topListNameFromMainActivity", "微博");
                intent.putExtra("id", "58");
                startActivity(intent);
            }
        });
        douyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TopsListActivity.class);
                intent.putExtra("topListNameFromMainActivity", "抖音");
                intent.putExtra("id", "148");
                startActivity(intent);
            }
        });
        bili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TopsListActivity.class);
                intent.putExtra("topListNameFromMainActivity", "Bilibili");
                intent.putExtra("id", "115");
                startActivity(intent);
            }
        });
        douban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TopsListActivity.class);
                intent.putExtra("topListNameFromMainActivity", "豆瓣");
                intent.putExtra("id", "57");
                startActivity(intent);
            }
        });
        toutiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TopsListActivity.class);
                intent.putExtra("topListNameFromMainActivity", "头条");
                intent.putExtra("id", "150");
                startActivity(intent);
            }
        });
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TopsListActivity.class);
                intent.putExtra("topListNameFromMainActivity", "Github");
                intent.putExtra("id", "85");
                startActivity(intent);
            }
        });

        listView = root.findViewById(R.id.home_rebang_list);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        getnews();



        return root;
    }

    public void getnews(){
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String response= null;
                    try {
                        response = GetData.getHtml("https://www.tophub.fun:8080/GetAllInfoGzip?id=1");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    listNews(response);
                }
            }).start();
        }
    }
    private void listNews(String response)
    {
        try {
            JSONObject jsonObject=new JSONObject(response);
            String s1=jsonObject.getString("Data");
            JSONArray jsonArray=new JSONArray(s1);
            dataList.clear();
            for(int i = 0; i < jsonArray.length(); i++){
                dataList.add(jsonArray.getJSONObject(i).getString("Title"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("AAA", "error");
            Toast.makeText(getContext(), "请选择",Toast.LENGTH_SHORT).show();
        }
        Message message=new Message();
        message.what=UPDATE_TEXT;
        handler.sendMessage(message);
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView == null)
            return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
// pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}