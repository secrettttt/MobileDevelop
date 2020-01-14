package com.myweather.hotdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.sackcentury.shinebuttonlib.ShineButton;

public class ContentPageActivity extends AppCompatActivity {
    String url;
    private void initView(){
        Intent intent = getIntent();
        url= intent.getStringExtra("url");
        ImageView rt = (ImageView) findViewById(R.id.rt_toplist);
        rt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext() ,MainActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_page);

        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initView();

        ShineButton btLike = (ShineButton) findViewById(R.id.bt_like);
        btLike.init(this);

        ShineButton btSmile = (ShineButton) findViewById(R.id.bt_smile);
        btSmile.init(this);

        ShineButton btHeart = (ShineButton) findViewById(R.id.bt_heart);
        btHeart.init(this);

        ShineButton btStart = (ShineButton) findViewById(R.id.bt_star);
        btStart.init(this);

        WebView newswebview = (WebView)findViewById(R.id.NewsWebView);
        newswebview.loadUrl(url);
    }
}
