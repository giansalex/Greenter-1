package com.greenter.core.service;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.Category;
import com.greenter.core.model.Invoice;

import java.util.List;

public class ProductCategoryService extends ApiService {
    private ApiDataRequest<List<Category>> mCallbackService;

    public ProductCategoryService(ApiDataRequest<List<Category>> mCallbackService) {
        this.mCallbackService = mCallbackService;
    }

    public void getList() {
        get("/product/category")
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Invoice.class, new ParsedRequestListener<List<Category>>() {
                    @Override
                    public void onResponse(List<Category> response) {
                        mCallbackService.setApiResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
