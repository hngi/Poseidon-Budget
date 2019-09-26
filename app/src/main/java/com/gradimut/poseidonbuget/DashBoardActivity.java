package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
        Intent intent = new Intent(view.getContext(), BudgetActivity.class);
        startActivity(intent);
    }

    public void historyBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), HistoryFragmant.class);
        startActivity(intent);
    }
}
