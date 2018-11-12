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
import com.example.ahmed.qusat.Model.Categories;
import com.example.ahmed.qusat.View.Product_id;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ahmed on 30/10/2018.
 */

public class Categories_Adapter extends RecyclerView.Adapter<Categories_Adapter.MyViewHolder>{

    private List<Categories> filteredList=new ArrayList<>();
    View itemView;
    Context con;
    Product_id product_id;
    private int postionn=0;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Text_Name;
        private Button Callnow,Details;
        private CircleImageView img_Category;
        private ProgressBar ProgrossSpare;
        public MyViewHolder(View view) {
            super(view);
            img_Category=view.findViewById(R.id.image_Category);
            Text_Name=view.findViewById(R.id.T_Name);
            ProgrossSpare=view.findViewById(R.id.Progrossbarcategory);
        }

    }

    public Categories_Adapter(List<Categories> list, Context context){
        this.filteredList=list;
        this.con=context;
    }
    public Categories_Adapter(Context context){

        this.con=context;
    }
    public void setOnClicklistner(Product_id product_id){
        this.product_id=product_id;
    }

    @Override
    public Categories_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcategory, parent, false);
        return new Categories_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Categories_Adapter.MyViewHolder holder, final int position) {
      if(position==postionn) {
          holder.itemView.performClick();
          holder.itemView.setSelected(true);
          holder.itemView.setClickable(true);
      }

       holder.Text_Name.setText(filteredList.get(position).getCategoryName());
        String i = filteredList.get(position).getImage();
        Uri u = Uri.parse(i);
        holder.ProgrossSpare.setVisibility(View.VISIBLE);
        Picasso.with(con)
                .load("http://qussat.com/"+u)
                .into(holder.img_Category, new Callback() {
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
                product_id.id(filteredList.get(position).getCategoryID());
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

