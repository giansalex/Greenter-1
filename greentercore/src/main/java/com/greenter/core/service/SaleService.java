package com.greenter.core.service;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.Invoice;

import java.util.List;

public class SaleService extends ApiService {

    private ApiDataRequest<List<Invoice>> mCallbackService;

    public SaleService(ApiDataRequest<List<Invoice>> mCallbackService) {
        this.mCallbackService = mCallbackService;
    }

    public void getList(String ruc) {
        get("/sale/{ruc}")
                .addPathParameter("ruc", ruc)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Invoice.class, new ParsedRequestListener<List<Invoice>>() {
                    @Override
                    public void onResponse(List<Invoice> response) {
                        mCallbackService.setApiResponse(response);
                    }
                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
