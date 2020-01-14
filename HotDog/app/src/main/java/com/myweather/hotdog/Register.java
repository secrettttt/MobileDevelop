package com.myweather.hotdog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {
    private EditText user,password,confirm;
    private String zhanghao,mima,mima_confirm,detail;
    private int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        user = findViewById(R.id.register_et_zhanghao);
        password = findViewById(R.id.register_et_mima);
        confirm = findViewById(R.id.register_et_confirm);
        user.addTextChangedListener(new TextWatcher() {
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

        password.addTextChangedListener(new TextWatcher() {
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

        confirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mima_confirm = s.toString();
            }
        });

        findViewById(R.id.register_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mima_confirm.equals(mima)){
                    Thread log = new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            try {
                                detail = GetData.sendPost("http://www.kprun.club/index.php/api/Index/log_in","username=" + zhanghao + "&password=" + mima);
                                android.util.Log.d("mine", detail);
                                mHandlertime.sendEmptyMessage(0x001);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    log.start();
                }else{
                    Toast.makeText(Register.this, "密码不一致", Toast.LENGTH_SHORT).show();
                }
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
                            Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Log.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Register.this, "注册错误，请确认网络情况", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        android.util.Log.d("AAA", "error");
                        Toast.makeText(Register.this, "error", Toast.LENGTH_SHORT).show();
                    }

                    break;
                }
                default:
                    break;

            }
        };
    };
}
