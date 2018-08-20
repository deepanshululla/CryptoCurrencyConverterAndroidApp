package com.example.dlulla.cryptocurrencyconverter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.*;
import com.loopj.android.http.*;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;


public class CryptoCompareRestClientUsage {
    public static void getPrices(final String fromCurrency, final String toCurrency, final Integer crypVal, final Context cxt) throws JSONException{
        RequestParams requestParams=new RequestParams();
        requestParams.add("fsym",fromCurrency);
        requestParams.add("tsyms", toCurrency);
        CryptoCompareRestClient.get("price",requestParams,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {

                    Double currentValue=Double.parseDouble(response.getString(toCurrency));
                    Double finalVal=currentValue*crypVal;
                    Toast.makeText(cxt,crypVal+ " in "+fromCurrency+" = "+finalVal + " in "+toCurrency,Toast.LENGTH_LONG).show();
                    Log.i("Info",crypVal+ " in "+fromCurrency+" = "+finalVal + " in "+toCurrency);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        });
    }
}
