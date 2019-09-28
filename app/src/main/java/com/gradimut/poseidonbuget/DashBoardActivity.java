package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {

    RecyclerView rv;

    ArrayList<DashModel> dashList;

    private ImageButton mNavBtn;
    private CardView mNavCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        navSetUp();

        TextView userTV = findViewById(R.id.tvUsername);

        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

        final String userId = sharedPreferences.getString("USERID","DEFAULT_NAME");
        final String userName = sharedPreferences.getString("USERNAME","DEFAULT_EMAIL");

        userTV.setText(userName);

        rv = findViewById(R.id.recycler_history);

        dashList = new ArrayList<>();
        dashList.add(new DashModel(R.drawable.coins,"First salary", "24 October", "Naira","200000"));
        dashList.add(new DashModel(R.drawable.coins,"November salary", "2 November", "Naira","100000"));
        dashList.add(new DashModel(R.drawable.coins,"January salary", "24 January", "Naira","200000"));
        dashList.add(new DashModel(R.drawable.coins,"December salary", "03 December", "Naira","200000"));
        dashList.add(new DashModel(R.drawable.coins,"August salary", "24 August", "Naira","200000"));
        RecyclerView.LayoutManager rvLayout= new LinearLayoutManager(this);

        rv.setLayoutManager(rvLayout);

        // DashAdapter adapter = new DashAdapter(this, dashList);
        // rv.setAdapter(adapter);

    }

    public void profileBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), BudgetActivity.class);
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
        mNavBtn = findViewById(R.id.home_nav_btn);
        mNavBtn.setColorFilter(Color.argb(255, 255, 255, 255));
        //mNavBtn.setImageResource(R.drawable.ic_add_white_24dp);
        mNavCard = findViewById(R.id.home_nav_card);
        mNavCard.setCardBackgroundColor(Color.parseColor("#055DA8"));
    }
}
