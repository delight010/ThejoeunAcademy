package com.asolec.practicelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Message","MainActivity onCreate");

        TabLayout tabLayout = findViewById(R.id.tab_layout); // TabLayout 오타 주의
        //tab menu 모양
        tabLayout.addTab(tabLayout.newTab().setText("Email").setIcon(android.R.drawable.ic_dialog_email));
        tabLayout.addTab(tabLayout.newTab().setText("Dialer").setIcon(android.R.drawable.ic_dialog_dialer));
        tabLayout.addTab(tabLayout.newTab().setText("Map").setIcon(android.R.drawable.ic_dialog_map));
        tabLayout.addTab(tabLayout.newTab().setText("Dialog Info").setIcon(android.R.drawable.ic_dialog_info));
        tabLayout.addTab(tabLayout.newTab().setText("Alert").setIcon(android.R.drawable.ic_dialog_alert));


        ViewPager viewPager = findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adapter 연결
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

//    @Override
//    public void onButtonClick(int position, String text) {
//        //ToolBar-interface에서 받아온값 -> TextFragment 전달
//        Tab5Fragment_text textFragment = (Tab5Fragment_text) getSupportFragmentManager().findFragmentById(R.id.pager);
//        textFragment.changedTextProperties(position, text);
//        Log.v("Message","MainActivity onButtonClick // fontsize : " + position);
//    }
}