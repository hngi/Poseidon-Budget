package com.gradimut.poseidonbuget.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.gradimut.poseidonbuget.R;

public class PreferenceManager {
    private Context context;
    private SharedPreferences sharedPreferences;

    public PreferenceManager(Context context) {
        this.context = context;
        getSharedPreference();
    }

    private void getSharedPreference() {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.my_pref), Context.MODE_PRIVATE);

    }

    public void writePreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_pref_key), "INIT_OK");
        editor.apply();
    }

    public boolean checkPreference() {
        boolean status = false;
        if (sharedPreferences.getString(context.getString(R.string.my_pref_key), "null").isEmpty()) {
            status = false;
        } else {
            status = true;
        }

        return status;
    }

    public void clearPref() {
        sharedPreferences.edit().clear().apply();
    }
}
