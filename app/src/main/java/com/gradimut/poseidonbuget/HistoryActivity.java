package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gradimut.poseidonbuget.model.BudgetModel;
import com.gradimut.poseidonbuget.sql.Database;
import com.gradimut.poseidonbuget.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private ImageButton mNavBtn;
    private CardView mNavCard;

    private TextView textView2;
    RecyclerView rv;
    HistoryAdapter itemAdapter;
    List<BudgetModel> itmList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rv = findViewById(R.id.recycler_history);
        itemAdapter = new HistoryAdapter(itmList);

        textView2 = findViewById(R.id.tvNoBudget);

        RecyclerView.LayoutManager rvLayout = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(rvLayout);
        rv.setAdapter(itemAdapter);

        populate();

        navSetUp();
    }

    private void populate() {
        try {

            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());

            String[] strColumns = {
                    Database.Budget.COLUMN_BUDGET_AMOUNT,
                    Database.Budget.COLUMN_BUDGET_NAME,
                    Database.Budget.COLUMN_DATETIME,
            };

            Cursor cursor = databaseHelper.read(
                    Database.Budget.TABLE_NAME,
                    strColumns,
                    null,
                    null,
                    null,
                    null,
                    null
            );


            if (cursor.isBeforeFirst()) {

                rv.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.GONE);

                while (cursor.moveToNext()) {
                    BudgetModel item = new BudgetModel();

                    String amount = cursor.getString(cursor.getColumnIndex(Database.Budget.COLUMN_BUDGET_AMOUNT));
                    String date = cursor.getString(cursor.getColumnIndex(Database.Budget.COLUMN_DATETIME));
                    String name = cursor.getString(cursor.getColumnIndex(Database.Budget.COLUMN_BUDGET_NAME));

                    item.setAmount(amount);
                    item.setDate(date);
                    item.setName(name);
//                    item.setImage(R.drawable.);

                    itmList.add(item);
                    itemAdapter.notifyDataSetChanged();
                }
                cursor.close();
            } else {
                textView2.setVisibility(View.VISIBLE);
                rv.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            Log.d("populateBudget: ", e.getMessage());
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
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

    public void historyBtn_onClick(View view) {
        Toast.makeText(getApplicationContext(), "You're here already silly...", Toast.LENGTH_LONG).show();
    }
    public void navSetUp() {
        mNavBtn = findViewById(R.id.history_nav_btn);
        mNavBtn.setColorFilter(Color.argb(255, 255, 255, 255));
        mNavCard = findViewById(R.id.history_nav_card);
        mNavCard.setCardBackgroundColor(Color.parseColor("#055DA8"));
    }
}
