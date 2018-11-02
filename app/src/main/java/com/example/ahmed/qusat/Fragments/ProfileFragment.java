package com.example.ahmed.qusat.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.qusat.R;
import com.example.ahmed.qusat.model.ProfileData;
import com.example.ahmed.qusat.presenter.ProfilePresenter;
import com.example.ahmed.qusat.view.ProfileView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ProfileView {
    TextView userName,userGender,userPhone,userRemaining;
    RelativeLayout statusColor;
    ProfilePresenter profilePresenter;

    public ProfileFragment() {
        // Required empty public constructor
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=inflater.inflate( R.layout.fragment_profile, container, false );
        userName=view.findViewById( R.id.profile_text_name );
        userGender=view.findViewById( R.id.profile_text_gender );
        userPhone=view.findViewById( R.id.profile_text_phone );
        userRemaining=view.findViewById( R.id.profile_text_remaining );
        statusColor=view.findViewById( R.id.profile_status_colors );
        profilePresenter=new ProfilePresenter( getContext(),this );
        profilePresenter.getProfileData( "IpUcxvZui3pwF1uZUkuBTy1tBKlZvywSW34CPn0DW1VtVffAk7fdsv1tFWjD","en" );
        return view;
    }
    @Override
    public void showProfileData(ProfileData profileData) {
        Toast.makeText( getContext(), "enter", Toast.LENGTH_LONG ).show();
        userName.setText( profileData.getName() );
        userGender.setText( profileData.getGander() );
        userPhone.setText( profileData.getPhone() );
        userRemaining.setText( profileData.getRemaining() );
        statusColor.setBackgroundResource( R.drawable.button );
        statusColor.setVisibility( View.VISIBLE );



    }
}
