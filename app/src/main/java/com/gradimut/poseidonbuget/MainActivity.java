package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlideAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);


        Intent reg_intent = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(reg_intent);

    }
}
