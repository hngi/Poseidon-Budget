package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CurrencyActivity extends AppCompatActivity {

    public static String currencyText;
    private TextView mLeftCurrency, mainCurrency, mRightCurrency;
    private String[] currency;
    private int left, main, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        mainCurrency = findViewById(R.id.mainCurrency);
        mLeftCurrency = findViewById(R.id.leftCurrency);
        mRightCurrency = findViewById(R.id.rightCurrency);

        currency = new String[5];
        currency[0] = "$";
        currency[1] = "₦";
        currency[2] = "£";
        currency[3] = "€";
        currency[4] = "¥";

        left = 0;
        main = 1;
        right = 2;

        mLeftCurrency.setText(currency[left]);
        mainCurrency.setText(currency[main]);
        mRightCurrency.setText(currency[right]);

    }

    public void ctnBtn_onClick(View view) {
        currencyText = mainCurrency.getText().toString();
        Intent intent = new Intent(this, DashBoardActivity.class);
        startActivity(intent);
    }

    public void left_onClick(View view) {
        if (mLeftCurrency.getText() != currency[0]) {
            left--;
            main--;
            right--;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);

        } else if (mLeftCurrency.getText() == currency[0]) {
            left = 4;
            main = 0;
            right = 1;

            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else if (mainCurrency.getText() == currency[0]) {
            left = 3;
            main = 4;
            right = 0;

            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else {
            left = 2;
            main = 3;
            right = 4;

            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        }
    }

    public void right_onClick(View view) {
        if (mRightCurrency.getText() != currency[4]) {
            left++;
            main++;
            right++;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else if (mRightCurrency.getText() == currency[4]) {
            left = 3;
            main = 4;
            right = 0;

            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else if (mainCurrency.getText() == currency[4]) {
            left = 4;
            main = 0;
            right = 1;

            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else {
            left = 0;
            main = 1;
            right = 2;

            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        }
    }
}
