package com.gradimut.poseidonbuget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BudgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);


        // setNavigationMenu();
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
