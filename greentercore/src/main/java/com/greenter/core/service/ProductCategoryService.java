package com.greenter.core.service;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.ProductCategory;

import java.util.List;

public class ProductCategoryService extends ApiService {
    private ApiDataRequest<List<ProductCategory>> mCallbackService;

    public ProductCategoryService(ApiDataRequest<List<ProductCategory>> mCallbackService) {
        this.mCallbackService = mCallbackService;
    }

    public void getList() {
        get("/product/category")
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(ProductCategory.class, new ParsedRequestListener<List<ProductCategory>>() {
                    @Override
                    public void onResponse(List<ProductCategory> response) {
                        mCallbackService.setApiResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
