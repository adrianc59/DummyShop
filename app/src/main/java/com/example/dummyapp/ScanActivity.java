package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.dummyapp.helper.CheckNetworkStatus;
import com.example.dummyapp.helper.HttpJsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class ScanActivity extends AppCompatActivity {

    private String vendor;
    private String currentDate;
    private String currentDateTime;
    private ArrayList<Item> itemList;
    private double total;
    private int paymentType;
    private String uuidString;

    private String barcode = "002432546754486754430211";
    private String cashier = "Sean Irwin";
    private Double cash;
    private String location;
    private double lng;
    private double lat;

    private ProgressDialog pDialog;
    private int success;
    private String errorMessage;

    private String itemNames="";
    private String itemPrices="";
    private String itemQuantities="";

    private Handler handler = new Handler();
    private int delay = 1000; //milliseconds
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        session = new Session(this);

        Intent intent = getIntent();
        vendor = intent.getStringExtra("VENDOR");
        location = intent.getStringExtra("LOCATION");
        lat = intent.getDoubleExtra("LAT", 0);
        lng = intent.getDoubleExtra("LNG", 0);

        Bundle args = intent.getBundleExtra("BUNDLE");
        itemList = (ArrayList<Item>) args.getSerializable("ARRAYLIST");
        total = intent.getDoubleExtra("TOTAL", 0);
        paymentType = intent.getIntExtra("PAYMENT_TYPE", 0);

        currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

        cash = total;

        UUID uuid = UUID.randomUUID();
        uuidString = uuid.toString();

        for(Item e : itemList){
            itemNames = itemNames.concat(e.getName()+"@");
            itemPrices = itemPrices.concat(e.getPrice()+"@");
            itemQuantities = itemQuantities.concat(+e.getQuantity()+"@");
        }

        String message = currentDate + "," + vendor + "," + total + "," + uuid.toString();
        String hexMessage = StringToHexadecimal(message);
        HostCardEmulatorService.message = hexMessage;
    
        if (CheckNetworkStatus.isNetworkAvailable(getApplicationContext())) {
            new createUserAsyncTask().execute();
        } else {
            Toast.makeText(ScanActivity.this,"Unable to connect to internet", Toast.LENGTH_LONG).show();
        }

        handler.postDelayed(new Runnable(){
            public void run(){
                if(session.getScanned() == true){
                    session.setScanned(false);
                    Intent intent = new Intent(ScanActivity.this, RescanActivity.class);
                    intent.putExtra("VENDOR", vendor);
                    intent.putExtra("LOCATION", location);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST", (Serializable)itemList);
                    intent.putExtra("BUNDLE", args);
                    intent.putExtra("TOTAL", total);
                    intent.putExtra("PAYMENT_TYPE", paymentType);
                    startActivity(intent);
                }

                handler.postDelayed(this, delay);
            }
        }, delay);
    }

    private String StringToHexadecimal(String str){
        StringBuffer sb = new StringBuffer();
        //Converting string to character array
        char ch[] = str.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            String hexString = Integer.toHexString(ch[i]);
            sb.append(hexString);
        }
        return sb.toString();
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
            httpParams.put("uuid", uuidString);
            httpParams.put("item_names", itemNames);
            httpParams.put("item_prices", itemPrices);
            httpParams.put("item_quantitys", itemQuantities);

            httpParams.put("barcode", barcode);
            httpParams.put("transaction_type", String.valueOf(paymentType));
            httpParams.put("cashier", cashier);
            httpParams.put("cash_given", String.valueOf(cash));
            httpParams.put("location", location);
            httpParams.put("lng", String.valueOf(lng));
            httpParams.put("lat", String.valueOf(lat));

            JSONObject jsonObject = httpJsonParser.makeHttpRequest("https://mysql03.comp.dkit.ie/D00198128/addReceiptPOS.php", "POST", httpParams);
            try {
                success = jsonObject.getInt("success");
                //if insertion fails *set something*
                if(success == 1){

                }
                else{
                    errorMessage = jsonObject.getString("message");
                    System.out.println("ERROR: " + errorMessage);
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
                    if (success != 1) {
                        System.out.println("error : " + errorMessage.toString());
                        Toast.makeText(ScanActivity.this,errorMessage,Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
