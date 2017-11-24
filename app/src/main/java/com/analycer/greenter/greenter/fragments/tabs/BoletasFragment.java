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
public class BoletasFragment extends Fragment {

    List<Invoice> boletas;
    RecyclerView recycleBol;
    private RecyclerViewFacAdapter adapter;

    public BoletasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_boletas, container, false);
        recycleBol = view.findViewById(R.id.recycleBol);
        recycleBol.setLayoutManager(new VegaLayoutManager());
        adapter = new RecyclerViewFacAdapter(getActivity());
        recycleBol.setAdapter(adapter);
        if (loadDocs()) {
            adapter.setElement(boletas);
        }
        return view;
    }

    public boolean loadDocs() {
        if (boletas != null) {
            return true;
        }

        DataStore store = DataService
                .getInstance()
                .getStore();

        if (store.invoices == null) {
            return false;
        }

        boletas = new ArrayList<>();

        for (Invoice invoice :
                store.invoices) {
            if (invoice.getTipoDoc().trim().equals("03")) {
                boletas.add(invoice);
            }
        }

        return true;
    }

}
