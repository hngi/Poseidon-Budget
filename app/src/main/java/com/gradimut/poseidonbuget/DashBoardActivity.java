package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gradimut.poseidonbuget.model.BudgetModel;
import com.gradimut.poseidonbuget.model.DashModel;
import com.gradimut.poseidonbuget.sql.Database;
import com.gradimut.poseidonbuget.sql.DatabaseHelper;
import com.gradimut.poseidonbuget.utils.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity {

    RecyclerView rv;


    private ImageButton mNavBtn;
    private CardView mNavCard;

    private TextView textView2, am;
    HistoryAdapter itemAdapter;
    List<BudgetModel> itmList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        ImageView imgView = findViewById(R.id.imageView);
        imgView.setColorFilter(Color.argb(255, 255, 255, 255));
        navSetUp();

        TextView userTV = findViewById(R.id.tvUsername);

        rv = findViewById(R.id.recycler_history);
        itemAdapter = new HistoryAdapter(itmList);

        textView2 = findViewById(R.id.tvNoBudget);

        RecyclerView.LayoutManager rvLayout = new LinearLayoutManager(getApplicationContext());
        ((LinearLayoutManager) rvLayout).setReverseLayout(true);
        ((LinearLayoutManager) rvLayout).setStackFromEnd(true);
        rv.setLayoutManager(rvLayout);
        rv.setAdapter(itemAdapter);

        checkIt();

        populate();


        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

        final String userName = sharedPreferences.getString("USERNAME","DEFAULT_EMAIL");

        userTV.setText(userName);

        rv = findViewById(R.id.recycler_history);

        rv.setLayoutManager(rvLayout);
    }

    private void checkIt() {
        try {

            am = findViewById(R.id.am);


            final SharedPreferences sharedPreferences2 = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

            final String userId = sharedPreferences2.getString("USERID","DEFAULT_NAME");


            DatabaseHelper helper = new DatabaseHelper(getApplicationContext());


            String[] strColumns = {
                    Database.UserTable.COLUMN_USER_ID,
            };

            String whereClause = Database.Budget.COLUMN_USER_ID + " = ? ";


            String[] whereArgs = {userId};

            Cursor cursor = helper.read(
                    Database.UserTable.TABLE_USER,
                    strColumns,
                    whereClause,
                    whereArgs,
                    null,
                    null,
                    null
            );

            int cursorCount = cursor.getCount();


            if (cursorCount >= 1) {

                String search = " SELECT " + Database.Budget.COLUMN_BUDGET_AMOUNT +  " FROM " + Database.Budget.TABLE_NAME +
                        " WHERE " + Database.Budget.COLUMN_USER_ID + " LIKE '%" + userId + "%'";
//                            String db = Database.DATABASE_NAME;
//                            String db = databaseHelper.getWritableDatabase();

                Cursor cursorSearch = helper.getWritableDatabase().rawQuery(search, null);

                if (cursorSearch.moveToFirst()) {
                    do {
                        String amount = cursorSearch.getString((cursorSearch.getColumnIndex(Database.Budget.COLUMN_BUDGET_AMOUNT)));

                        am.setText(amount);

                    } while (cursorSearch.moveToNext());

                } else {
                    Toast.makeText(getApplicationContext(), "No data was found in the system!", Toast.LENGTH_LONG).show();
                }

                cursorSearch.close();

            } else {
                Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Log.d("Singin", "onClick: " + e.getMessage());
        }
    }

    private void populate() {
        try {

            final SharedPreferences sharedPreferences2 = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

            final String userId = sharedPreferences2.getString("USERID","DEFAULT_NAME");

            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());

            String[] strColumns = {
                    Database.Budget.COLUMN_BUDGET_AMOUNT,
                    Database.Budget.COLUMN_BUDGET_NAME,
                    Database.Budget.COLUMN_DATETIME,
            };

            String whereClause = Database.Budget.COLUMN_USER_ID + " = ? ";


            String[] whereArgs = {userId};

            Cursor cursor = databaseHelper.read(
                    Database.Budget.TABLE_NAME,
                    strColumns,
                    whereClause,
                    whereArgs,
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

    public void historyBtn_onClick(View view) {
        Intent intent = new Intent(view.getContext(), HistoryActivity.class);
        startActivity(intent);
    }

    public void navSetUp() {
        mNavBtn = findViewById(R.id.home_nav_btn);
        mNavBtn.setColorFilter(Color.argb(255, 255, 255, 255));
        mNavCard = findViewById(R.id.home_nav_card);
        mNavCard.setCardBackgroundColor(Color.parseColor("#055DA8"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/
        if (id == R.id.action_logout) {
            sharedPreferences.edit().putString("USERID",null).apply();
            sharedPreferences.edit().putBoolean("isLoggedIn",false).apply();
            new PreferenceManager(this).checkPreference();
            Intent i = new Intent(DashBoardActivity.this, LoginActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
