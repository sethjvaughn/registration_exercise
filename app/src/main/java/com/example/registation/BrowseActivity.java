package com.example.registation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BrowseActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;

    private Button returnBtn;
    private String[] names = {"Cat","Husky", "Yellow Duck", "Fawn", "Tiger"};
    private int[] icons = {R.drawable.cat, R.drawable.deer, R.drawable.duck,R.drawable.husky,R.drawable.tiger};

    private String[] description= {"Cats are graceful, carnivorous (meat-eating) mammals with sharp teeth and claws.",
            "Deer are herbivorous (plant-eating), even-toed hoofed mammals.","Ducks are an immense group of aquatic birds, known as waterfowl.",
            "The Siberian Husky is a medium size working dog breed that originated in north-eastern Siberia, Russia. ",
            "Tiger, ( Panthera tigris ), largest member of the cat family ( Felidae ), rivaled only by the lion ( Panthera leo) in strength and ferocity. "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        mRecyclerView = findViewById(R.id.recV);
        returnBtn = findViewById(R.id.return_btn);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeAdapter();
        mRecyclerView.setAdapter(mAdapter);
        returnBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
       BrowseActivity.this.finish();
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(BrowseActivity.this).inflate
                    (R.layout.list_item,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder( MyViewHolder holder, int position) {
            holder.name.setText(names[position]);
            holder.desc.setText(description[position]);
            holder.iv.setImageResource(icons[position]);
        }
        @Override
        public int getItemCount() {
            return names.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView name, desc;
            ImageView iv;

            public MyViewHolder( View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.aName);
                desc = itemView.findViewById(R.id.animal_desc);
                iv = itemView.findViewById(R.id.animal_iv);
            }
        }
    }
}