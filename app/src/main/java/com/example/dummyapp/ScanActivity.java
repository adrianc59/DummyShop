package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ScanActivity extends AppCompatActivity {

    private String vendor = "Tesco";
    private String currentDate;
    private String currentTime;
    private ArrayList<Item> itemList;
    private double total;
    private int paymentType;

    private ArrayList<Item> newItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        itemList = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        total = intent.getDoubleExtra("TOTAL", 0);
        paymentType = intent.getIntExtra("PAYMENT_TYPE", 0);

        currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        for(Item e : itemList){
            System.out.println("Name: " + e.getName());
            System.out.println("Quantity: " + e.getQuantity());
        }

        String message = vendor + "," + total + "," + paymentType + "," + currentDate + "," + currentTime;

        String hexMessage = StringToHexadecimal(message);

        HostCardEmulatorService.message = hexMessage;
    }

    public String StringToHexadecimal(String str) {
        StringBuffer sb = new StringBuffer();
        char ch[] = str.toCharArray();

        for(int i = 0; i < ch.length; i++) {
            String hexString = Integer.toHexString(ch[i]);
            sb.append(hexString);
        }

        String result = sb.toString();

        return result;
    }
}
