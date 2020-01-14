package com.myweather.hotdog.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.myweather.hotdog.Menu;
import com.myweather.hotdog.R;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private String title;
    private ImageView add,delete;
    private ArrayList<String> titles;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        try {
            Bundle bundle = getArguments();
            title = bundle.getString("title");
            Log.d("Sub", title);
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = root.findViewById(R.id.subscribe_6);
        delete = root.findViewById(R.id.subscribe_7);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Menu.class);
                intent.putExtra("info","sub");
                startActivity(intent);
            }
        });

        return root;
    }

}