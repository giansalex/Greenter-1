package com.analycer.greenter.greenter.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analycer.greenter.greenter.R;
import com.greenter.core.model.Invoice;
import com.greenter.core.services.VentaService;
import com.greenter.core.services.callbackService;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaFragment extends Fragment implements callbackService {

    private VentaService mServices;
    public CategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);

        TextView textView = (TextView)view.findViewById(R.id.txtHola);
        mServices = new VentaService(this);

        return view;
    }

    @Override
    public void setList(List<Invoice> invoiceList) {

    }
}
