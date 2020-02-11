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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        tescoBtn = findViewById(R.id.tescoBtn);
        supervalueBtn = findViewById(R.id.supervalueBtn);
        centraBtn = findViewById(R.id.centraBtn);

        tescoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorActivity.this, ShopActivity.class);
                intent.putExtra("VENDOR", tescoBtn.getText().toString());
                startActivity(intent);
            }
        });

        supervalueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorActivity.this, ShopActivity.class);
                intent.putExtra("VENDOR", supervalueBtn.getText().toString());
                startActivity(intent);
            }
        });

        centraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorActivity.this, ShopActivity.class);
                intent.putExtra("VENDOR", centraBtn.getText().toString());
                startActivity(intent);
            }
        });
    }
}
