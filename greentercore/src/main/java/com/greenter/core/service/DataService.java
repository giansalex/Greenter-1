package com.greenter.core.service;

import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.model.Note;

import java.util.List;


public class DataService {

    private DataStore dataStore = new DataStore();
    private static DataService instance = new DataService();

    public static DataService getInstance() {
        return instance;
    }
    /**
     * Get Data
     * @return data ventas.
     */
    public DataStore getStore() {
        return dataStore;
    }

    public void setDataStore(DataStore data) {
        dataStore = data;
        return;
    }

    public void setInvoices(List<Invoice> invoices) {

        dataStore.invoices = invoices;
    }

    public void setNotes(List<Note> notes) {

        dataStore.notes = notes;
    }
}
