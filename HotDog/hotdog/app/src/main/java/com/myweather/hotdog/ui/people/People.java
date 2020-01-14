package com.myweather.hotdog.ui.people;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myweather.hotdog.Log;
import com.myweather.hotdog.MainActivity;
import com.myweather.hotdog.R;
import com.myweather.hotdog.SharedHelper;
import com.myweather.hotdog.ui.people.ui.Collect;
import com.myweather.hotdog.ui.people.ui.Help;
import com.myweather.hotdog.ui.people.ui.Setting;
import com.myweather.hotdog.ui.people.ui.Subscribe;
import com.myweather.hotdog.ui.people.ui.Thumbsup;

import java.util.Map;

public class People extends Fragment {

    private PeopleViewModel mViewModel;
    private Button login,logout;
    private TextView tv_mima, tv_zhanghao;

    private Context mContext;
    private SharedHelper sh;
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(PeopleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_people, container, false);
        mContext = getContext();
        sh = new SharedHelper(mContext);
        login = root.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Log.class);
                startActivity(intent);
            }
        });
        logout = root.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sh.deleteUP();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("info","log");
                startActivity(intent);
            }
        });
        tv_mima = root.findViewById(R.id.people_tv_mima2);
        tv_zhanghao = root.findViewById(R.id.people_tv_zh2);
        Map<String,String> data = sh.readUser();
        android.util.Log.d("mine", "1" + data.getOrDefault("username","findNoUser"));
        if (data.getOrDefault("username","findNoUser") == "findNoUser" || data.getOrDefault("username","findNoUser") == ""){
            login.setVisibility(View.VISIBLE);
            logout.setVisibility(View.GONE);
        }else{
            tv_zhanghao.setText(data.get("username"));
            tv_mima.setText(data.get("passwd"));
            login.setVisibility(View.GONE);
            logout.setVisibility(View.VISIBLE);
        }
        root.findViewById(R.id.tv_shoucang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Collect.class);
//                startActivity(intent);
                Toast.makeText(getActivity(), "还没写好", Toast.LENGTH_SHORT).show();
            }
        });
        root.findViewById(R.id.tv_thumbsup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Thumbsup.class);
//                startActivity(intent);
                Toast.makeText(getActivity(), "还没写好", Toast.LENGTH_SHORT).show();
            }
        });
        root.findViewById(R.id.tv_dingyue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Subscribe.class);
//                startActivity(intent);
                Toast.makeText(getActivity(), "还没写好", Toast.LENGTH_SHORT).show();
            }
        });
        root.findViewById(R.id.tv_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Setting.class);
//                startActivity(intent);
                Toast.makeText(getActivity(), "还没写好", Toast.LENGTH_SHORT).show();
            }
        });
        root.findViewById(R.id.tv_help).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Help.class);
//                startActivity(intent);
                Toast.makeText(getActivity(), "还没写好", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

}
