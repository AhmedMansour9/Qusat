package com.example.ahmed.qusat.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.qusat.Activites.Second_Activity;
import com.example.ahmed.qusat.NetworikConntection;
import com.example.ahmed.qusat.Presenter.LoginPresenter;
import com.example.ahmed.qusat.R;
import com.example.ahmed.qusat.View.LoginView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment implements LoginView {


    public Login() {
        // Required empty public constructor
    }
    EditText userEmail,userPassword;
    Button userSigin;
    TextView createAccount;
    LoginPresenter loginPresenter;
    private ProgressBar progressBar;
    SharedPreferences.Editor shared;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_login, container, false);

        userEmail=view.findViewById( R.id.E_Email );
        userPassword=view.findViewById( R.id.E_Password );
        userSigin=view.findViewById( R.id.btn_signin );
        createAccount=view.findViewById( R.id.text_create_account );
        progressBar=view.findViewById( R.id.log_progressbar );
        shared=this.getActivity().getSharedPreferences( "login", Context.MODE_PRIVATE ).edit();

        loginPresenter = new LoginPresenter(getContext(),this);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.flContent,new Register()).commitAllowingStateLoss();
            }
        });
        userSigin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        } );



        return view;
    }
    private void Login()
    { NetworikConntection checkgbsAndNetwork=new NetworikConntection(getContext());
        if (checkgbsAndNetwork.isNetworkAvailable(getContext()))
        {
            progressBar.setVisibility( View.VISIBLE );
            loginPresenter.Login( userEmail.getText().toString().trim(), userPassword.getText().toString().trim() );

        }else
        {
            Toast.makeText( getContext(), R.string.checkinternetconnection, Toast.LENGTH_SHORT ).show();
        }
    }

    @Override
    public void OpenMain(String token) {
        shared.putString( "logggin",token );
        shared.apply();
        startActivity(new Intent(getActivity(), Second_Activity.class));
        getActivity().finish();
        progressBar.setVisibility( View.GONE );

    }

    @Override
    public void WaitingEmail() {
        Toast.makeText( getContext(), R.string.waitingemailconfirm, Toast.LENGTH_SHORT ).show();
        progressBar.setVisibility( View.GONE );
    }

    @Override
    public void ErrorMessage() {
        Toast.makeText( getContext(), R.string.failedtologin, Toast.LENGTH_SHORT ).show();
        progressBar.setVisibility( View.GONE );

    }
}
