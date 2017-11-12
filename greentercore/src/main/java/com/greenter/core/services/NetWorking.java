package com.greenter.core.services;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;

/**
 * NetWorking class.
 */
public final class NetWorking {

    /**
     * Inicializa el android networking.
     * @param context
     */
    public static void init(Context context) {
        AndroidNetworking.initialize(context);
    }
}
