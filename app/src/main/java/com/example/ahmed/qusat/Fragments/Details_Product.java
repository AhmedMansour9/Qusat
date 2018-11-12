package com.example.ahmed.qusat.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ahmedd.qusat.R;
import com.example.ahmed.qusat.Activites.Spinner_Loan;
import com.example.ahmed.qusat.Adapter.Banners_Adapter;
import com.example.ahmed.qusat.Adapter.Leon_Adapter;
import com.example.ahmed.qusat.Language;
import com.example.ahmed.qusat.Model.Leons;
import com.example.ahmed.qusat.NetworikConntection;
import com.example.ahmed.qusat.Presenter.Banners_Presenter;
import com.example.ahmed.qusat.Presenter.Leons_Presenter;
import com.example.ahmed.qusat.View.Leons_View;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Details_Product extends Fragment implements Leons_View,SwipeRefreshLayout.OnRefreshListener{


    public Details_Product() {
        // Required empty public constructor
    }
   View view;
    String Address,Id,ProductName,Price,Model,CategoryName,BrandName,PhoneVendor,image,VendorName;
    TextView T_Address,T_ProductName,T_Price,T_Model,T_CategoryName,T_BrandName,T_PhoneVendor,loan,T_VendorName;
    ImageView ImagProduct;
    Leons_Presenter Leons_presenter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    NetworikConntection networikConntection;
    RelativeLayout rela;
    Leon_Adapter leon_adapter;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_details__product, container, false);
        Leons_presenter=new Leons_Presenter(getActivity(),this);
        networikConntection=new NetworikConntection(getActivity());
        rela=view.findViewById(R.id.rela);
        recyclerView=view.findViewById(R.id.recycler_Leon);
        init();
        getData();
       SwipRefresh();
       OpenLoan();


        return view;
    }
  public void getData(){
        Bundle a=getArguments();
        if(a!=null){
            Address=a.getString("address");
            Id=a.getString("id");
            ProductName=a.getString("productname");
            Price=a.getString("price");
            Model=a.getString("model");
            CategoryName=a.getString("categoryname");
            BrandName=a.getString("brandname");
            PhoneVendor=a.getString("phonevendor");
            image=a.getString("image");
            VendorName=a.getString("vendorname");
            T_Address.setText(Address);
            T_ProductName.setText(ProductName);
            T_Price.setText(Price+" LE");
            T_VendorName.setText(VendorName);
            T_Model.setText(Model);
            T_CategoryName.setText(CategoryName);
            T_BrandName.setText(BrandName);
            T_PhoneVendor.setText(PhoneVendor);
            Picasso.with(getActivity())
                    .load("http://qussat.com/"+image)
                    .into(ImagProduct, new Callback() {
                        @Override
                        public void onSuccess() {
                        }

                        @Override
                        public void onError() {
                        }
                    });
        }
  }

  public  void OpenLoan(){
      loan.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent inty=new Intent(getActivity(), Spinner_Loan.class);
              inty.putExtra("productid",Id);
              inty.putExtra("name",ProductName);
              inty.putExtra("price",Price);
              inty.putExtra("image",image);
              startActivity(inty);
          }
      });

  }
    public void SwipRefresh(){
        mSwipeRefreshLayout =  view.findViewById(R.id.swipe_Leons);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                if(networikConntection.isNetworkAvailable(getContext())) {
                    if (Language.isRTL()) {
                        mSwipeRefreshLayout.setRefreshing(true);
                            Leons_presenter.GetLeons("ar",Id);
                        }else {
                        mSwipeRefreshLayout.setRefreshing(true);
                            Leons_presenter.GetLeons("en",Id);
                        }

                }else {
                    Snackbar.make(rela,getResources().getString(R.string.internet),1500).show();
                }
            }


        });
    }
  public void init(){
     T_Address=view.findViewById(R.id.T_VendorAddress);
      T_ProductName=view.findViewById(R.id.T_Name);
      T_Price=view.findViewById(R.id.T_Price);
      T_Model=view.findViewById(R.id.T_model);
      T_CategoryName=view.findViewById(R.id.T_Category);
      T_BrandName=view.findViewById(R.id.T_Brand);
      T_Address=view.findViewById(R.id.T_VendorAddress);
      T_PhoneVendor=view.findViewById(R.id.T_VendorPhone);
      ImagProduct=view.findViewById(R.id.Image_product);
      loan=view.findViewById(R.id.loan);
      T_VendorName=view.findViewById(R.id.T_VendorName);
  }

    @Override
    public void Leons(List<Leons> list) {
        leon_adapter= new Leon_Adapter(list,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(leon_adapter);
        mSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void Error() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        if(networikConntection.isNetworkAvailable(getContext())) {
            if (Language.isRTL()) {
                mSwipeRefreshLayout.setRefreshing(true);
                if(Language.isRTL()){
                    Leons_presenter.GetLeons("ar",Id);
                }else {
                    Leons_presenter.GetLeons("en",Id);
                }
            }
        }else {
            Snackbar.make(rela,getResources().getString(R.string.internet),1500).show();
        }
    }
}
