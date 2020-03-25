package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class RescanActivity extends AppCompatActivity {

    private Button rescanBtn;
    private Button finishBtn;

    private String vendor;
    private ArrayList<Item> itemList;
    private double total;
    private int paymentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescan);

        Intent intent = getIntent();
        vendor = intent.getStringExtra("VENDOR");
        Bundle args = intent.getBundleExtra("BUNDLE");
        itemList = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        total = intent.getDoubleExtra("TOTAL", 0);
        paymentType = intent.getIntExtra("PAYMENT_TYPE", 0);

        rescanBtn = findViewById(R.id.rescanBtn);
        finishBtn = findViewById(R.id.finishBtn);

        rescanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RescanActivity.this, ScanActivity.class);
                intent.putExtra("VENDOR", vendor);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable)itemList);
                intent.putExtra("BUNDLE", args);
                intent.putExtra("TOTAL", total);
                intent.putExtra("PAYMENT_TYPE", paymentType);
                startActivity(intent);
            }
        });

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RescanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
