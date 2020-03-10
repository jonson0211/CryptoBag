package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Coin> data;


    public void setData(ArrayList<Coin>data){
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Coin coinAtPosition = data.get(position);

        holder.name.setText(coinAtPosition.getName());
        holder.value.setText(String.valueOf(coinAtPosition.getValue()));
        holder.change.setText(String.valueOf(coinAtPosition.getChange1h()));

        //onclicklistener
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                System.out.println("HIs");
                intent.putExtra("coinName",coinAtPosition.getName());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView value;
        public TextView change;
        public ImageView image;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            name = itemView.findViewById(R.id.coinName);
            value = itemView.findViewById(R.id.coinValue);
            change = itemView.findViewById(R.id.changeOne);
            image = itemView.findViewById(R.id.image);
        }
    }
}
