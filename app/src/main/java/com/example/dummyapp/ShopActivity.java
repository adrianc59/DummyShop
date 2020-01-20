package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private Button checkoutBtn;

    private LinearLayout layout;
    private double total;
    private TextView totalView;
    private List<Item> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

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
                layout.addView(createNewTextView("Banana:\t\t0.45"));
                total += 0.45;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Banana", 0.45);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Banana")) {
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
                layout.addView(createNewTextView("Apple:\t\t0.30"));
                total += 0.30;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Apple", 0.30);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Apple")) {
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
                layout.addView(createNewTextView("Milk:\t\t2.30"));
                total += 2.30;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Milk", 2.30);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Milk")) {
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
                layout.addView(createNewTextView("Potatoes:\t\t8.00"));
                total += 8.00;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Potatoes", 8.00);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Potatoes")) {
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
                Intent intent = new Intent(ShopActivity.this, CheckoutActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST", (Serializable)itemList);
                intent.putExtra("BUNDLE", args);
                intent.putExtra("TOTAL", total);
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
