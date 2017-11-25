package com.analycer.greenter.greenter;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.analycer.greenter.greenter.adapter.GridItemAdapter;
import com.analycer.greenter.greenter.adapter.SampleData;
import com.bumptech.glide.Glide;
import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;


public class DetailClientActivity extends AppCompatActivity {

    private StaggeredGridView mGridView;
    ImageView imageView,imageView1;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_client);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowHomeEnabled(true);
        }

        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);

        LayoutInflater layoutInflater = getLayoutInflater();

        View header = layoutInflater.inflate(R.layout.list_item_header_footer, null);
        //View footer = layoutInflater.inflate(R.layout.list_item_header_footer, null);
        //TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
        //TextView txtFooterTitle =  (TextView) footer.findViewById(R.id.txt_title);
        //txtHeaderTitle.setText("THE HEADER!");
        //txtFooterTitle.setText("THE FOOTER!");

        mGridView.addHeaderView(header);
        //mGridView.addFooterView(footer);
        GridItemAdapter mAdapter = new GridItemAdapter(this, R.id.txt_line1);

        if (mData == null) {
            mData = SampleData.generateSampleData();
        }

        for (String data : mData) {
            mAdapter.add(data);
        }

        mGridView.setAdapter(mAdapter);

//        imageView = findViewById(R.id.product);
//        imageView1 = findViewById(R.id.product1);


//        Glide.with(this)
//                .load("https://i.pinimg.com/736x/4d/20/3f/4d203f17d5d6e35919b7c7c866ad9dd5--converse-fashion-vans-old-skool.jpg")
//                .into(imageView);
//
//        Glide.with(this)
//                .load("https://www.plns.es/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/5/7/5716043504-b-0522.jpg")
//                .into(imageView1);

        /*toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(Color.WHITE));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back_arrow));
            toolbar.setNavigationOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
