package com.saiztech.cokeproposal;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        findViewById(R.id.productLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product_name();
            }
        });

        findViewById(R.id.sizeLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_list();
            }
        });
    }

    private void product_name()
    {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Coca Cola"));
        productList.add(new Product("Coca Cola Zero sugar"));
        productList.add(new Product("Fanta Apple"));
        productList.add(new Product("Fanta Cocktail"));
        productList.add(new Product("Fanta Orange"));
        productList.add(new Product("Fanta Lemon"));
        productList.add(new Product("Sprite"));

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_about, null);
        dialogBuilder.setView(dialogView);

        AlertDialog alertAbout = dialogBuilder.create();

        ProAdapter proAdapter = new ProAdapter(productList, this, true);
        RecyclerView recyclerViewCat = dialogView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerViewCat.setLayoutManager(mLayoutManager);
        recyclerViewCat.setAdapter(proAdapter);

        alertAbout.show();
    }

    private void size_list ()
    {
            List<Product> productList = new ArrayList<>();
            productList.add(new Product("0.35 litre"));
            productList.add(new Product("0.50 litre"));
            productList.add(new Product("1 litre"));
            productList.add(new Product("2 litres"));
            productList.add(new Product("Can"));

            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog_about, null);
            dialogBuilder.setView(dialogView);

            AlertDialog alertAbout = dialogBuilder.create();

            ProAdapter proAdapter = new ProAdapter(productList, this, false);
            RecyclerView recyclerViewCat = dialogView.findViewById(R.id.recycler_view);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerViewCat.setLayoutManager(mLayoutManager);
            recyclerViewCat.setAdapter(proAdapter);

            alertAbout.show();
        }
    }

