package com.greenter.core.service;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;

/**
 * NetWorking class.
 */
public final class NetWorking {

    /**
     * Inicializa el android networking.
     * @param context Context
     * @param url URL Endpoint
     */
    public static void init(Context context, String url) {
        AndroidNetworking.initialize(context);
        ApiService.setApiEndpoint(url);
    }
}
