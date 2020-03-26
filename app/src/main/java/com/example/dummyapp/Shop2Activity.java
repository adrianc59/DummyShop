package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop2Activity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private Button checkoutBtn;

    private String vendor;
    private String location;
    private double lat;
    private double lng;

    private LinearLayout layout;
    private double total;
    private TextView totalView;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop2);

        Intent intent = getIntent();
        vendor = intent.getStringExtra("VENDOR");
        location = intent.getStringExtra("LOCATION");
        lat = intent.getDoubleExtra("LAT", 0);
        lng = intent.getDoubleExtra("LNG", 0);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        checkoutBtn = findViewById(R.id.checkoutBtn);

        itemList = new ArrayList<>();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Dishwasher:\t\t250.00"));
                total += 250.00;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Dishwasher", 250.00);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Dishwasher")) {
                            i.setQuantity(i.getQuantity() + 1);
                            inList = true;
                        }
                    }

                    if(!inList){
                        itemList.add(item);
                    }
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("TV:\t\t480.00"));
                total += 480.00;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("TV", 480.00);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("TV")) {
                            i.setQuantity(i.getQuantity() + 1);
                            inList = true;
                        }
                    }

                    if(!inList){
                        itemList.add(item);
                    }
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Fridge:\t\t199.99"));
                total += 199.99;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Fridge", 199.99);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Fridge")) {
                            i.setQuantity(i.getQuantity() + 1);
                            inList = true;
                        }
                    }

                    if(!inList){
                        itemList.add(item);
                    }
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Laptop:\t\t999.99"));
                total += 999.99;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Laptop", 999.99);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Laptop")) {
                            i.setQuantity(i.getQuantity() + 1);
                            inList = true;
                        }
                    }

                    if(!inList){
                        itemList.add(item);
                    }
                }
            }
        });

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop2Activity.this, CheckoutActivity.class);
                intent.putExtra("VENDOR", vendor);
                intent.putExtra("LOCATION", location);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable)itemList);
                intent.putExtra("BUNDLE", args);
                intent.putExtra("TOTAL", total);
                intent.putExtra("LNG", lng);
                intent.putExtra("LAT", lat);
                startActivity(intent);
            }
        });
    }

    private TextView createNewTextView(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        lparams.gravity = Gravity.BOTTOM;
        textView.setLayoutParams(lparams);
        textView.setText(text);
        textView.setTextSize(20);
        return textView;
    }
}
