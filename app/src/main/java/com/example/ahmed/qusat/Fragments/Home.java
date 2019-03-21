package com.example.ahmed.qusat.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ahmedd.qusat.R;
import com.example.ahmed.qusat.Adapter.Banners_Adapter;
import com.example.ahmed.qusat.Adapter.Categories_Adapter;
import com.example.ahmed.qusat.Adapter.Products_Adapter;
import com.example.ahmed.qusat.Language;
import com.example.ahmed.qusat.Model.Banners;
import com.example.ahmed.qusat.Model.Categories;
import com.example.ahmed.qusat.Model.Product_Details;
import com.example.ahmed.qusat.Model.Products;
import com.example.ahmed.qusat.NetworikConntection;
import com.example.ahmed.qusat.Presenter.Banners_Presenter;
import com.example.ahmed.qusat.Presenter.Categories_Presenter;
import com.example.ahmed.qusat.Presenter.Products_Presenter;
import com.example.ahmed.qusat.View.Banners_View;
import com.example.ahmed.qusat.View.Categories_View;
import com.example.ahmed.qusat.View.DetailsProducts;
import com.example.ahmed.qusat.View.Product_id;
import com.example.ahmed.qusat.View.Products_View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements DetailsProducts,Categories_View
        ,SwipeRefreshLayout.OnRefreshListener,Banners_View,Products_View,Product_id{


    public Home() {
        // Required empty public constructor
    }
   Products_Presenter products_presenter;
    Categories_Presenter categories;
    RecyclerView recyclerView,recycleBanner,recycleProducts;
    SwipeRefreshLayout mSwipeRefreshLayout;
    View view;
    Categories_Adapter categories_adapter;
    Banners_Adapter banners_adapter;
    NetworikConntection networikConntection;
    RelativeLayout rela;
    Banners_Presenter banners_presenter;
    Products_Adapter products_adapter;
    TextView profile,feature;
    SharedPreferences sha;
    String logi;
    TextView textProfile;
    Boolean statues=false;
    List<Banners> banne=new ArrayList<>();
    Boolean end;
    int position;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment3
        view= inflater.inflate(R.layout.fragment_home, container, false);
        setRetainInstance(true);
        String greeting = (savedInstanceState != null) ? savedInstanceState.getString("greeting") : "null";
        categories=new Categories_Presenter(getContext(),this);
        networikConntection=new NetworikConntection(getActivity());
        products_presenter=new Products_Presenter(getContext(),this);
        banners_presenter=new Banners_Presenter(getContext(),this);
        sha=getActivity().getSharedPreferences("login",MODE_PRIVATE);
        products_adapter = new Products_Adapter(getContext());
        textProfile=view.findViewById(R.id.profile);
        logi=sha.getString("logggin",null);
        if(logi==null){
            textProfile.setVisibility(View.GONE);
        }

        init();
        Recyclview();
        SwipRefresh();
        OpenProfile();


        return view;
    }
    public void init(){
        rela=view.findViewById(R.id.rela);
        profile=view.findViewById(R.id.profile);
        feature=view.findViewById(R.id.feature);
    }
    public void OpenProfile(){
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .add(R.id.flContenttwo,new ProfileFragmen()).addToBackStack(null).commit();

            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("greeting", "Hello");
    }
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        String greeting = (savedInstanceState != null) ? savedInstanceState.getString("greeting") : "null";
    }
    @Override
    public void Categories(List<Categories> list) {
        categories_adapter = new Categories_Adapter(list,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        categories_adapter.setOnClicklistner(this);
        recyclerView.setAdapter(categories_adapter);
        mSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void ErrorCategories() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void Recyclview(){
        recyclerView = view.findViewById(R.id.recycler_Categroies);
        recycleBanner=view.findViewById(R.id.recycler_banners);
        recycleProducts=view.findViewById(R.id.recycler_Products);
        recyclerView.setHasFixedSize(true);
    }

    public void SwipRefresh(){
        mSwipeRefreshLayout =  view.findViewById(R.id.swipe_Categories);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setEnabled(true);
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
                        categories.GetCategories("ar");
                        banners_presenter.GetBanners("ar");
                        products_presenter.GetFeatureProduct("ar");
                    } else {
                        mSwipeRefreshLayout.setRefreshing(true);
                        categories.GetCategories("en");
                        banners_presenter.GetBanners("en");
                        products_presenter.GetFeatureProduct("en");
                    }
                }else {
                    Snackbar.make(rela,getResources().getString(R.string.internet),1500).show();
                }
            }


        });
    }

    @Override
    public void banners(List<Banners> list) {
        banners_adapter = new Banners_Adapter(list,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleBanner.setLayoutManager(linearLayoutManager);

        recycleBanner.setItemAnimator(new DefaultItemAnimator());
        recycleBanner.setLayoutManager(linearLayoutManager);
        recycleBanner.setAdapter(banners_adapter);
        mSwipeRefreshLayout.setRefreshing(false);
        banne=list;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new AutoScrollTask(), 1000, 2000);

    }

    @Override
    public void ErrorPanner() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void Products(List<Products> list) {
            products_adapter = new Products_Adapter(list, getContext());
            products_adapter.setOnClicklistner(this);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
            recycleProducts.setLayoutManager(gridLayoutManager);
            recycleProducts.setAdapter(products_adapter);
            mSwipeRefreshLayout.setRefreshing(false);
            if(statues) {
                feature.setText(list.get(0).getCategoryName());
            }
    }

    @Override
    public void ErrorProducts() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
    if(networikConntection.isNetworkAvailable(getContext())) {
        if (Language.isRTL()) {
            mSwipeRefreshLayout.setRefreshing(true);
            categories.GetCategories("ar");
            banners_presenter.GetBanners("ar");
        } else {
            mSwipeRefreshLayout.setRefreshing(true);
            categories.GetCategories("en");
            banners_presenter.GetBanners("en");
        }
    }else {
        Snackbar.make(rela,getResources().getString(R.string.internet),1500).show();
    }
}

    @Override
    public void id(String id) {
        if(networikConntection.isNetworkAvailable(getContext())) {
            statues=true;
            if(!Products_Adapter.filteredList.isEmpty()){
                Products_Adapter.filteredList.clear();
                products_adapter.notifyDataSetChanged();
            }

            if (Language.isRTL()) {
                mSwipeRefreshLayout.setRefreshing(true);
                products_presenter.Getbanners("ar",id);
            } else {
                mSwipeRefreshLayout.setRefreshing(true);
                products_presenter.Getbanners("en",id);
            }
        }else {
            Snackbar.make(rela,getResources().getString(R.string.internet),1500).show();
        }
    }

    @Override
    public void ProductsDetails(Product_Details list) {

        Details_Product details_product=new Details_Product();
        Bundle args = new Bundle();
        args.putString("address",list.getAddressVendor());
        args.putString("image",list.getProductImage());
        args.putString("id",list.getProductId());
        args.putString("productname",list.getProductName());
        args.putString("price",list.getPrice());
        args.putString("model",list.getModelProduct());
        args.putString("categoryname",list.getCategoryName());
        args.putString("brandname",list.getBrandName());
        args.putString("phonevendor",list.getPhoneVendor());
        args.putString("vendorname",list.getVendorName());
        details_product.setArguments(args);
        getFragmentManager().beginTransaction()
                .add(R.id.flContenttwo, details_product )
                .addToBackStack(null)
                .commit();
    }

    private class AutoScrollTask extends TimerTask {
        @Override
        public void run() {
            if(position == banne.size() -1){
                end = true;
            } else if (position == 0) {
                end = false;
            }
            if(!end){
                position++;
            } else {
                position--;
            }
            recycleBanner.smoothScrollToPosition(position);
        }
    }
}
