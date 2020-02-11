package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class PrintOptionActivity extends AppCompatActivity {

    private Button popBtn;
    private Button paperBtn;

    private String vendor;
    private String paymentType;
    private ArrayList<Item> itemList;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_option);

        Intent intent = getIntent();
        vendor = intent.getStringExtra("VENDOR");
        Bundle args = intent.getBundleExtra("BUNDLE");
        itemList = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        total = intent.getDoubleExtra("TOTAL", 0);
        paymentType = intent.getStringExtra("PAYMENT_TYPE");

        popBtn = findViewById(R.id.popBtn);
        paperBtn = findViewById(R.id.paperBtn);

        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrintOptionActivity.this, ScanActivity.class);
                intent.putExtra("VENDOR", vendor);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable)itemList);
                intent.putExtra("BUNDLE", args);
                intent.putExtra("TOTAL", total);
                intent.putExtra("PAYMENT_TYPE", "Cash");
                startActivity(intent);
            }
        });
    }
}
