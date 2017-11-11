package com.analycer.greenter.greenter.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analycer.greenter.greenter.R;
import com.example.greenter_core.callbackService;
import com.example.greenter_core.model.Invoice;
import com.example.greenter_core.services;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaFragment extends Fragment implements callbackService {

    private services mServices;
    public CategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);

        TextView textView = (TextView)view.findViewById(R.id.txtHola);
        mServices = new services(getActivity(),this);

        return view;
    }

    @Override
    public void getList(List<Invoice> invoiceList) {

    }
}
