package com.example.ahmed.qusat.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ahmedd.qusat.R;
import com.example.ahmed.qusat.Activites.Second_Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Guest_Fragment extends Fragment {


    public Guest_Fragment() {
        // Required empty public constructor
    }
    Button btn_Guest,Login;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.guest_main_, container, false);
        btn_Guest=view.findViewById(R.id.btn_gust);
        Login=view.findViewById(R.id.btn_login);
        btn_Guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Second_Activity.class));
                getActivity().finish();
            }
        });
       Login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getFragmentManager().beginTransaction().replace(R.id.flContent,new Login()).commitAllowingStateLoss();
           }
       });

        return view;
    }

}
