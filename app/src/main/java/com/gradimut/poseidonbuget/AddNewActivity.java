package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.EditText;

public class AddNewActivity extends AppCompatActivity {

    private AppCompatImageView mAddbugdet;
    private EditText one, two, three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);


    }

    public void profileBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), BudgetActivity.class);
        startActivity(intent);
    }

    public void dashboardBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), DashBoardActivity.class);
        startActivity(intent);
    }

    public void historyBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), HistoryActivity.class);
        startActivity(intent);
    }
}
