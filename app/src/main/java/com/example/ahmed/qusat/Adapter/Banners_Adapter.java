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

import com.example.ahmed.qusat.Model.Banners;
import com.example.ahmed.qusat.Model.Categories;
import com.example.ahmed.qusat.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ahmed on 30/10/2018.
 */

public class Banners_Adapter  extends RecyclerView.Adapter<Banners_Adapter.MyViewHolder>{

    private List<Banners> filteredList=new ArrayList<>();
    View itemView;
    Context con;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Text_Name;
        private Button Callnow,Details;
        private ImageView img_banner;
        private ProgressBar Progrossbar;
        public MyViewHolder(View view) {
            super(view);
            img_banner=view.findViewById(R.id.banner);
            Progrossbar=view.findViewById(R.id.Progrossbar);

        }

    }
    public Banners_Adapter(List<Banners> list, Context context){
        this.filteredList=list;
        this.con=context;
    }
    @Override
    public Banners_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itembanner, parent, false);
        return new Banners_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Banners_Adapter.MyViewHolder holder, final int position) {

        String i = filteredList.get(position).getImage();
        Uri u = Uri.parse(i);
        holder.Progrossbar.setVisibility(View.VISIBLE);
        Picasso.with(con)
                .load("http://qussat.com/"+u)
                .into(holder.img_banner, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.Progrossbar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.Progrossbar.setVisibility(View.GONE);
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

