package com.example.dlulla.cryptocurrencyconverter;

import com.loopj.android.http.*;

public class CryptoCompareRestClient{
    private static final String BASE_URL = "https://min-api.cryptocompare.com/data/";
    private static AsyncHttpClient client = new AsyncHttpClient();
    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

}
