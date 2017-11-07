package com.analycer.greenter.greenter.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.analycer.greenter.greenter.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResumFragment extends Fragment {


    public ResumFragment() {
        // Required empty public constructor
    }

    private  View view;
    private ImageView mImgUpVentas;
    private ImageView mImgDownVentas;
    private TextView mPorcentVentas;
    private TextView mTitleVentas;
    private LineChart mChartVentas;
    private ArrayList<Entry> values;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_resum, container, false);
        findViewById();

       /* mChartVentas.setOnChartGestureListener(this);
        mChartVentas.setOnChartValueSelectedListener(this);*/
        mChartVentas.setDrawGridBackground(false);

        // no description text
        mChartVentas.getDescription().setEnabled(false);

        // enable touch gestures
        mChartVentas.setTouchEnabled(true);

        // enable scaling and dragging
        mChartVentas.setDragEnabled(true);
        mChartVentas.setScaleEnabled(true);
        // mChart.setScaleXEnabled(true);
        // mChart.setScaleYEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChartVentas.setPinchZoom(false);

        seetData(6, 1400);


        final String[] quarters = new String[] { "JUL.", "AGO.", "SEPT.", "OCT.","NOV","DIC" };

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };


        XAxis xAxis = mChartVentas.getXAxis();
        xAxis.removeAllLimitLines();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
        //xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setGridColor(Color.WHITE);
        xAxis.setAxisLineColor(Color.WHITE);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis leftAxis = mChartVentas.getAxisLeft();
        leftAxis.removeAllLimitLines();
        //leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);

        mChartVentas.getAxisRight().setEnabled(false);
        //mChartVentas.getAxisLeft().setGridColor(Color.WHITE);

        LineDataSet dataSet = new LineDataSet(values, "Ventas"); // add entries to dataset
        dataSet.setColor(ContextCompat.getColor(getActivity(), R.color.colorLineX));
        dataSet.setDrawValues(false);
        dataSet.setLineWidth(2.3f);
        dataSet.setCircleColors(ContextCompat.getColor(getActivity(), R.color.colorLineX));
        dataSet.setCircleSize(4.6f);
        //dataSet.setValueTextColor(ContextCompat.getColor(getActivity(), R.color.colordownicon));

        LineData lineData = new LineData(dataSet);
        mChartVentas.setData(lineData);
        mChartVentas.invalidate(); //

        
        return view;
    }

    void seetData(int count, int range){
        values = new ArrayList<Entry>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 3;
            values.add(new Entry(i, val));
        }
    }


    private void findViewById(){
        mImgUpVentas = view.findViewById(R.id.imgUpVentas);
        mImgDownVentas = view.findViewById(R.id.imgDownVentas);
        mPorcentVentas = view.findViewById(R.id.txtPorcentVentas);
        mTitleVentas = view.findViewById(R.id.txtVentas);
        mChartVentas = view.findViewById(R.id.lineChartVentas);
        DrawableCompat.setTint(mImgDownVentas.getDrawable(), ContextCompat.getColor(getActivity(), R.color.colorLine));
        mPorcentVentas.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorupicon));
        mTitleVentas.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorfount));
    }



}
