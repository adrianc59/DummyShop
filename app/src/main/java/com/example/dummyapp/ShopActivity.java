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

public class ShopActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;
    private Button btn12;

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
        setContentView(R.layout.activity_shop);

        Intent intent = getIntent();
        vendor = intent.getStringExtra("VENDOR");
        location = intent.getStringExtra("LOCATION");
        lat = intent.getDoubleExtra("LAT", 0);
        lng = intent.getDoubleExtra("LNG", 0);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);

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

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Soup:\t\t2.00"));
                total += 2.00;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Soup", 2.00);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Soup")) {
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

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Coke:\t\t1.55"));
                total += 1.55;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Coke", 1.55);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Coke")) {
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

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Corn:\t\t0.45"));
                total += 0.45;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Corn", 0.45);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Corn")) {
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

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Juice:\t\t1.39"));
                total += 1.39;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Juice", 1.39);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Juice")) {
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

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Sauce:\t\t1.85"));
                total += 1.85;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Sauce", 1.85);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Sauce")) {
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

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Tomato:\t\t0.30"));
                total += 0.30;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Tomato", 0.30);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Tomato")) {
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

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Bread:\t\t2.19"));
                total += 2.19;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Bread", 2.19);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Bread")) {
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

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = findViewById(R.id.itemLayout);
                layout.addView(createNewTextView("Butter:\t\t2.59"));
                total += 2.59;
                totalView = findViewById(R.id.totalView);
                totalView.setText("Total:" + String.format("%.2f", total));

                Item item = new Item("Butter", 2.59);

                boolean inList = false;

                if(itemList.size() == 0) {
                    itemList.add(item);
                }
                else{
                    for (Item i : itemList) {
                        if (i.getName().equals("Butter")) {
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
