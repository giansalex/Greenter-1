package com.greenter.core.service;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;

/**
 * Base api service.
 */
public class ApiService {
    private static String _url;

    public static void setApiEndpoint(String url) {
        _url = url;
    }

    public ANRequest.GetRequestBuilder get(String path) {
        return AndroidNetworking.get(_url.concat(path));
    }

    public ANRequest.PostRequestBuilder post(String path) {
        return AndroidNetworking.post(_url.concat(path));
    }
}
