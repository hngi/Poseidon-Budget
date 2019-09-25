package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gradimut.poseidonbuget.utils.PreferenceManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private SlideAdapter myadapter;

    private LinearLayout mIndicator;
    private TextView[] mDots;

    private Button mNextBtn, mBackBtn, mSkipBtn, mDone;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (new PreferenceManager(this).checkPreference()) {
//            loadNextActivity();
//        }
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

        mIndicator = findViewById(R.id.dotsLayout);

        mNextBtn = findViewById(R.id.nextBtn);
        mBackBtn = findViewById(R.id.prevBtn);
        mSkipBtn = findViewById(R.id.skip);
        mDone = findViewById(R.id.doneBtn);

        mNextBtn.setOnClickListener(this);
        mBackBtn.setOnClickListener(this);
        mDone.setOnClickListener(this);


        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        //Listener

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentPage + 1);
                Log.e("Current page", String.valueOf(mCurrentPage));
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
            if (i == mDots.length - 1) {
                mNextBtn.setEnabled(false);
                mBackBtn.setEnabled(true);
                mDone.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.GONE);
                mDone.setVisibility(View.VISIBLE);
                mDone.setText("Finish");
                mBackBtn.setText("Previous");

            } else {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mDone.setEnabled(false);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.VISIBLE);
                mDone.setVisibility(View.GONE);
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mNextBtn.setText("Next");
                mBackBtn.setText("");
            }

//            mCurrentPage = i;
//
//
//            if(i == 0 ){
//                mNextBtn.setEnabled(true);
//                mBackBtn.setEnabled(false);
//                mBackBtn.setVisibility(View.INVISIBLE);
//
//                mNextBtn.setText("Next");
//                mBackBtn.setText("");
//            }else if(i == mDots.length - 1){
//                Log.d("onPageSelected : ", String.valueOf(i));
//                mNextBtn.setEnabled(true);
//                mBackBtn.setEnabled(true);
//                mBackBtn.setVisibility(View.VISIBLE);
//
//                mNextBtn.setText("Finish");
//                mBackBtn.setText("Previous");
//            }else{
//
//                mNextBtn.setEnabled(true);
//                mBackBtn.setEnabled(true);
//                mBackBtn.setVisibility(View.VISIBLE);
//
//                mNextBtn.setText("Next");
//                mBackBtn.setText("Previous");
//
//            }
//
//
//            if(i == 2){
//                //start next Activity here with activity_next.xml layout
//                Intent intent = new Intent( MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.nextBtn :
                loadNextSlide();
                break;
            case R.id.prevBtn :
                break;
            case R.id.doneBtn :
                loadNextSlide();
                break;
        }

    }

    private void loadNextActivity() {
        Intent intent = new Intent( MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void loadNextSlide() {
        int next_slide = viewPager.getCurrentItem() + 1;
        if (next_slide < mDots.length) {
            viewPager.setCurrentItem(next_slide);
        } else {

            loadNextActivity();
        }
    }

//    private void loadPrevSlide() {
//        int prev_slide = viewPager.getCurrentItem()+1;
//        if (prev_slide < mDots.length) {
//            viewPager.setCurrentItem(prev_slide);
//        } else {
//
//            mNextBtn.setText("Finish");
//            mBackBtn.setText("Previous");
//        }
//    }
}
