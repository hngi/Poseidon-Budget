package com.gradimut.poseidonbuget;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CurrencyActivity extends AppCompatActivity {

    public static String currencyText;
    private TextView mLeftCurrency, mainCurrency, mRightCurrency;
    private String[] currency;
    private int left, main, right;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

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


        currencyText = mainCurrency.getText().toString();

        // Save data to the shared preference.
        SharedPreferences sharedPreferences = getSharedPreferences("USER_CURRENCY", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CURRENCY", currencyText);
        editor.apply();

    }

    public void ctnBtn_onClick(View view) {
        currencyText = mainCurrency.getText().toString();
        // Save data to the shared preference.
        SharedPreferences sharedPreferences = getSharedPreferences("USER_CURRENCY", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CURRENCY", currencyText);
        editor.apply();
        Intent intent = new Intent(this, DashBoardActivity.class);
        startActivity(intent);
    }

    public void left_onClick(View view) {
        if (mLeftCurrency.getText() == currency[0]) {
            left = 4;
            main = 0;
            right = 1;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);

        } else if (mLeftCurrency.getText() == currency[1]) {
            left = 0;
            main = 1;
            right = 2;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else if (mLeftCurrency.getText() == currency[2]) {
            left = 1;
            main = 2;
            right = 3;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else if (mLeftCurrency.getText() == currency[3]) {
            left = 2;
            main = 3;
            right = 4;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else {
            left = 3;
            main = 4;
            right = 0;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        }
    }

    public void right_onClick(View view) {
        if (mRightCurrency.getText() == currency[0]) {
            left = 4;
            main = 0;
            right = 1;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);

        } else if (mRightCurrency.getText() == currency[1]) {
            left = 0;
            main = 1;
            right = 2;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else if (mRightCurrency.getText() == currency[2]) {
            left = 1;
            main = 2;
            right = 3;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else if (mRightCurrency.getText() == currency[3]) {
            left = 2;
            main = 3;
            right = 4;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        } else {
            left = 3;
            main = 4;
            right = 0;
            mLeftCurrency.setText(currency[left]);
            mainCurrency.setText(currency[main]);
            mRightCurrency.setText(currency[right]);
        }
    }


  /*  public class UserSession {
        // Shared Preferences reference
        SharedPreferences pref;

        // Editor reference for Shared preferences
        SharedPreferences.Editor editor;

        // Context
        Context _context;

        // Shared preferences mode
        int PRIVATE_MODE = 0;

        // Shared preferences file name
        public static final String USERS = "CurrencyActivity";

        // User currency (make variable public to access from outside)
        public static final String KEY_Currency = "Currency";

        // Constructor
        public UserSession(Context context) {
            this._context = context;
            pref = _context.getSharedPreferences(USERS, PRIVATE_MODE);
            editor = pref.edit();
        }

        /**
         * Get stored session data

        public HashMap<String, String> getUserDetails() {

            //Use hashmap to store user credentials
            HashMap<String, String> user = new HashMap<String, String>();

            // user currency
            user.put(KEY_Currency, pref.getString(KEY_Currency, null));

            // return user
            return user;
        }
    }*/
}
