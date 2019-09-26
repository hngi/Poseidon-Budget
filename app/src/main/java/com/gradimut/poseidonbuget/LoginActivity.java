package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.database.Cursor;
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

public class LoginActivity extends AppCompatActivity {

    TextView txtLog;
    EditText mEmail;
    EditText mPassword;
    Button mLoginBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLog = findViewById(R.id.txtReg);
        mEmail = findViewById(R.id.logEmail);
        mPassword = findViewById(R.id.logPassword);
        mLoginBtn = findViewById(R.id.btnLogin);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());

                String email = mEmail.getText().toString().trim();
                String pass = mPassword.getText().toString().trim();

                    if (email.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Enter E-mail", Toast.LENGTH_SHORT).show();
                        mEmail.requestFocus();
                    }
                    if (pass.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                        mPassword.requestFocus();
                    }
                    try {

                        String[] strColumns = {
                                Database.UserTable.COLUMN_USER_ID,
                        };

                        String whereClause = Database.UserTable.COLUMN_USER_EMAIL + " = ? " + " AND " + Database.UserTable.COLUMN_USER_PASSWORD + " = ? ";


                        String[] whereArgs = {email, pass};

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
                            Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {
                        Log.d("Singin", "onClick: " + e.getMessage());
                    }

            }
        });


        txtLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg_intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(reg_intent);
            }
        });
    }
}
