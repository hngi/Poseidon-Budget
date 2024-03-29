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
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gradimut.poseidonbuget.model.ItemModel;
import com.gradimut.poseidonbuget.sql.Database;
import com.gradimut.poseidonbuget.sql.DatabaseHelper;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BudgetActivity extends AppCompatActivity {

    private ImageButton mNavBtn;
    private CardView mNavCard;
    private TextView tvNoBudget, moneyTxtView;

    RecyclerView rv;
    BudgetAdapter itemAdapter;
    List<ItemModel> itmList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

//        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);
//
//        final String userId = sharedPreferences.getString("USERID","DEFAULT_NAME");



        TextView tvDate = findViewById(R.id.dateTxtView);
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");//formating according to my need
        String date = formatter.format(today);
        tvDate.setText(date);
        navSetUp();



        rv = findViewById(R.id.budetRV);
        itemAdapter = new BudgetAdapter(itmList);
        tvNoBudget = findViewById(R.id.tvNoBudget);
        moneyTxtView = findViewById(R.id.moneyTxtView);

        RecyclerView.LayoutManager rvLayout = new LinearLayoutManager(getApplicationContext());
        ((LinearLayoutManager) rvLayout).setReverseLayout(true);
        ((LinearLayoutManager) rvLayout).setStackFromEnd(true);
        rv.setLayoutManager(rvLayout);
        rv.setAdapter(itemAdapter);

        checkIt();


        populateBudget();
        // setNavigationMenu();
    }

    private void checkIt() {
        try {

            moneyTxtView = findViewById(R.id.moneyTxtView);


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
                        double amnt = Double.parseDouble(amount);
                        NumberFormat formatter = NumberFormat.getCurrencyInstance();
                        String moneyString = formatter.format(amnt);
                        moneyTxtView.setText(moneyString);

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



    private void populateBudget() {

        final SharedPreferences sharedPreferences2 = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

        final String userId = sharedPreferences2.getString("USERID","DEFAULT_NAME");
        final String budg = sharedPreferences2.getString("BUDGET_ID","DEFAULT_BUDG");

        Log.d("populateBudget 3 : ", budg);



        try {

            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());

            String[] strColumns = {
                    Database.Items.COLUMN_ITEM_NAME,
                    Database.Items.COLUMN_BUDGET_ALLOCATE,
            };

            String whereClause = Database.Items.COLUMN_USER_ID + " = ? " + " AND "  + Database.Items.COLUMN_BUDGET_ID + " = ? ";

            String[] whereArgs = {userId, budg};

            Cursor cursor = databaseHelper.read(
                    Database.Items.TABLE_NAME,
                    strColumns,
                    whereClause,
                    whereArgs,
                    null,
                    null,
                    null
            );


            if (cursor.isBeforeFirst()) {

                rv.setVisibility(View.VISIBLE);
                tvNoBudget.setVisibility(View.GONE);

                while (cursor.moveToNext()) {
                    ItemModel item = new ItemModel();

                    String itemName = cursor.getString(cursor.getColumnIndex(Database.Items.COLUMN_ITEM_NAME));
                    String budgetAllocate = cursor.getString(cursor.getColumnIndex(Database.Items.COLUMN_BUDGET_ALLOCATE));

                    float transform = Float.parseFloat(budgetAllocate);
                    int trans = (int) transform;
                    item.setItemName(itemName);
                    item.setBudgetAllocate("N " + trans);

                    itmList.add(item);
                    itemAdapter.notifyDataSetChanged();
                }
                cursor.close();
            } else {
                tvNoBudget.setVisibility(View.VISIBLE);
                rv.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            Log.d("populateBudget: ", e.getMessage());
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
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

    public void back_onClick(View view) {
        Toast.makeText(getApplicationContext(), "Hard beats soft!", Toast.LENGTH_SHORT).show();
    }

    public void profileBtn_onClick(View view) {
        Toast.makeText(getApplicationContext(), "You're here already silly...", Toast.LENGTH_LONG).show();
    }

    public void navSetUp() {
        mNavBtn = findViewById(R.id.profile_nav_btn);
        mNavBtn.setColorFilter(Color.argb(255, 255, 255, 255));
        //mNavBtn.setImageResource(R.drawable.ic_add_white_24dp);
        mNavCard = findViewById(R.id.profile_nav_card);
        mNavCard.setCardBackgroundColor(Color.parseColor("#055DA8"));
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
