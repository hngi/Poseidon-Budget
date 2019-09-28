package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BudgetActivity extends AppCompatActivity {

    private ImageButton mNavBtn;
    private CardView mNavCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        TextView tvDate = findViewById(R.id.dateTxtView);
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");//formating according to my need
        String date = formatter.format(today);
        tvDate.setText(date);
        navSetUp();
    }

    public void dashboardBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), DashBoardActivity.class);
        startActivity(intent);
    }

    public void addBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), AddNewActivity.class);
        startActivity(intent);
    }

    public void historyBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), HistoryActivity.class);
        startActivity(intent);
    }

    public void navSetUp() {
        mNavBtn = findViewById(R.id.profile_nav_btn);
        mNavBtn.setColorFilter(Color.argb(255, 255, 255, 255));
        //mNavBtn.setImageResource(R.drawable.ic_add_white_24dp);
        mNavCard = findViewById(R.id.profile_nav_card);
        mNavCard.setCardBackgroundColor(Color.parseColor("#055DA8"));
    }
}
