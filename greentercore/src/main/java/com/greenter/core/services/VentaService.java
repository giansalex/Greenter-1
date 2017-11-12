package com.greenter.core.services;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.model.Invoice;

import java.util.List;

public class VentaService {

    private callbackService mCallbackService;

    public VentaService(callbackService mCallbackService) {

        this.mCallbackService = mCallbackService;
    }

    public void getVentas() {
        AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "3")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Invoice.class, new ParsedRequestListener<List<Invoice>>() {
                    @Override
                    public void onResponse(List<Invoice> response) {
                        mCallbackService.setList(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
