package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlideAdapter myadapter;

    private LinearLayout mIndicator;
    private TextView[] mDots;

    private Button mNextBtn, mBackBtn, mSkipBtn;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        mIndicator = findViewById(R.id.dotsLayout);

        mNextBtn = findViewById(R.id.nextBtn);
        mBackBtn = findViewById(R.id.prevBtn);
        mSkipBtn = findViewById(R.id.skip);


        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        //Listener

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentPage + 1);
            }
        });
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    public void addDotsIndicator(int position){
        mDots = new TextView[2];
        mIndicator.removeAllViews();

        for (int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mIndicator.addView(mDots[i]);

        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.indicator));


        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mCurrentPage = i;

            if(i == 0 ){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("");
            }else if(i == mDots.length - 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Finish");
                mBackBtn.setText("Previous");
            }else{

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("Previous");

            }


            if(i == mDots.length - 1){
                //start next Activity here with activity_next.xml layout
                Intent intent = new Intent( MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
