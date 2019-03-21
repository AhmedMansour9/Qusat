package com.example.ahmed.qusat.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ahmedd.qusat.R;
import com.example.ahmed.qusat.Model.Product_Details;
import com.example.ahmed.qusat.Model.Products;
import com.example.ahmed.qusat.View.DetailsProducts;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 31/10/2018.
 */

public class Products_Adapter extends RecyclerView.Adapter<Products_Adapter.MyViewHolder>{

    public static List<Products> filteredList=new ArrayList<>();
    View itemView;
    Context con;
    DetailsProducts detailsProducts;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Text_Spare,Text_Price,Text_Details;
        private Button Callnow,Details;
        private ImageView img_Spare;
        private ProgressBar ProgrossSpare;
        public MyViewHolder(View view) {
            super(view);
            img_Spare=view.findViewById(R.id.img_Spare);
            Text_Spare=view.findViewById(R.id.Text_Spare);
            Text_Price=view.findViewById(R.id.Text_Price);
            ProgrossSpare=view.findViewById(R.id.ProgrossSpare);
        }

    }

    public Products_Adapter(List<Products> list, Context context){
        this.filteredList=list;
        this.con=context;
    }
    public Products_Adapter(Context context){
        this.con=context;
    }
    public void setOnClicklistner(DetailsProducts detailsProducts){
        this.detailsProducts=detailsProducts;
    }

    @Override
    public Products_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemsparts, parent, false);
        return new Products_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Products_Adapter.MyViewHolder holder, final int position) {
        holder.Text_Spare.setText(filteredList.get(position).getProductName());
        holder.Text_Price.setText(String.valueOf(filteredList.get(position).getPrice()));

        String i = filteredList.get(position).getImage();
        Uri u = Uri.parse(i);
        holder.ProgrossSpare.setVisibility(View.VISIBLE);
        Picasso.with(con)
                .load("http://qussat.com/"+u)
                .resize(500,500)
                .into(holder.img_Spare, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.ProgrossSpare.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.ProgrossSpare.setVisibility(View.GONE);
                    }
                });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product_Details details=new Product_Details();
                details.setAddressVendor(filteredList.get(position).getAddressVendor());
                details.setProductId(filteredList.get(position).getProductID());
                details.setProductName(filteredList.get(position).getProductName());
                details.setPrice(filteredList.get(position).getPrice());
                details.setModelProduct(filteredList.get(position).getModelProduct());
                details.setCategoryName(filteredList.get(position).getCategoryName());
                details.setBrandName(filteredList.get(position).getBrandName());
                details.setPhoneVendor(filteredList.get(position).getPhoneVendor());
                details.setProductImage(filteredList.get(position).getImage());
                details.setVendorName(filteredList.get(position).getNameVendor());
                detailsProducts.ProductsDetails(details);
            }
        });


    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
