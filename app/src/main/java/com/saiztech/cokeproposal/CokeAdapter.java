package com.saiztech.cokeproposal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CokeAdapter extends RecyclerView.Adapter<CokeAdapter.MyViewHolder>  {

    private List<Coke> cokeList;
    private Context context;

    public CokeAdapter(List<Coke> cokeList, Context context) {
        this.cokeList = cokeList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pro_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Coke coke = cokeList.get(position);

        holder.image.setImageResource(coke.getImage());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.choose, null);
                dialogBuilder.setView(dialogView);

                AlertDialog alertAbout = dialogBuilder.create();

                alertAbout.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cokeList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private View view;

        MyViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            view = itemView;
        }
    }
}

