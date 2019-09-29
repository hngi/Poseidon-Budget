package com.gradimut.poseidonbuget;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.gradimut.poseidonbuget.sql.Database;
import com.gradimut.poseidonbuget.sql.DatabaseHelper;

public class AddNewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageButton mNavBtn;
    private CardView mNavCard;
    private AppCompatImageButton addItem;
    private AppCompatButton mAllocate;
    private LinearLayout rootLayout;
    private View child;
    private EditText mItemName, mBudgetName, mBudgetAmout;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

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


                String budgetName = mBudgetName.getText().toString().trim();
                String budgetAmount = mBudgetAmout.getText().toString().trim();

                values.put(Database.Budget.COLUMN_BUDGET_NAME, budgetName);
                values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, budgetAmount);
                values.put(Database.Budget.COLUMN_USER_ID, userId);

                long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);


                for (int i = 0; i < rootLayout.getChildCount(); i++) {
                    View view1 = rootLayout.getChildAt(i);
                    mItemName = view1.findViewById(R.id.itemNamess);
                    mSpinner = view1.findViewById(R.id.spinner);

                     spinnerItem = mSpinner.getSelectedItem().toString().trim();
                     itemName = mItemName.getText().toString().trim();




                    float allocate;


                    boolean condition = itemName.isEmpty() || budgetName.isEmpty() || budgetAmount.isEmpty();


                    if (spinnerItem.equals("High")) {
                        if (condition){
                            Toast.makeText(getApplicationContext(), "Can't save null input", Toast.LENGTH_LONG).show();
                        } else {
                            DatabaseHelper databaseHelper2 = new DatabaseHelper(getApplicationContext());
                            ContentValues values2 = new ContentValues();

                            allocate = (float) 15 / 100 * Integer.parseInt(budgetAmount);
                            String _allocateString = String.valueOf(allocate);
                            try {


                                // Insert to the budegt Db
//                                Log.d("BudgetId : ", String.valueOf(budgetId));
//                                Toast.makeText(getApplicationContext(), "Check this : " + (int) budgetId, Toast.LENGTH_LONG).show();

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

                    }

                    else if (spinnerItem.equals("Medium")) {
                        if (condition){
                            Toast.makeText(getApplicationContext(), "Can't save null input", Toast.LENGTH_LONG).show();
                        } else {

                            DatabaseHelper databaseHelper2 = new DatabaseHelper(getApplicationContext());
                            ContentValues values2 = new ContentValues();
                            allocate = (float) 10 / 100 * Integer.parseInt(budgetAmount);
                            String _allocateString = String.valueOf(allocate);

                            try {

                                // Insert to the budegt Db

//                                Log.d("BudgetId : ", String.valueOf(budgetId));
//                                Toast.makeText(getApplicationContext(), "Check this : " + (int) budgetId, Toast.LENGTH_LONG).show();

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

                    }

                    else if (spinnerItem.equals("Low")) {
                        if (condition){
                            Toast.makeText(getApplicationContext(), "Can't save null input", Toast.LENGTH_LONG).show();
                        } else {
//                            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
//                            ContentValues values = new ContentValues();
                            DatabaseHelper databaseHelper2 = new DatabaseHelper(getApplicationContext());
                            ContentValues values2 = new ContentValues();


                            allocate = (float) 5 / 100 * Integer.parseInt(budgetAmount);
                            String _allocateString = String.valueOf(allocate);
                            try {
                                // Inserting data into budget database
//                                values.put(Database.Budget.COLUMN_BUDGET_NAME, budgetName);
//                                values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, budgetAmount);
//                                values.put(Database.Budget.COLUMN_USER_ID, userId);

                                // Insert to the budegt Db


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
}
