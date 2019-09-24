package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        mEmail = findViewById(R.id.etEmail);
        mPassword = findViewById(R.id.etPassword);
        mLoginBtn = findViewById(R.id.btnLogin);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEmail == null) {
                    Toast.makeText(getApplicationContext(), "Enter E-mail", Toast.LENGTH_SHORT).show();
                    mEmail.requestFocus();
                } else if (mPassword == null) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                    mPassword.requestFocus();
                } else {
                    Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
                    startActivity(intent);
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
