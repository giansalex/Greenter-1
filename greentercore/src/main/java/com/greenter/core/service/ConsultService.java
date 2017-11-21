package com.greenter.core.service;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.DniResponse;
import com.greenter.core.model.RucResponse;

public class ConsultService extends ApiService {

    public void getForRuc(String ruc, final ApiDataRequest<RucResponse> mCallbackService) {
        get("/consult/ruc/{ruc}")
                .addPathParameter("ruc", ruc)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(RucResponse.class, new ParsedRequestListener<RucResponse>() {
                    @Override
                    public void onResponse(RucResponse response) {
                        mCallbackService.setApiResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

    public void getForDni(String dni, final ApiDataRequest<DniResponse> mCallbackService) {
        get("/consult/dni/{dni}")
                .addPathParameter("dni", dni)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(DniResponse.class, new ParsedRequestListener<DniResponse>() {
                    @Override
                    public void onResponse(DniResponse response) {
                        mCallbackService.setApiResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
