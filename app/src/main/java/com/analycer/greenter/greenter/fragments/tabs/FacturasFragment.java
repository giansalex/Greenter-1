package com.analycer.greenter.greenter.fragments.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analycer.greenter.greenter.R;
import com.analycer.greenter.greenter.adapter.RecyclerViewFacAdapter;
import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.service.DataService;
import com.stone.vega.library.VegaLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FacturasFragment extends Fragment {

    List<Invoice> invoices;
    private RecyclerView mCecyclerFacturas;
    private RecyclerViewFacAdapter adapter;

    public FacturasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_facturas, container, false);
        // Inflate the layout for this fragment
        mCecyclerFacturas = view.findViewById(R.id.recycleFac);
        mCecyclerFacturas.setLayoutManager(new VegaLayoutManager());
        adapter = new RecyclerViewFacAdapter(getActivity());
        mCecyclerFacturas.setAdapter(adapter);
        if (loadDocs()) {
            adapter.setElement(invoices);
        }

       /* redColor = getResources().getColor(R.color.red);
        greenColor = getResources().getColor(R.color.green);*/

        return view;
    }

    public boolean loadDocs() {
        if (invoices != null) {
            return true;
        }

        DataStore store = DataService
                .getInstance()
                .getStore();

        if (store.invoices == null) {
            return false;
        }

        invoices = new ArrayList<>();

        for (Invoice invoice : store.invoices) {
            if (invoice.getTipoDoc().trim().equals("01")) {
                invoices.add(invoice);
            }
        }

        return true;
    }

}
