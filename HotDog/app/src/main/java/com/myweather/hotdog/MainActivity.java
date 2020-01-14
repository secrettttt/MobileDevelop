package com.myweather.hotdog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.myweather.hotdog.ui.dashboard.DashboardFragment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;
    private MyDBOpenHelper myDBHelper;
    private SharedHelper sh;
    private String info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        info = "";
        Intent intent = getIntent();
        info = intent.getStringExtra("info");
        mContext = MainActivity.this;
        myDBHelper = new MyDBOpenHelper(mContext, "my.db", null, 1);
        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_people)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        if (info != null){
            switch (info){
                case("log"):
                    Log.d("main", "log");
                    navController.navigate(R.id.navigation_people);
                    break;
                case("sub"):
                    Log.d("main", "sub");
                    DashboardFragment dashboardFragment = new DashboardFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("title", intent.getStringExtra("title"));
                    bundle.putString("id", intent.getStringExtra("id"));
                    dashboardFragment.setArguments(bundle);
                    navController.navigate(R.id.navigation_dashboard,bundle);
                    break;
                default:
                    break;

            }
        }
    }

    @Override
    public void onClick(View v) {

    }
}
