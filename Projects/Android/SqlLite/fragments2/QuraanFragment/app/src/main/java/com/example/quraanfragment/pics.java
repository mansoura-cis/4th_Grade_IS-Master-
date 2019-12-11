package com.example.quraanfragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


public class pics extends Fragment {

    public static int Counter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pics, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ArrayList<Drawable> images = new ArrayList<>();
        images.add(this.getResources().getDrawable(R.drawable.ima1));
        images.add(this.getResources().getDrawable(R.drawable.ima2));
        images.add(this.getResources().getDrawable(R.drawable.ima3));
        images.add(this.getResources().getDrawable(R.drawable.ima4));
        images.add(this.getResources().getDrawable(R.drawable.ima5));
        images.add(this.getResources().getDrawable(R.drawable.ima6));
        images.add(this.getResources().getDrawable(R.drawable.ima7));
        images.add(this.getResources().getDrawable(R.drawable.ima8));
        images.add(this.getResources().getDrawable(R.drawable.ima9));
        images.add(this.getResources().getDrawable(R.drawable.ima10));
        images.add(this.getResources().getDrawable(R.drawable.ima11));
        images.add(this.getResources().getDrawable(R.drawable.ima12));
        images.add(this.getResources().getDrawable(R.drawable.ima13));
        images.add(this.getResources().getDrawable(R.drawable.ima14));
        images.add(this.getResources().getDrawable(R.drawable.ima15));
        images.add(this.getResources().getDrawable(R.drawable.ima16));
        ImageView fl =  getView().findViewById(R.id.imgview);
        Drawable drawable = images.get(Counter);
        fl.setImageDrawable(drawable);

    }


}
