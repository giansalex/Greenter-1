package com.analycer.greenter.greenter.fragments.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analycer.greenter.greenter.R;
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
public class NotaDebitoFragment extends Fragment {

    private List<Note> notes;

    public NotaDebitoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_nota_debito, container, false);
        RecyclerView recycleNotaDebit = view.findViewById(R.id.recycleNotaDebit);
        recycleNotaDebit.setLayoutManager(new VegaLayoutManager());
        RecyclerViewNoteAdapter adapter = new RecyclerViewNoteAdapter(getActivity());
        recycleNotaDebit.setAdapter(adapter);

        if (loadDocs()) {
            adapter.setElement(notes);
        }

        return view;
    }

    public boolean loadDocs() {
        if (notes != null) {
            return true;
        }
        DataStore store = DataService
                .getInstance()
                .getStore();

        if (store.notes == null) {
            return false;
        }

        notes = new ArrayList<>();

        for (Note note: store.notes) {
            if (note.getTipoDoc().trim().equals("08")) {
                notes.add(note);
            }
        }

        return true;
    }

}
