package com.analycer.greenter.greenter.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.analycer.greenter.greenter.ClientsMapsActivity;
import com.analycer.greenter.greenter.DetailClientActivity;
import com.analycer.greenter.greenter.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ClientFragment extends Fragment {
    Button mMaps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_client, container, false);

        mMaps = (Button) view.findViewById(R.id.btnMaps);

        mMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getActivity(), ClientsMapsActivity.class);
                startActivity(intent);*/
                Intent intent = new Intent(getActivity(), DetailClientActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
