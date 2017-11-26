package com.analycer.greenter.greenter.swipe;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.analycer.greenter.greenter.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

@Layout(R.layout.tinder_card_view)
public class TinderCard {
    private static int count;

    Context mContext;
    private String url;

    public TinderCard( Context mContext, String url){
        this.mContext = mContext;

        this.url = url;
    }

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    @View(R.id.imgMaps)
    private ImageView mImgMaps;

/*    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt; */

    @Click(R.id.profileImageView)
    private void onClick(){
        Log.d("DEBUG", "profileImageView");
    }

    @Resolve
    private void onResolve(){
       // nameAgeTxt.setText("Name " + count++);
        Glide.with(mContext) //  https://www.plns.es/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/5/7/5716043504-b-0522.jpg
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(profileImageView);

        Glide.with(mContext) //
                .load("https://lh5.googleusercontent.com/d8daNCHt4re6QJQFoZHhU0FZkNzqXWShxL5OmnCxLB6LPsVHDPMsIHLHLP2h1JqjJDrhEhDXtbrM-w=w1366-h672-rw")
                .into(mImgMaps);
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("DEBUG", "onSwipedOut");
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("DEBUG", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("DEBUG", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("DEBUG", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("DEBUG", "onSwipeOutState");
    }
}
