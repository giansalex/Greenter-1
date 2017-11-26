package com.analycer.greenter.greenter.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analycer.greenter.greenter.R;
import com.analycer.greenter.greenter.swipe.TinderCard;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClientFutureFragment extends Fragment {
    private SwipePlaceHolderView mSwipView;

    public ClientFutureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_client_future, container, false);
        // Inflate the layout for this fragment
        mSwipView = view.findViewById(R.id.swipeView);

        mSwipView.getBuilder()
                //.setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_HORIZONTAL)
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        mSwipView.addView(new TinderCard(getActivity(), "https://us.123rf.com/450wm/sergeypykhonin/sergeypykhonin1502/sergeypykhonin150200072/36860227-le-n-abstracto-sobre-un-fondo-blanco-ilustraci-n-vectorial.jpg?ver=6"))
                .addView(new TinderCard(getActivity(),"http://logoscapacitacion.com/wp-content/uploads/2017/04/logo-logos.png"))
                .addView(new TinderCard(getActivity(),"http://3.bp.blogspot.com/-JzxsrlHMflA/UCfSJpR5ypI/AAAAAAAAAAM/89QsxxgD0i0/s1600/thumbnails.jpg"))
                .addView(new TinderCard(getActivity(),"https://us.123rf.com/450wm/mahabiru/mahabiru1602/mahabiru160200033/53142408-estrella-3d-resumen-plantilla-logotipo-de-identidad-de-la-empresa-estrella-3d-de-dise-o-de-logotipo-.jpg?ver=6"))
                .addView(new TinderCard(getActivity(),"http://oilworldcompanies.com/wp-content/uploads/2015/08/Pemex.gif"))
                .addView(new TinderCard(getActivity(),"http://www.e02.es/cubic/datos/docs/doc_366/imag_387_logotipo_diseno_corporativo_graphic_design_01_jupama.png"))
                .addView(new TinderCard(getActivity(),"http://4.bp.blogspot.com/_NUWAKV0rcLw/SkE-g4vt5zI/AAAAAAAAAEA/fSv-wuQxUpQ/s320/LOGO+RAPID+CARGO.jpg"))
                .addView(new TinderCard(getActivity(),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9zaFUpIt8t7JWc3FxXDcjEjgURwkUnXB_udq4dfuj_DI6Y8oHkQ"))
                .addView(new TinderCard(getActivity(),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoHyQ-1LrRYNswzQhN9BCMsd20WGaFebJ60bzUkXPj88FC5No6"));

        view.findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipView.doSwipe(false);
            }
        });

        view.findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipView.doSwipe(true);
            }
        });

        return view;
    }

}
