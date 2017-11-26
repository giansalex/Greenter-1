package com.analycer.greenter.greenter.adapter;


import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.analycer.greenter.greenter.R;
import com.bumptech.glide.Glide;
import com.etsy.android.grid.util.DynamicHeightTextView;

/***
 * ADAPTER
 */

public class GridItemAdapter extends ArrayAdapter<String> {

    private static final String TAG = "SampleAdapter";


    static class ViewHolder {
        TextView txtLineOne;
        ImageView imageView;
        Button btnGo;
    }

    private final LayoutInflater mLayoutInflater;
    private final Random mRandom;
    private final ArrayList<Integer> mBackgroundColors;

    private RelativeLayout layout;
    private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();

    public GridItemAdapter(final Context context, final int textViewResourceId) {
        super(context, textViewResourceId);
        mLayoutInflater = LayoutInflater.from(context);
        mRandom = new Random();
        mBackgroundColors = new ArrayList<Integer>();
        mBackgroundColors.add(R.color.orange);
        mBackgroundColors.add(R.color.green_light);
        mBackgroundColors.add(R.color.blue);
        mBackgroundColors.add(R.color.yellow);
        mBackgroundColors.add(R.color.grey);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_grid_item, parent, false);
            vh = new ViewHolder();

            vh.txtLineOne = convertView.findViewById(R.id.txt_line1);
            vh.imageView = convertView.findViewById(R.id.imgGrid);
            CardView card = convertView.findViewById(R.id.card_grid);
            layout = convertView.findViewById(R.id.panel_content);

            Double rand = getRandomHeightRatio();

            Glide.with(convertView)
                .load(rand < 1.25 ? "https://i.pinimg.com/736x/4d/20/3f/4d203f17d5d6e35919b7c7c866ad9dd5--converse-fashion-vans-old-skool.jpg":
                        "https://www.plns.es/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/5/7/5716043504-b-0522.jpg")
                .into(vh.imageView);
            //vh.btnGo = (Button) convertView.findViewById(R.id.btn_go);

            convertView.setTag(vh);
        }
        else {
            vh = (ViewHolder) convertView.getTag();
        }

        double positionHeight = getPositionRatio(position);
        int backgroundIndex = position >= mBackgroundColors.size() ?
                position % mBackgroundColors.size() : position;

        //convertView.setBackgroundResource(mBackgroundColors.get(backgroundIndex));

        Log.d(TAG, "getView position:" + position + " h:" + positionHeight);

        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = 300;
        layout.setLayoutParams(params);
        //vh.txtLineOne.setHeight((int)(positionHeight * 40));
        //vh.txtLineOne.setHeightRatio(positionHeight);
        vh.txtLineOne.setText(getItem(position) + position);

/*        vh.btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(getContext(), "Button Clicked Position " +
                        position, Toast.LENGTH_SHORT).show();
            }
        });*/

        return convertView;
    }

    private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        // if not yet done generate and stash the columns height
        // in our real world scenario this will be determined by
        // some match based on the known height and width of the image
        // and maybe a helpful way to get the column height!
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);
            Log.d(TAG, "getPositionRatio:" + position + " ratio:" + ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5 the width
    }
}