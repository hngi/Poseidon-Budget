package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;

public class HistoryActivity extends AppCompatActivity {

    private ImageButton mNavBtn;
    private CardView mNavCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        navSetUp();
    }

    public void profileBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), BudgetActivity.class);
        startActivity(intent);
    }

    public void addBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), AddNewActivity.class);
        startActivity(intent);
    }

    public void dashboardBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), DashBoardActivity.class);
        startActivity(intent);
    }

    public void navSetUp() {
        mNavBtn = findViewById(R.id.history_nav_btn);
        mNavBtn.setColorFilter(Color.argb(255, 255, 255, 255));
        mNavCard = findViewById(R.id.history_nav_card);
        mNavCard.setCardBackgroundColor(Color.parseColor("#055DA8"));
    }
}
