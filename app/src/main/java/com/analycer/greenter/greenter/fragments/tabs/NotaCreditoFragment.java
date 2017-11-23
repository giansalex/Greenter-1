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
import com.greenter.core.model.Note;
import com.greenter.core.service.DataService;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotaCreditoFragment extends Fragment {


    private RecyclerView recycleNotaCre;
    private RecyclerViewFacAdapter adapter;


    public NotaCreditoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nota_credito, container, false);
        recycleNotaCre = view.findViewById(R.id.recycleNotaCre);
        adapter = new RecyclerViewFacAdapter(getActivity());

        return view;
    }

    public void loadDocs() {
        DataStore store = DataService
                .getInstance()
                .getStore();

        ArrayList<Note> ncr = new ArrayList<>();

        for (Note note:store.notes) {
            if (note.getTipoDoc().trim() == "07") {
                ncr.add(note);
            }
        }

        //adapter.setElement(ncr);
    }
}
