package com.gradimut.poseidonbuget;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gradimut.poseidonbuget.sql.Database;
import com.gradimut.poseidonbuget.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class AddNewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppCompatImageView mAddbugdet;
    private EditText budgetName, budgetAmount, firstET, secondET, thirdET, fourthET;
    private Spinner spinerOne, spinnerTwo, spinnerThree, spinnerFour;

//    final String userName = sharedPreferences.getString("USERNAME","DEFAULT_EMAIL");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);


        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

        final String userId = sharedPreferences.getString("USERID","DEFAULT_NAME");

        budgetAmount = findViewById(R.id.budgetAmount);
        budgetName = findViewById(R.id.budgetName);

        budgetName = findViewById(R.id.budgetName);
        budgetAmount = findViewById(R.id.budgetAmount);

        firstET = findViewById(R.id.firstET);
        secondET = findViewById(R.id.secondET);
        thirdET = findViewById(R.id.thirdET);
        fourthET = findViewById(R.id.fourthET);

        spinerOne = findViewById(R.id.firstSP);
        spinnerTwo = findViewById(R.id.secondSP);
        spinnerThree = findViewById(R.id.thirdSP);
        spinnerFour = findViewById(R.id.fourthSP);

        mAddbugdet = findViewById(R.id.add_budget_btn);

        // Spinner click lister
        spinerOne.setOnItemSelectedListener(this);
        spinnerTwo.setOnItemSelectedListener(this);
        spinnerThree.setOnItemSelectedListener(this);
        spinnerFour.setOnItemSelectedListener(this);

        // Spinner Drop down menu
        List<Integer> priorities = new ArrayList<>();
        priorities.add(0);
        priorities.add(1);
        priorities.add(2);
        priorities.add(3);

        // Create Adapter for spinner
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, priorities);

        // Drop-down style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Attaching data adapter to spinner
        spinerOne.setAdapter(dataAdapter);
        spinnerTwo.setAdapter(dataAdapter);
        spinnerThree.setAdapter(dataAdapter);
        spinnerFour.setAdapter(dataAdapter);


        mAddbugdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());

                ContentValues values = new ContentValues();

                String _bugdetAmount = budgetAmount.getText().toString().trim();
                String _budgetName = budgetName.getText().toString().trim();

                String _firstEt = firstET.getText().toString().trim();
                String _secondEt = secondET.getText().toString().trim();
                String _thirdEt = thirdET.getText().toString().trim();
                String _fourthEt = fourthET.getText().toString().trim();


                int one = Integer.parseInt(spinerOne.getSelectedItem().toString());
                int two = Integer.parseInt(spinnerTwo.getSelectedItem().toString());
                int three = Integer.parseInt(spinnerThree.getSelectedItem().toString());
                int four = Integer.parseInt(spinnerFour.getSelectedItem().toString());
                float allocate;


                    if (_budgetName.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Budget name field should not be empty!!", Toast.LENGTH_SHORT).show();
                        budgetName.requestFocus();
                    }

                    else {
                        // First Input
                        if (one == 1 ) {

                            allocate = (float) 5 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _firstEt);
                            values.put(Database.Items.COLUMN_PRIORITY, one);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);



                        }

                        if (one == 2 ) {

                            allocate = (float) 10 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _firstEt);
                            values.put(Database.Items.COLUMN_PRIORITY, one);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                        }

                        if (one == 3 ) {

                            allocate = (float) 15 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _firstEt);
                            values.put(Database.Items.COLUMN_PRIORITY, one);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        // Second Input

                        if (two == 1 ) {

                            allocate = (float) 5 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _secondEt);
                            values.put(Database.Items.COLUMN_PRIORITY, two);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        if (two == 2 ) {

                            allocate = (float) 10 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _secondEt);
                            values.put(Database.Items.COLUMN_PRIORITY, two);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        if (two == 3 ) {

                            allocate = (float) 15 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _secondEt);
                            values.put(Database.Items.COLUMN_PRIORITY, two);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        // Third Input

                        if (three == 1 ) {

                            allocate = (float) 5 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _thirdEt);
                            values.put(Database.Items.COLUMN_PRIORITY, three);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        if (three == 2 ) {

                            allocate = (float) 10 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _thirdEt);
                            values.put(Database.Items.COLUMN_PRIORITY, three);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        if (three == 3 ) {

                            allocate = (float) 15 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _thirdEt);
                            values.put(Database.Items.COLUMN_PRIORITY, three);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        // Fourth input

                        if (four == 1 ) {

                            allocate = (float) 5 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _fourthEt);
                            values.put(Database.Items.COLUMN_PRIORITY, four);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        if (four == 2 ) {

                            allocate = (float) 10 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _fourthEt);
                            values.put(Database.Items.COLUMN_PRIORITY, four);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }

                        if (four == 3 ) {

                            allocate = (float) 15 / 100 * Integer.parseInt(_bugdetAmount);

                            // Inserting data into budget database
                            values.put(Database.Budget.COLUMN_BUDGET_NAME, _budgetName);
                            values.put(Database.Budget.COLUMN_BUDGET_AMOUNT, _bugdetAmount);
                            values.put(Database.Budget.COLUMN_USER_ID, userId);

                            // Insert to the budegt Db
                            long budgetId =  databaseHelper.Insert(Database.Budget.TABLE_NAME, values);

                            // Inserting data into Items database
                            values.put(Database.Items.COLUMN_ITEM_NAME, _fourthEt);
                            values.put(Database.Items.COLUMN_PRIORITY, four);
                            values.put(Database.Items.COLUMN_BUDGET_ALLOCATE, allocate);
                            values.put(Database.Items.COLUMN_BUDGET_ID, budgetId);

                            // Insert to the budegt Db
                            databaseHelper.Insert(Database.Budget.TABLE_NAME, values);
                        }


                    }


            }
        });






    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
