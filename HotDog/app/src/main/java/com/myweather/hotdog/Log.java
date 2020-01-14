package com.myweather.hotdog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Log extends AppCompatActivity implements View.OnClickListener{
    private Button login;
    private EditText etz,etm;
    private String zhanghao;
    private String mima;
    private SharedHelper sh;
    private Context mContext;
    private String url = "http://www.kprun.club/index.php/api/Index/log_on";
    private String detail = "";
    private String user,password;
    private int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.log);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mContext = getApplicationContext();
        sh = new SharedHelper(mContext);
        etz = findViewById(R.id.log_et_zhanghao);
        etz.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                zhanghao = s.toString();
            }
        });
        etm = findViewById(R.id.log_et_mima);
        etm.setTransformationMethod(PasswordTransformationMethod.getInstance());
        etm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mima = s.toString();
            }
        });
        login = findViewById(R.id.log_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.util.Log.d("mine", "username=" + zhanghao + "&password=" + mima);
                Thread log = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                            try {
                                detail = GetData.sendPost(url,"username=" + zhanghao + "&password=" + mima);
                                android.util.Log.d("mine", detail);
                                mHandlertime.sendEmptyMessage(0x001);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    }
                };
                log.start();
            }
        });

        findViewById(R.id.log_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Log.this,Register.class);
                startActivity(intent);
            }
        });

    }

    Handler mHandlertime = new Handler(){
        //handleMessage为处理消息的方法
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:{
                    try {
                        JSONObject jsonObject=new JSONObject(detail);
                        code =jsonObject.getInt("code");
                        if (code == 200){
                            sh.save(zhanghao,mima);
                            Toast.makeText(Log.this, "信息已写入SharedPreference中", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Log.this, MainActivity.class);
                            intent.putExtra("info","log");
                            startActivity(intent);
                        }else{
                            sh.deleteUP();
                            Toast.makeText(Log.this, "密码错误", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        android.util.Log.d("AAA", "error");
                        Toast.makeText(Log.this, "error", Toast.LENGTH_SHORT).show();
                    }

                    break;
                }
                default:
                    break;

            }
        };
    };


    @Override
    public void onClick(View v) {

    }
}
