package com.greenter.core.service;

import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.model.Note;

import java.util.List;

/**
 * Created by Giansalex on 22/11/2017.
 */

public class DataLoaderService {

    public void load(String ruc) {
        final DataService dataService = DataService.getInstance();

        SaleService saleService = new SaleService(new ApiDataRequest<List<Invoice>>() {
            @Override
            public void setApiResponse(List<Invoice> data) {
                dataService.setInvoices(data);
            }
        });
        NoteService noteService = new NoteService(new ApiDataRequest<List<Note>>() {
            @Override
            public void setApiResponse(List<Note> data) {
                dataService.setNotes(data);
            }
        });

        saleService.getList(ruc);
        noteService.getList(ruc);
    }
}
