package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private TextView checkoutTotal;
    private Button cashBtn;
    private Button cardBtn;

    private String vendor;
    private double total;
    private ArrayList<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();
        vendor = intent.getStringExtra("VENDOR");
        Bundle args = intent.getBundleExtra("BUNDLE");
        itemList = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        total = intent.getDoubleExtra("TOTAL", 0);

        checkoutTotal = findViewById(R.id.checkoutTotal);
        checkoutTotal.setText("Total: " + String.format("%.2f", total));

        cashBtn = findViewById(R.id.cashBtn);
        cardBtn = findViewById(R.id.cardBtn);

        cashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, PrintOptionActivity.class);
                intent.putExtra("VENDOR", vendor);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable)itemList);
                intent.putExtra("BUNDLE", args);
                intent.putExtra("TOTAL", total);
                intent.putExtra("PAYMENT_TYPE", 0);
                startActivity(intent);
            }
        });

        cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, PrintOptionActivity.class);
                intent.putExtra("VENDOR", vendor);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable)itemList);
                intent.putExtra("BUNDLE", args);
                intent.putExtra("TOTAL", total);
                intent.putExtra("PAYMENT_TYPE", 1);
                startActivity(intent);
            }
        });
    }
}
