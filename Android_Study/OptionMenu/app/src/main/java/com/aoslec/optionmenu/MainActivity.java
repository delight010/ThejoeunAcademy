package com.aoslec.optionmenu;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.SubMenu;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.aoslec.optionmenu.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    //위의 메뉴바를 클릭하면
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.add(0, 1, 0, "짜장");
        menu.add(0,2,0,"짬뽕");
        SubMenu etc = menu.addSubMenu("기타");
        etc.add(0,3,0,"우동");
        etc.add(0,4,0,"만두");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case 1: // menu id num
                Toast.makeText(this, "짜장은 달콤해", Toast.LENGTH_SHORT).show();
                return true; // 바로 return하고 끝내기 때문에 break;를 넣을 필요가 없음
            case 2: // menu id num
                Toast.makeText(this, "짬뽕은 매콤해", Toast.LENGTH_SHORT).show();
                return true; // 바로 return하고 끝내기 때문에 break;를 넣을 필요가 없음
            case 3: // menu id num
                Toast.makeText(this, "우동은 맛있어", Toast.LENGTH_SHORT).show();
                return true; // 바로 return하고 끝내기 때문에 break;를 넣을 필요가 없음
            case 4: // menu id num
                Toast.makeText(this, "만두는 바삭해", Toast.LENGTH_SHORT).show();
                return true; // 바로 return하고 끝내기 때문에 break;를 넣을 필요가 없음

        }

        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
         return true;
    }
}