package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView txtWelcome;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txtWelcome = findViewById(R.id.txtWelcome);
        imageView = findViewById(R.id.imgLogo);


        Animation _mainAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        Animation _skipAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_skip_anim);

        txtWelcome.startAnimation(_skipAnimation);
        imageView.startAnimation(_mainAnimation);


        final Intent intent = new Intent(this, MainActivity.class);

        Thread thread = new Thread() {
            public void run () {
                try {
                    sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };

        thread.start();
    }
}
