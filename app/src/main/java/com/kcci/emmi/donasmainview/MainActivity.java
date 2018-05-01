package com.kcci.emmi.donasmainview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ArrayList<HashMap<String, String>> tkykPoints;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fm = getSupportFragmentManager();
        Intent intent = getIntent();
        tkykPoints = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra("tkykPoints");

        findViewById(R.id.map_layout).setVisibility(View.GONE);
        findViewById(R.id.scroll).setVisibility(View.VISIBLE);

        MenuFragment mf = new MenuFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, mf);
        fragmentTransaction.commit();

        LinearLayout menu = (LinearLayout) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.map_layout).setVisibility(View.GONE);
                findViewById(R.id.scroll).setVisibility(View.VISIBLE);

                MenuFragment mf = new MenuFragment();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, mf);
                fragmentTransaction.commit();

            }
        });
        LinearLayout map = (LinearLayout) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            findViewById(R.id.map_layout).setVisibility(View.VISIBLE);
            findViewById(R.id.scroll).setVisibility(View.GONE);

            RegionFragment mf = new RegionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tkykPoints", tkykPoints);
            mf.setArguments(bundle);

            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.map_layout, mf);
            fragmentTransaction.commit();

            }
        });
    }

    @Override
    public void onBackPressed() {
        if ( pressedTime == 0 ) {
            Toast.makeText(MainActivity.this, " 한 번 더 누르면 종료됩니다." , Toast.LENGTH_LONG).show();
            pressedTime = System.currentTimeMillis();
        }
        else {
            int seconds = (int) (System.currentTimeMillis() - pressedTime);

            if ( seconds > 2000 ) {
                Toast.makeText(MainActivity.this, " 한 번 더 누르면 종료됩니다." , Toast.LENGTH_LONG).show();
                pressedTime = 0 ;
            }
            else {
                super.onBackPressed();
                finish(); // app 종료 시키기
            }
        }
    }
}
