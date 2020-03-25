package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class VendorActivity extends AppCompatActivity {

    private Button tescoBtn;
    private Button supervalueBtn;
    private Button centraBtn;
    private Button currysBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        tescoBtn = findViewById(R.id.tescoBtn);
        supervalueBtn = findViewById(R.id.supervalueBtn);
        centraBtn = findViewById(R.id.centraBtn);
        currysBtn = findViewById(R.id.currysBtn);

        tescoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorActivity.this, ShopActivity.class);
                intent.putExtra("VENDOR", tescoBtn.getText().toString());
                intent.putExtra("LNG", "53.998624");
                intent.putExtra("LAT", "-6.404744");
                startActivity(intent);
            }
        });

        supervalueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorActivity.this, ShopActivity.class);
                intent.putExtra("VENDOR", supervalueBtn.getText().toString());
                intent.putExtra("LNG", "53.968857");
                intent.putExtra("LAT", "-6.387873");
                startActivity(intent);
            }
        });

        centraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorActivity.this, ShopActivity.class);
                intent.putExtra("VENDOR", centraBtn.getText().toString());
                intent.putExtra("LNG", "53.830759");
                intent.putExtra("LAT", "-6.394370");
                startActivity(intent);
            }
        });

        currysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorActivity.this, Shop2Activity.class);
                intent.putExtra("VENDOR", currysBtn.getText().toString());
                intent.putExtra("LNG", "53.447480");
                intent.putExtra("LAT", "-6.224073");
                startActivity(intent);
            }
        });
    }
}
