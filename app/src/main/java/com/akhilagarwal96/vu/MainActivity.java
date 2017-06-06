package com.akhilagarwal96.vu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Nav_Draw nav_draw = (Nav_Draw) getSupportFragmentManager().findFragmentById(R.id.nav_draw);
        nav_draw.setUp(R.id.nav_draw, (DrawerLayout) findViewById(R.id.draw_layout), toolbar);
        frameLayout = (FrameLayout) findViewById(R.id.frame);*/
    }
}