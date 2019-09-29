package com.gradimut.poseidonbuget;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gradimut.poseidonbuget.model.Users;
import com.gradimut.poseidonbuget.sql.Database;
import com.gradimut.poseidonbuget.sql.DatabaseHelper;

import java.sql.SQLException;

public class SignupActivity extends AppCompatActivity {

    private EditText mUsername, mEmail, mPassword, mConfirmPass;
    private TextView etLog;
    private Button mRegisterbtn;
    private DatabaseHelper databaseHelper;
    private Users user;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progressDialog = new ProgressDialog(this);


        etLog = findViewById(R.id.txtLogin);
        mUsername = findViewById(R.id.etUsername);
        mEmail = findViewById(R.id.etEmail);
        mPassword = findViewById(R.id.etPassword);
        mConfirmPass = findViewById(R.id.confirmPass);

        mRegisterbtn = findViewById(R.id.btnRegister);

        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());

                ContentValues values = new ContentValues();

                String email = mEmail.getText().toString().trim();
                String username = mUsername.getText().toString().trim();
                String pass = mPassword.getText().toString().trim();
                String confirmPass = mConfirmPass.getText().toString().trim();

                progressDialog.setMessage("Logging...");
                progressDialog.show();


                    if (username.isEmpty()) {
                        // Check empty field
                        Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                        mUsername.requestFocus();
                    }
                    if (email.isEmpty()) {
                        // Check empty field
                        Toast.makeText(getApplicationContext(), "Enter E-mail", Toast.LENGTH_SHORT).show();
                        mEmail.requestFocus();
                    }

                    if (pass.isEmpty()) {
                        // Check empty field
                        Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                        mPassword.requestFocus();
                    }
                    if (!confirmPass.equals(pass)) {
                        // Check if confirm password match the password
                        Toast.makeText(getApplicationContext(), "Password do not match!", Toast.LENGTH_SHORT).show();
                        mConfirmPass.requestFocus();
                    } else {
                        try {

                            String[] strColumns = {
                                    Database.UserTable.COLUMN_USER_ID,
                            };

                            String whereClause = Database.UserTable.COLUMN_USER_EMAIL + " = ? ";

                            String[] whereArgs = {email};

                            Cursor cursor = databaseHelper.read(
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
                                cursor.close();
                                Toast.makeText(getApplicationContext(), "User exist!!", Toast.LENGTH_LONG).show();
                            } else {
                                // Inserting data to the database
                                values.put(Database.UserTable.COLUMN_USER_EMAIL, email);
                                values.put(Database.UserTable.COLUMN_USER_NAME, username);
                                values.put(Database.UserTable.COLUMN_USER_PASSWORD, pass);

                                long userId =  databaseHelper.Insert(Database.UserTable.TABLE_USER, values);


                                // Save data to the shared preference.
                                SharedPreferences sharedPreferences=getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("USERID", String.valueOf(userId));
                                editor.putString("USERNAME", username);
                                editor.putBoolean("isLoggedIn",true);

                                editor.apply();

                                emptyInputEditText();

                                Intent intent = new Intent(SignupActivity.this, DashBoardActivity.class);
                                startActivity(intent);
                                finish();
                            }

                        } catch (Exception e) {
                            Log.d("Signup", "onClick: " + e.getMessage());
                        }
                    }

            }
        });

        etLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg_intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(reg_intent);
            }
        });
    }


    private void emptyInputEditText() {
        mUsername.setText(null);
        mEmail.setText(null);
        mPassword.setText(null);
        mConfirmPass.setText(null);
    }
}
