package com.greenter.core.service;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;

/**
 * Base api service.
 */
public class ApiService {
    private static final String API_ENDPOINT = "http://greenterapp-quertium.1d35.starter-us-east-1.openshiftapps.com/api/v1";

    public ANRequest.GetRequestBuilder get(String url) {
        return AndroidNetworking.get(API_ENDPOINT.concat(url));
    }

    public ANRequest.PostRequestBuilder post(String url) {
        return AndroidNetworking.post(API_ENDPOINT.concat(url));
    }
}
