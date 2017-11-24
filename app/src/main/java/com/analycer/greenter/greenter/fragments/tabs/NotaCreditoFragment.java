package com.analycer.greenter.greenter.fragments.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analycer.greenter.greenter.R;
import com.analycer.greenter.greenter.adapter.RecyclerViewFacAdapter;
import com.analycer.greenter.greenter.adapter.RecyclerViewNoteAdapter;
import com.greenter.core.model.DataStore;
import com.greenter.core.model.Note;
import com.greenter.core.service.DataService;
import com.stone.vega.library.VegaLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotaCreditoFragment extends Fragment {
    private List<Note> notes;

    public NotaCreditoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nota_credito, container, false);
        RecyclerView recycleNotaCre = view.findViewById(R.id.recycleNotaCre);
        recycleNotaCre.setLayoutManager(new VegaLayoutManager());
        RecyclerViewNoteAdapter adapter = new RecyclerViewNoteAdapter(getActivity());
        recycleNotaCre.setAdapter(adapter);

        loadDocs();
        adapter.setElement(notes);
        return view;
    }

    public void loadDocs() {
        if (notes != null) {
            return;
        }
        DataStore store = DataService
                .getInstance()
                .getStore();

        ArrayList<Note> ncr = new ArrayList<>();

        for (Note note:store.notes) {
            if (note.getTipoDoc().trim().equals("07")) {
                ncr.add(note);
            }
        }

        notes = ncr;
    }
}
