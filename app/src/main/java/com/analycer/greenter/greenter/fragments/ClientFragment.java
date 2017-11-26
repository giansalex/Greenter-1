package com.analycer.greenter.greenter.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analycer.greenter.greenter.ClientsMapsActivity;
import com.analycer.greenter.greenter.DetailClientActivity;
import com.analycer.greenter.greenter.R;
import com.analycer.greenter.greenter.adapter.AdapterListUsers;
import com.analycer.greenter.greenter.adapter.OnItemClickListClient;
import com.greenter.core.model.Client;
import com.greenter.core.model.Company;
import com.greenter.core.model.DataStore;
import com.greenter.core.model.Invoice;
import com.greenter.core.service.ClientService;
import com.stone.vega.library.VegaLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ClientFragment extends Fragment implements OnItemClickListClient {
    //Button mMaps;
    private FloatingActionButton mFabMaps;
    private RecyclerView mListClients;
    private AdapterListUsers mAdapterListUsers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_client, container, false);

       // mMaps = (Button) view.findViewById(R.id.btnMaps);
        mFabMaps = view.findViewById(R.id.fabMaps);
        mListClients = view.findViewById(R.id.listClients);
        mListClients.setLayoutManager(new VegaLayoutManager());
        mAdapterListUsers = new AdapterListUsers(getActivity());
        mListClients.setAdapter(mAdapterListUsers);


            final Company modelSms1 = new Company();
            final Company modelSms2 = new Company();
            final Company modelSms3 = new Company();
            final Company modelSms4 = new Company();
            modelSms1.setRuc("748512452");
            modelSms1.setNombreComercial("asadasdasda");
            modelSms2.setRuc("946131543");
            modelSms2.setNombreComercial("Sdfsdfssdfbdsfb");
            modelSms3.setRuc("748512452");
            modelSms3.setNombreComercial("asadasdasda");
            modelSms4.setRuc("946131543");
            modelSms4.setNombreComercial("Sdfsdfssdfbdsfb");
            List<Company> smses = new ArrayList<>();
            smses.add(modelSms1);
            smses.add(modelSms2);
            smses.add(modelSms3);
            smses.add(modelSms4);

        ClientService mClientService = new ClientService();

            mAdapterListUsers.setElement(mClientService.getAll());
            mAdapterListUsers.setOnItemClickListener(this);

       /* mMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getActivity(), ClientsMapsActivity.class);
                startActivity(intent);*/
               /* Intent intent = new Intent(getActivity(), DetailClientActivity.class);
                startActivity(intent);
            }
        });*/

        mFabMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ClientsMapsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onItemClick(Client element) {
        Intent intent = new Intent(getActivity(), DetailClientActivity.class);
        startActivity(intent);
    }
}
