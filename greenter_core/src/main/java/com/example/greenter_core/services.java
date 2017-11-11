package com.example.greenter_core;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.greenter_core.model.Invoice;

import java.util.List;

/**
 * Created by LENOVO on 11/11/2017.
 */

public class services {

    private callbackService mCallbackService;
    public services(Context context, callbackService mcallbackService){
        AndroidNetworking.initialize(context);
        mCallbackService = mcallbackService;
    }

    void getVentas() {
        AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "3")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Invoice.class, new ParsedRequestListener<List<Invoice>>() {
                    @Override
                    public void onResponse(List<Invoice> response) {
                        mCallbackService.getList(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
