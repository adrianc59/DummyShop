package com.example.dummyapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences preferences;

    public Session(Context context){
         preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    //Getters
    public boolean getScanned(){ return preferences.getBoolean("scanKey", false); }

    //Setters
    public void setScanned(boolean scanned){ preferences.edit().putBoolean("scanKey", scanned).apply(); }
}
