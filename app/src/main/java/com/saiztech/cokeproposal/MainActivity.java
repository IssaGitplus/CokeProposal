package com.saiztech.cokeproposal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        List<Coke> cokeList = new ArrayList<>();
        cokeList.add(new Coke(R.drawable.chale));
        cokeList.add(new Coke(R.drawable.ohemaa));
        cokeList.add(new Coke(R.drawable.bossu));
        cokeList.add(new Coke(R.drawable.paddies));

        CokeAdapter cokeAdapter = new CokeAdapter(cokeList,this);
        recyclerView.setAdapter(cokeAdapter);

        findViewById(R.id.custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomActivity.class));
            }
        });
    }
}
