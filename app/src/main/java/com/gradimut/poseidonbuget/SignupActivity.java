package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText mUsername, mEmail, mPassword;
    TextView etLog;
    Button mRegisterbtn;

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
                if (mEmail != null) {
                    Toast.makeText(getApplicationContext(), "Enter E-mail", Toast.LENGTH_SHORT).show();
                    mEmail.requestFocus();
                }
                if (mEmail != null) {
                    Toast.makeText(getApplicationContext(), "Enter E-mail", Toast.LENGTH_SHORT).show();
                    mEmail.requestFocus();
                }

                if (mPassword != null) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                    mEmail.requestFocus();
                }

                Intent dash_intent = new Intent(SignupActivity.this, DashBoardActivity.class);
                startActivity(dash_intent);
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
