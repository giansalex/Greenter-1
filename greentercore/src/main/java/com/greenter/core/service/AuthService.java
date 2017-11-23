package com.greenter.core.service;


import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.AuthResponse;
import com.greenter.core.model.User;
import com.greenter.core.model.UserRegister;

public class AuthService extends ApiService {

    private ApiDataRequest<AuthResponse> callback;

    public AuthService(ApiDataRequest<AuthResponse> callback) {
        this.callback = callback;
    }

    public void login(User user) {
        post("/login")
        .addApplicationJsonBody(user)
        .setPriority(Priority.MEDIUM)
        .build()
        .getAsObject(AuthResponse.class, new ParsedRequestListener<AuthResponse>() {
            @Override
            public void onResponse(AuthResponse response) {
                ApiService.setToken(response.getToken());
                callback.setApiResponse(response);
            }

            @Override
            public void onError(ANError anError) {
            }
        });
    }

    public void register(UserRegister register) {
        post("/register")
        .addApplicationJsonBody(register)
        .setPriority(Priority.MEDIUM)
        .build()
        .getAsObject(AuthResponse.class, new ParsedRequestListener<AuthResponse>() {
            @Override
            public void onResponse(AuthResponse response) {
                ApiService.setToken(response.getToken());
                callback.setApiResponse(response);
            }

            @Override
            public void onError(ANError anError) {
            }
        });
    }

}
