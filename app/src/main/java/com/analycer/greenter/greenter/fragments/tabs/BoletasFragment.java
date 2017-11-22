package com.analycer.greenter.greenter.fragments.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analycer.greenter.greenter.R;
import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.service.DataService;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoletasFragment extends Fragment {


    public BoletasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_boletas, container, false);
    }

    public void loadDocs() {
        DataStore store = DataService
                .getInstance()
                .getStore();

        ArrayList<Invoice> boletas = new ArrayList<>();

        for (Invoice invoice :
                store.invoices) {
            if (invoice.getTipoDoc().trim() == "03") {
                boletas.add(invoice);
            }
        }


    }

}
