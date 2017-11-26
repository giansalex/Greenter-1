package com.greenter.core.service;

import com.greenter.core.model.Client;
import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.model.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientService {
    private DataStore store;

    public ClientService() {
        this.store = DataService.getInstance().getStore();
    }

    public ClientService(DataStore store) {
        this.store = store;
    }

    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        Map<String, String> codes = new HashMap<>();

        for (Invoice invoice:
             store.invoices) {

            Client client = invoice.getClient();
            if (isValid(client, codes)) {
                codes.put(client.getNumDoc(), "");
                clients.add(client);
            }
        }

        for (Note note:
                store.notes) {

            Client client = note.getClient();
            if (isValid(client, codes)) {
                codes.put(client.getNumDoc(), "");
                clients.add(client);
            }
        }

        return clients;
    }

    private boolean isValid(Client client, Map<String, String> codes) {
        if (client == null) {
            return false;
        }

        String nroDoc = client.getNumDoc();
        if (nroDoc == null || nroDoc.isEmpty()) {
            return false;
        }

        return !codes.containsKey(nroDoc);
    }
}
