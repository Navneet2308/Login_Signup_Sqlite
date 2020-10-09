package com.example.loginpage;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;


import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class screen2_adapter extends RecyclerView.Adapter<screen2_adapter.ViewHolder>
{



    Context context;
    List<Screen2Model> mydata;

    public screen2_adapter(Context context, List<Screen2Model> mydata) {
        this.context = context;
        this.mydata = mydata;
    }

    @NonNull
    @Override
    public screen2_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_screen2_adapter,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final screen2_adapter.ViewHolder holder, final int position) {

        holder.id.setText(mydata.get(position).getMid());
        holder.votec.setText(mydata.get(position).getMvotec());
        holder.votea.setText(mydata.get(position).getMvotea());
        holder.orlang.setText(mydata.get(position).getMorlang());
        holder.overview.setText(mydata.get(position).getMoverview());
//        holder.posterimg.setText(mydata.get(position).getMid());
        holder.popularity.setText(mydata.get(position).getMpopularity());
        holder.mediatype.setText(mydata.get(position).getMmediatype());
     holder.title.setText(mydata.get(position).getMtitle());
//        holder.backimg.setImageBitmap();


        Picasso.with(context)
                .load("https://image.tmdb.org/t/p/original"+mydata.get(position).getMposterimg())
                .placeholder(R.drawable.gradient_bg)
                .error(R.drawable.gradient_bg)
                // To fit image into imageView
                .fit()
                // To prevent fade animation
                .noFade()
                .into(holder.posterimg);

        Picasso.with(context)
                .load("https://image.tmdb.org/t/p/original"+mydata.get(position).getMbackimg())
                .placeholder(R.drawable.gradient_bg)
                .error(R.drawable.gradient_bg)
                // To fit image into imageView
                .fit()
                // To prevent fade animation
                .noFade()
                .into(holder.backimg);








    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,votec,votea,title,reldate,orlang,ortitle,gnrid,adult,overview,popularity,mediatype;
        ImageView backimg,posterimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
             id=itemView.findViewById(R.id.mid);
            votec=itemView.findViewById(R.id.votecount);
            votea=itemView.findViewById(R.id.voteavr);
            reldate=itemView.findViewById(R.id.relesedate);
            orlang=itemView.findViewById(R.id.lnguage);
            ortitle=itemView.findViewById(R.id.originaltitle);
            gnrid=itemView.findViewById(R.id.generid);
            adult=itemView.findViewById(R.id.adult);
            overview=itemView.findViewById(R.id.overview);
            popularity=itemView.findViewById(R.id.populrty);
            mediatype=itemView.findViewById(R.id.mediatype);
            backimg=itemView.findViewById(R.id.backpath);
            posterimg=itemView.findViewById(R.id.posterpath);


        }
    }



}