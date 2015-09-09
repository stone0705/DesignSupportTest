package com.example.stone.designsupportdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    CoordinatorLayout coord;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FloatingActionButton fla;
    static boolean ishorizon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        coord = (CoordinatorLayout)findViewById(R.id.main_content);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        fla = (FloatingActionButton)findViewById(R.id.fab);
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        final ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        RecyclerFragment f1 = RecyclerFragment.newInstance(1);
        RecyclerFragment f2 = RecyclerFragment.newInstance(2);
        RecyclerFragment f3 = RecyclerFragment.newInstance(3);
        RecyclerFragment f4 = RecyclerFragment.newInstance(4);
        vpa.add(f1, "Linear");
        vpa.add(f2,"big");
        vpa.add(f3,"drag");
        vpa.add(f4, "expanable");
        viewPager.setAdapter(vpa);
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        //選單可滾動模式 預設固定
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        coord.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        fla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerFragment f = (RecyclerFragment) vpa.getItem(viewPager.getCurrentItem());
                f.add();
                //snackBar 23版有bug
                //Snackbar.make(v,"test",Snackbar.LENGTH_SHORT).show();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case(R.id.nav_removeAll):{
                        RecyclerFragment f = (RecyclerFragment) vpa.getItem(viewPager.getCurrentItem());
                        f.removeAll();
                        break;
                    }
                    case(R.id.nav_test1):{
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,test1Activity.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    }
                }
                menuItem.setChecked(false);
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
