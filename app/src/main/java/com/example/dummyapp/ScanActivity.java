package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ScanActivity extends AppCompatActivity {

    private String vendor = "Tesco";
    private String currentDate;
    private String currentTime;
    private ArrayList<Item> itemList;
    private double total;
    private String paymentType;

    private ArrayList<Item> newItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        itemList = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        total = intent.getDoubleExtra("TOTAL", 0);
        paymentType = intent.getStringExtra("PAYMENT_TYPE");

        currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        for(Item e : itemList){
            System.out.println("Name: " + e.getName());
            System.out.println("Quantity: " + e.getQuantity());
        }
    }
}
