package com.gradimut.poseidonbuget;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.gradimut.poseidonbuget.sql.Database;
import com.gradimut.poseidonbuget.sql.DatabaseHelper;
import com.gradimut.poseidonbuget.utils.PreferenceManager;

public class AddNewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageButton mNavBtn;
    private CardView mNavCard;
    private AppCompatImageButton addItem;
    private AppCompatButton mAllocate;
    private LinearLayout rootLayout;
    private View child;
    private EditText mItemName, mBudgetName, mBudgetAmout;
    private Spinner mSpinner;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_new);

        getSupportActionBar().setTitle("Make A Bugdet"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

        final String userId = sharedPreferences.getString("USERID","DEFAULT_NAME");


        navSetUp();

        addItem = findViewById(R.id.addItemRow);
        mAllocate = findViewById(R.id.allocateBtn);
        rootLayout = findViewById(R.id.parentlayout);
        mBudgetAmout = findViewById(R.id.budgetAmount);
        mBudgetName = findViewById(R.id.budgetName);

        // Add item row

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                child = getLayoutInflater().inflate(R.layout.one_item, null);
                rootLayout.addView(child);

            }
        });


        mAllocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String spinnerItem;

                String itemName;

                // Inserting data into budget database
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                ContentValues values = new ContentValues();

                SharedPreferences sharedPreferences=getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String budgetName = mBudgetName.getText().toString().trim();
                String budgetAmount = mBudgetAmout.getText().toString().trim();

                values.put(Database.Budget.COLUMN_BUDGET_NAME, budgetName);
                values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, budgetAmount);
                values.put(Database.Budget.COLUMN_USER_ID, userId);

                long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                editor.putString("BUDGET_ID", String.valueOf(budgetId));
                editor.apply();


                for (int i = 0; i < rootLayout.getChildCount(); i++) {
                    View view1 = rootLayout.getChildAt(i);
                    mItemName = view1.findViewById(R.id.itemNamess);
                    mSpinner = view1.findViewById(R.id.spinner);

                     spinnerItem = mSpinner.getSelectedItem().toString().trim();
                     itemName = mItemName.getText().toString().trim();




                    float allocate;


                    boolean condition = budgetName.isEmpty() || budgetAmount.isEmpty();


                    switch (spinnerItem) {
                        case "High":
                            if (condition) {
                                Toast.makeText(getApplicationContext(), "C'mon.. You have to enter all details", Toast.LENGTH_LONG).show();
                            } else {
                                DatabaseHelper databaseHelper2 = new DatabaseHelper(getApplicationContext());
                                ContentValues values2 = new ContentValues();

                                allocate = (float) 25 / 100 * Integer.parseInt(budgetAmount);
                                String _allocateString = String.valueOf(allocate);
                                try {


                                    // Inserting data into Items database
                                    values2.put(Database.Items.COLUMN_ITEM_NAME, itemName);
                                    values2.put(Database.Items.COLUMN_PRIORITY, spinnerItem);
                                    values2.put(Database.Items.COLUMN_BUDGET_ALLOCATE, _allocateString);
                                    values2.put(Database.Items.COLUMN_BUDGET_ID, budgetId);
                                    values2.put(Database.Items.COLUMN_USER_ID, userId);

                                    // Insert to the budegt Db
                                    databaseHelper2.Insert(Database.Items.TABLE_NAME, values2);

                                    Intent intent = new Intent(getApplicationContext(), BudgetActivity.class);
                                    startActivity(intent);
                                } catch (Exception e) {
                                    Log.d("Saving : ", e.getMessage());
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }


                            }

                            break;
                        case "Medium":
                            if (condition) {
                                Toast.makeText(getApplicationContext(), "C'mon.. You have to enter all details", Toast.LENGTH_LONG).show();
                            } else {

                                DatabaseHelper databaseHelper2 = new DatabaseHelper(getApplicationContext());
                                ContentValues values2 = new ContentValues();
                                allocate = (float) 15 / 100 * Integer.parseInt(budgetAmount);
                                String _allocateString = String.valueOf(allocate);

                                try {

                                    // Inserting data into Items database
                                    values2.put(Database.Items.COLUMN_ITEM_NAME, itemName);
                                    values2.put(Database.Items.COLUMN_PRIORITY, spinnerItem);
                                    values2.put(Database.Items.COLUMN_BUDGET_ALLOCATE, _allocateString);
                                    values2.put(Database.Items.COLUMN_BUDGET_ID, budgetId);
                                    values2.put(Database.Items.COLUMN_USER_ID, userId);


                                    // Insert to the budegt Db
                                    databaseHelper2.Insert(Database.Items.TABLE_NAME, values2);
                                    Intent intent = new Intent(getApplicationContext(), BudgetActivity.class);
                                    startActivity(intent);
                                } catch (Exception e) {
                                    Log.d("Saving : ", e.getMessage());
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }


                            }

                            break;
                        case "Low":
                            if (condition) {
                                Toast.makeText(getApplicationContext(), "C'mon.. You have to enter all details", Toast.LENGTH_LONG).show();
                            } else {
//                            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
//                            ContentValues values = new ContentValues();
                                DatabaseHelper databaseHelper2 = new DatabaseHelper(getApplicationContext());
                                ContentValues values2 = new ContentValues();


                                allocate = (float) 10 / 100 * Integer.parseInt(budgetAmount);
                                String _allocateString = String.valueOf(allocate);
                                try {

                                    // Inserting data into Items database
                                    values2.put(Database.Items.COLUMN_ITEM_NAME, itemName);
                                    values2.put(Database.Items.COLUMN_PRIORITY, spinnerItem);
                                    values2.put(Database.Items.COLUMN_BUDGET_ALLOCATE, _allocateString);
                                    values2.put(Database.Items.COLUMN_BUDGET_ID, budgetId);
                                    values2.put(Database.Items.COLUMN_USER_ID, userId);


                                    // Insert to the budegt Db
                                    databaseHelper2.Insert(Database.Items.TABLE_NAME, values2);

                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {

                                            progressBar = findViewById(R.id.progressBar);
                                            progressBar.setVisibility(View.VISIBLE);
                                            Intent i = new Intent(AddNewActivity.this, BudgetActivity.class);
                                            startActivity(i);
                                        }
                                    }, 2000);
                                    //Intent intent = new Intent(getApplicationContext(), BudgetActivity.class);
                                    //startActivity(intent);
                                } catch (Exception e) {
                                    Log.d("Saving : ", e.getMessage());
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                            break;
                    }
                }


            }
        });



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

    public void addBtn_onClick(View view) {
        Toast.makeText(getApplicationContext(), "You're here already silly...", Toast.LENGTH_LONG).show();
    }

    public void navSetUp() {
        mNavBtn = findViewById(R.id.add_nav_btn);
        mNavBtn.setColorFilter(Color.argb(255, 255, 255, 255));
        //mNavBtn.setImageResource(R.drawable.ic_add_white_24dp);
        mNavCard = findViewById(R.id.add_nav_card);
        mNavCard.setCardBackgroundColor(Color.parseColor("#055DA8"));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

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
            Intent i = new Intent(AddNewActivity.this, LoginActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
