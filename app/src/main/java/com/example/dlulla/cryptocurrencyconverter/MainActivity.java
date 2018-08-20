package com.example.dlulla.cryptocurrencyconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public void onSubmit(View view) throws JSONException {
        Integer cryptoValue;
        String[] currArray=new String[]{"USD","BTC","LTC","ETH"};

        Spinner fromSpin=(Spinner) findViewById(R.id.fromSpinner);
        Spinner toSpin=(Spinner) findViewById(R.id.toSpinner);
        EditText cryptoValueField=(EditText) findViewById(R.id.cryptoValue);
        Log.i("info","Converting from "+fromSpin.getSelectedItem().toString()+
                " to "+toSpin.getSelectedItem().toString());
        Log.i("Value Entered:",cryptoValueField.getText().toString());
        if (cryptoValueField.getText().toString().isEmpty()){
            cryptoValue=0;
        } else {
            cryptoValue=Integer.parseInt(cryptoValueField.getText().toString());
        }
        Context cxt=this;
        CryptoCompareRestClientUsage.getPrices(fromSpin.getSelectedItem().toString(),toSpin.getSelectedItem().toString(),cryptoValue, cxt);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
