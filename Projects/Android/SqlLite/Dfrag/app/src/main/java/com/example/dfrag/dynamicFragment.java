package com.example.dfrag;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link dynamicFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link dynamicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dynamicFragment extends Fragment {


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dynamicFragment.
     */
    // TODO: Rename and change types and number of parameters



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }


}
