package com.gradimut.poseidonbuget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public class DashBoardActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        rv = findViewById(R.id.recycler_history);

        RecyclerView.LayoutManager rvLayout= new LinearLayoutManager(this);

        rv.setLayoutManager(rvLayout);

    }
}
