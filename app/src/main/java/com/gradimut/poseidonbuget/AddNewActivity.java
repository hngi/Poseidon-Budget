package com.gradimut.poseidonbuget;

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

import java.util.ArrayList;
import java.util.List;

public class AddNewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppCompatImageView mAddbugdet;
    private EditText budgetName, budgetAmount, firstET, secondET, thirdET, fourthET;
    private Spinner spinerOne, spinnerTwo, spinnerThree, spinnerFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

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

        // Get EditText value
        String _budgetName = budgetName.getText().toString().trim();
        String _budgetAmount = budgetAmount.getText().toString().trim();
        String _firstEt = firstET.getText().toString().trim();
        String _secondEt = secondET.getText().toString().trim();
        String _thirdEt = thirdET.getText().toString().trim();
        String _fourthEt = fourthET.getText().toString().trim();

        // Spinner click lister
        spinerOne.setOnItemSelectedListener(this);
        spinnerTwo.setOnItemSelectedListener(this);
        spinnerThree.setOnItemSelectedListener(this);
        spinnerFour.setOnItemSelectedListener(this);

        // Spinner Drop down menu
        List<Integer> priorities = new ArrayList<>();
        priorities.add(1);
        priorities.add(2);
        priorities.add(3);
        priorities.add(4);
        priorities.add(5);

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
                String one = spinerOne.getSelectedItem().toString();
                String two = spinnerTwo.getSelectedItem().toString();
                String three = spinnerThree.getSelectedItem().toString();
                String four = spinnerFour.getSelectedItem().toString();
                final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);

                final String userId = sharedPreferences.getString("USERID","DEFAULT_NAME");
                final String userName = sharedPreferences.getString("USERNAME","DEFAULT_EMAIL");


                Toast.makeText(getApplicationContext(), one + " " + two + " " + three + " " + four + " " + userName, Toast.LENGTH_LONG).show();

//                Toast.makeText(getApplicationContext(), firstET.getText().toString(), Toast.LENGTH_LONG).show();
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
