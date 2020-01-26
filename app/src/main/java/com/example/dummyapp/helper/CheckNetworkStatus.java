package com.example.dummyapp.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class CheckNetworkStatus {

    //Method to check network status of device is connected
    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network activeNetwork = connectivityManager.getActiveNetwork();
        
        return activeNetwork != null;

        //NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetwork();
        //return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
