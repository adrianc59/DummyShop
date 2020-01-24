package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dummyapp.helper.HttpJsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ScanActivity extends AppCompatActivity {

    private String vendor = "Tesco";
    private String currentDate;
    private String currentDateTime;
    private ArrayList<Item> itemList;
    private double total;
    private String paymentType;

    private ProgressDialog pDialog;
    private int success;
    private String message;

    private ArrayList<Item> newItemList;
    private String itemNames="";
    private String itemPrices="";
    private String itemQuantitys="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        itemList = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        total = intent.getDoubleExtra("TOTAL", 0);
        paymentType = intent.getStringExtra("PAYMENT_TYPE");

        currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

        for(Item e : itemList){
            System.out.println("Name: " + e.getName());
            System.out.println("Quantity: " + e.getQuantity());
            //put all names, prices and Quantities of Items into single parsed strings to be put into map
            itemNames.concat(e.getName()+"@");
            itemPrices.concat(e.getPrice()+"@");
            itemQuantitys.concat(+e.getQuantity()+"@");
        }

    }

    private class createUserAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Display proggress bar
            pDialog = new ProgressDialog(ScanActivity.this);
            pDialog.setMessage("Checking Database. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpJsonParser httpJsonParser = new HttpJsonParser();
            Map<String, String> httpParams = new HashMap<>();
            httpParams.put("date", currentDateTime);
            httpParams.put("vendor", vendor);
            httpParams.put("itemNames", itemNames);
            httpParams.put("itemPrices", itemPrices);
            httpParams.put("itemQuantitys", itemQuantitys);
            JSONObject jsonObject = httpJsonParser.makeHttpRequest("https://mysql03.comp.dkit.ie/D00198128/addReceiptPOS.php", "POST", httpParams);
            try {
                success = jsonObject.getInt("success");
                //if insertion fails *set something*
                if(success == 0){
                    message = jsonObject.getString("message");
                }
                //if insertion successful *set something*
                else{

                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(String result) {
            pDialog.dismiss();
            runOnUiThread(new Runnable() {
                public void run() {
                    if (success == 1) {
                        //Display success message(if needed)

                        //if success what happens next
                        //Intent i = new Intent(RegisterActivity.this, RecentTransactionsActivity.class);
                        //i.putExtra("user_id", user.getId());
                        //startActivity(i);
                        //Finish ths activity and go back to listing activity

                        finish();

                    } else {
                        Toast.makeText(ScanActivity.this,
                                message,
                                Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
    }
}
