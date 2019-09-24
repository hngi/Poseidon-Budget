package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText mUsername, mEmail, mPassword;
    private TextView etLog;
    private Button mRegisterbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etLog = findViewById(R.id.txtLogin);
        mUsername = findViewById(R.id.etUsername);
        mEmail = findViewById(R.id.etEmail);
        mPassword = findViewById(R.id.etPassword);
        mRegisterbtn = findViewById(R.id.btnRegister);

        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mUsername == null) {
                        Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                        mUsername.requestFocus();
                    }
                    if (mEmail == null) {
                        Toast.makeText(getApplicationContext(), "Enter E-mail", Toast.LENGTH_SHORT).show();
                        mEmail.requestFocus();
                    }

                    if (mPassword == null) {
                        Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                        mPassword.requestFocus();
                    } else {
                        Intent intent = new Intent(SignupActivity.this, DashBoardActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (Exception e) {
                    Log.d("Register", "onClick: " + e.getMessage());
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
}
