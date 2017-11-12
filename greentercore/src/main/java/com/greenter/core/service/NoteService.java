package com.greenter.core.service;

import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.Note;

import java.util.List;

public class NoteService extends ApiService {
    private ApiDataRequest<List<Note>> mCallbackService;

    public NoteService(ApiDataRequest<List<Note>> mCallbackService) {
        this.mCallbackService = mCallbackService;
    }

    public void getList(String ruc) {
        get("/note/{ruc}")
                .addPathParameter("ruc", ruc)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Note.class, new ParsedRequestListener<List<Note>>() {
                    @Override
                    public void onResponse(List<Note> response) {
                        mCallbackService.setApiResponse(response);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
