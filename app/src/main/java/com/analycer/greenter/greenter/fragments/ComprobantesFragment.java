package com.analycer.greenter.greenter.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analycer.greenter.greenter.R;
import com.analycer.greenter.greenter.fragments.tabs.BoletasFragment;
import com.analycer.greenter.greenter.fragments.tabs.FacturasFragment;
import com.analycer.greenter.greenter.fragments.tabs.NotaCreditoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComprobantesFragment extends Fragment {


    private AppBarLayout mAppBarLayout;
    private TabLayout mTablayout;
    private ViewPager viewPager;
    private Adapter adapter;

    public ComprobantesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAppBarLayout.removeView(mTablayout);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comprobantes, container, false);
        if (savedInstanceState == null) {
            try {
                insertarTabs(container);
                // Setting ViewPager for each Tabs
                viewPager = (ViewPager) view.findViewById(R.id.viewpager);
                setupViewPager(viewPager);
                // Set Tabs inside Toolbar
                //mTablayout = (TabLayout) view.findViewById(R.id.result_tabs);
                mTablayout.setupWithViewPager(viewPager);
            }catch (Exception e){
                e.getMessage();
            }

        }

        return view;
    }

    private void insertarTabs(ViewGroup container) {
        View padre = (View) container.getParent();
        mAppBarLayout = (AppBarLayout) padre.findViewById(R.id.mAppBar);
        mTablayout = new TabLayout(getActivity());
        mTablayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        mAppBarLayout.addView(mTablayout);
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new FacturasFragment(), "Fact");
        adapter.addFragment(new BoletasFragment(), "Bolet");
        adapter.addFragment(new NotaCreditoFragment(), "NotCre");
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
    }

    /**adaptador de fragmentos*/
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
