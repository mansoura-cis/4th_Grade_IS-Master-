package com.example.fragments2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link imagefragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link imagefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class imagefragment extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imagefragment, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageView fl = (ImageView) getView().findViewById(R.id.imgview);
        ArrayList<Drawable> images = new ArrayList<Drawable>(4);
        images.add(this.getResources().getDrawable(R.drawable.d234566e9d));
        images.add(this.getResources().getDrawable(R.drawable.dot));
        images.add(this.getResources().getDrawable(R.drawable.app));
        images.add(this.getResources().getDrawable(R.drawable.cable));


        //(int)((Math.random() *4)) )
        Random rnd = new Random();
        Drawable drawable = images.get(rnd.nextInt(3));


        fl.setImageDrawable(drawable);



    }

    protected final static int getResourceID
            (final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }
    }
}
