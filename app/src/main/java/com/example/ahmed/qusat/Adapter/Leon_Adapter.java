package com.example.ahmed.qusat.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ahmedd.qusat.R;
import com.example.ahmed.qusat.Model.Categories;
import com.example.ahmed.qusat.Model.Leons;
import com.example.ahmed.qusat.View.Product_id;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ahmed on 01/11/2018.
 */

public class Leon_Adapter extends RecyclerView.Adapter<Leon_Adapter.MyViewHolder>{

    private List<Leons> filteredList=new ArrayList<>();
    View itemView;
    Context con;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Price,LibrarName,inmonth,Year;
        private Button Callnow,Details;
        private CircleImageView img_Category;
        public MyViewHolder(View view) {
            super(view);
            img_Category=view.findViewById(R.id.image_Category);
            Price=view.findViewById(R.id.T_Price);
            LibrarName=view.findViewById(R.id.T_LibraryName);
            inmonth=view.findViewById(R.id.T_Month);
            Year=view.findViewById(R.id.T_year);
        }

    }

    public Leon_Adapter(List<Leons> list, Context context){
        this.filteredList=list;
        this.con=context;
    }

    @Override
    public Leon_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemleon, parent, false);
        return new Leon_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Leon_Adapter.MyViewHolder holder, final int position) {
       holder.Price.setText(String.valueOf(filteredList.get(position).getPrice()));
        holder.LibrarName.setText(String.valueOf(filteredList.get(position).getDeposit()));
        holder.inmonth.setText(filteredList.get(position).getLoanDuration());
        holder.Year.setText(filteredList.get(position).getPeriod());
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

