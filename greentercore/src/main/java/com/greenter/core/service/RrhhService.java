package com.greenter.core.service;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.Receipt;

import java.util.List;

public class RrhhService extends ApiService {
    private ApiDataRequest<List<Receipt>> mCallbackService;

    public RrhhService(ApiDataRequest<List<Receipt>> mCallbackService) {
        this.mCallbackService = mCallbackService;
    }

    public void getList(String ruc) {
        get("/rrhh/{ruc}")
                .addPathParameter("ruc", ruc)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Receipt.class, new ParsedRequestListener<List<Receipt>>() {
                    @Override
                    public void onResponse(List<Receipt> response) {
                        mCallbackService.setApiResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
