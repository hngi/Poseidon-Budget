package com.gradimut.poseidonbuget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {

    RecyclerView rv;

    ArrayList<DashModel> dashList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        rv = findViewById(R.id.recycler_history);

        dashList = new ArrayList<>();
        dashList.add(new DashModel(R.drawable.coins,"First salary", "24 October", "Naira","200000"));

        RecyclerView.LayoutManager rvLayout= new LinearLayoutManager(this);

        rv.setLayoutManager(rvLayout);

    }
}
