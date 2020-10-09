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


import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Scree1Adapter extends RecyclerView.Adapter<Scree1Adapter.ViewHolder>
{



    Context context;

    List<Screen1Model> mydata;


    public Scree1Adapter(Context context, List<Screen1Model> mydata) {
        this.context = context;
        this.mydata = mydata;
    }

    @NonNull
    @Override
    public Scree1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.screen1_adapter,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Scree1Adapter.ViewHolder holder, final int position) {

        holder.userid.setText("User id-"+mydata.get(position).getUserid());
        holder.id.setText("Id-"+mydata.get(position).getId());
        holder.title.setText("Title-"+mydata.get(position).getTitle());
        holder.body.setText("Body-"+mydata.get(position).getBody());



    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userid,id,title,body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userid=itemView.findViewById(R.id.userid);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }



}