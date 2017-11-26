package com.analycer.greenter.greenter.fragments.tabslist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.analycer.greenter.greenter.R;
import com.analycer.greenter.greenter.adapter.FoldingCellListAdapter;
import com.analycer.greenter.greenter.adapter.Item;
import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.service.DataService;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoletasListFragment extends Fragment {

    List<Item> items;

    public BoletasListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_boletas_list, container, false);

        loadDocs();
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(getActivity(), items);

        ListView theListView = view.findViewById(R.id.mainListView);
        theListView.setAdapter(adapter);

        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
            }
        });

        return view;
    }

    private boolean loadDocs() {
        if (items != null) {
            return true;
        }

        DataStore store = DataService
                .getInstance()
                .getStore();

        if (store.invoices == null) {
            return false;
        }

        items = new ArrayList<>();

        Integer count = 1;
        for (Invoice invoice :
                store.invoices) {
            if (invoice.getTipoDoc().trim().equals("03")) {
                Date fec = invoice.getFechaEmision();
                items.add(new Item(count.toString(), invoice.getMtoImpVenta().toString(),
                        invoice.getSerie() +"-"+ invoice.getCorrelativo(),
                        invoice.getClient().getRznSocial(),
                        invoice.getDetails().size(),
                        DateFormat.format("EEE", fec).toString().toUpperCase(),
                        DateFormat.format("dd-MM-yy", fec).toString()));
                count++;
            }
        }

        return true;
    }
}
