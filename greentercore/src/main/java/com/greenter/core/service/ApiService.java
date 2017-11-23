package com.greenter.core.service;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.RequestBuilder;

/**
 * Base api service.
 */
public class ApiService {
    private static String _url;
    private static String _token;

    public static void setApiEndpoint(String url) {
        _url = url;
    }

    public static void setToken(String token) {
        _token = token;
    }

    public ANRequest.GetRequestBuilder get(String path) {
        ANRequest.GetRequestBuilder req = AndroidNetworking.get(_url.concat(path));
        setAuthorization(req);

        return req;
    }

    public ANRequest.PostRequestBuilder post(String path) {
        ANRequest.PostRequestBuilder req = AndroidNetworking.post(_url.concat(path));
        setAuthorization(req);

        return req;
    }

    private void setAuthorization(RequestBuilder request) {
        if (_token != null) {
            request.addHeaders("Authorization", "Bearer " + _token);
        }
    }
}
