package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.StringReader;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText city;
    TextView resultArea;
    private final String url = "http://api.weatherapi.com/v1/forecast.json?key=cd908b9993b743618dc142344232504";
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        resultArea = findViewById(R.id.resultArea);
    }

    public void getWeatherDetails(View view) {
        String tempUrl = "";
        String ocity = city.getText().toString().trim();
        if(city.equals("")){
            resultArea.setText("City Field can not be empty!");
        }else {
            tempUrl ="https://api.weatherapi.com/v1/forecast.json?key=cd908b9993b743618dc142344232504&q=Pune&days=1&aqi=no&alerts=no";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("response",response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }

    }
}