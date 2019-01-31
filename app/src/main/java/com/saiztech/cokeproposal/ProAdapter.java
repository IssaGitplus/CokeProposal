package com.saiztech.cokeproposal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProAdapter extends RecyclerView.Adapter<ProAdapter.MyViewHolder>  {

    private List<Product> productList;
    private boolean isProduct;
    private Context context;

    public ProAdapter(List<Product> productList, Context context, boolean isProduct) {
        this.productList = productList;
        this.context = context;
        this.isProduct = isProduct;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Product product = productList.get(position);

        holder.textView.setText(product.getName());

        if (isProduct)
        {
            holder.imageView.setVisibility(View.GONE);
            holder.textViewPrice.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView textViewPrice;
        private ImageView imageView;
        private View view;

        MyViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.name);
            textViewPrice = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.image);
            view = itemView;
        }
    }
}


