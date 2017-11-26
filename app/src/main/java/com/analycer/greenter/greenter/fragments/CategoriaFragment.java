package com.analycer.greenter.greenter.fragments;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analycer.greenter.greenter.R;
import com.analycer.greenter.greenter.cardpager.CardFragmentPagerAdapter;
import com.analycer.greenter.greenter.cardpager.CardItem;
import com.analycer.greenter.greenter.cardpager.CardPagerAdapter;
import com.analycer.greenter.greenter.cardpager.ShadowTransformer;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.greenter.core.callback.ApiDataRequest;
import com.greenter.core.model.Invoice;
import com.greenter.core.service.SaleService;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaFragment extends Fragment implements ApiDataRequest<List<Invoice>>,OnChartValueSelectedListener {

    private SaleService mServices;
    private PieChart mPieChar;
    private ViewPager mViewPager;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    private boolean mShowingFragments = false;

    protected String[] mParties = new String[] {
            "CAT A", "CAT B", "CAT C", "CAT D", "CAT E", "CAT F", "CAT G", "CAT H",
            "CAT I", "CAT J", "CAT K", "CAT L", "CAT M", "CAT N", "CAT O", "CAT P",
            "CAT Q", "CAT R", "CAT S", "CAT T", "CAT U", "CAT V", "CAT W", "CAT X",
            "CAT Y", "CAT Z"
    };


    public CategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);


        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);


        mCardAdapter = new CardPagerAdapter();
        Context activaty = getActivity();
        mCardAdapter.addCardItem(new CardItem("CAT A", "Materia prima", "https://http2.mlstatic.com/D_Q_NP_602715-MPE25280543856_012017-Q.jpg"), activaty);
        mCardAdapter.addCardItem(new CardItem("CAT B", "Telas", "https://http2.mlstatic.com/tapete-passadeira-bodas-igreja-casamento-festa-5mx1-D_NQ_NP_823311-MLB20525372323_122015-F.jpg"),activaty);
        mCardAdapter.addCardItem(new CardItem("CAT C",  "Calzados de noche", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRw2GGRCARfyKkMpwXmedwa0XHQCZgLPUCjHbsbGmH_tXTxk8u2"), activaty);
        mCardAdapter.addCardItem(new CardItem("CAT D", "Ropa de primarvera", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwB0Knlx_cQvWsyKoqMu3tXbBNLExqWiziO3egEEwGi5aRSyZ3"), activaty);
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager(),
                dpToPixels(2, getActivity()));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);


        mServices = new SaleService(this);

        mPieChar = (PieChart) view.findViewById(R.id.chartCategoria);
        mPieChar.setUsePercentValues(true);
        mPieChar.getDescription().setEnabled(false);
        mPieChar.setExtraOffsets(5, 10, 5, 5);

        mPieChar.setDragDecelerationFrictionCoef(0.95f);

        //mPieChar.setCenterTextTypeface(mTfLight);
        mPieChar.setCenterText(generateCenterSpannableText());

        mPieChar.setDrawHoleEnabled(true);
        mPieChar.setHoleColor(Color.WHITE);

        mPieChar.setTransparentCircleColor(Color.WHITE);
        mPieChar.setTransparentCircleAlpha(110);

        mPieChar.setHoleRadius(58f);
        mPieChar.setTransparentCircleRadius(61f);

        mPieChar.setDrawCenterText(true);

        mPieChar.setRotationAngle(0);
        // enable rotation of the chart by touch
        mPieChar.setRotationEnabled(true);
        mPieChar.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        mPieChar.setOnChartValueSelectedListener(this);

        setData(4, 100);

        mPieChar.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mPieChar.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mPieChar.setEntryLabelColor(Color.WHITE);
        //mPieChar.setEntryLabelTypeface(mTfRegular);
        mPieChar.setEntryLabelTextSize(12f);


        return view;
    }

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("Categoria\nde productos");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 9, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 9, s.length() - 10, 0);
        //s.setSpan(new ForegroundColorSpan(Color.GRAY), 10, s.length() - 11, 0);
        //s.setSpan(new RelativeSizeSpan(.8f), 10, s.length() - 11, 0);
        //s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 10, s.length(), 0);
        //s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 10, s.length(), 0);
        return s;
    }


    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count ; i++) {
            entries.add(new PieEntry((float) ((Math.random() * mult) + mult / 5),
                    mParties[i % mParties.length]));   // se puede enviar un parame más getResources().getDrawable(R.drawable.star)
        }


        PieDataSet dataSet = new PieDataSet(entries, "Resultados");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        //data.setValueTypeface(mTfLight);
        mPieChar.setData(data);

        // undo all highlights
        mPieChar.highlightValues(null);

        mPieChar.invalidate();
    }


    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void setApiResponse(List<Invoice> invoiceList) {
        List<Invoice> minv = invoiceList;
    }



    @Override
    public void onValueSelected(Entry e, Highlight h) {
        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getY() + ", index: " + h.getX()
                        + ", DataSet index: " + h.getDataSetIndex());
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }
}
