package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BudgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);


        // setNavigationMenu();
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
    /*private void setNavigationMenu() {

        DrawableCompat.setTint(
                DrawableCompat.wrap(getDrawable(R.drawable.ic_add_black_24dp)),
                ContextCompat.getColor(this, R.color.black));
        DrawableCompat.setTint(
                DrawableCompat.wrap(getDrawable(R.drawable.ic_history_black_24dp)),
                ContextCompat.getColor(this, R.color.black));
        DrawableCompat.setTint(
                DrawableCompat.wrap(getDrawable(R.drawable.ic_home_black_24dp)),
                ContextCompat.getColor(this, R.color.black));
        DrawableCompat.setTint(
                DrawableCompat.wrap(getDrawable(R.drawable.ic_person_black_24dp)),
                ContextCompat.getColor(this, R.color.black));

    }*/
}
