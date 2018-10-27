package com.example.ahmed.qusat.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmed.qusat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Details_Product extends Fragment {


    public Details_Product() {
        // Required empty public constructor
    }
    String a,y,e,c,s;
   View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_details__product, container, false);


        return view;
    }

}
