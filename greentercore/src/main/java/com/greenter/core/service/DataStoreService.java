package com.greenter.core.service;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.DataStore;


public class DataStoreService extends ApiService {
    private ApiDataRequest<DataStore> mCallbackService;

    public DataStoreService(ApiDataRequest<DataStore> mCallbackService) {
        this.mCallbackService = mCallbackService;
    }

    public void getAll() {
        get("/documents")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(DataStore.class, new ParsedRequestListener<DataStore>() {
                    @Override
                    public void onResponse(DataStore response) {
                        mCallbackService.setApiResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
