package com.example.stone.designsupportdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stone on 2015/9/9.
 */
public     class DeAdapter extends RecyclerView.Adapter<DViewHolder>{
    ArrayList<String> datalist;
    public DeAdapter(ArrayList<String> datalist){
        this.datalist = datalist;
    }
    @Override
    public DViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_item, viewGroup, false);
        DViewHolder vh = new DViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DViewHolder dViewHolder, int i) {
        dViewHolder.text.setText(datalist.get(i));
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
    public void add(String s){
        datalist.add(s);
        notifyItemInserted(datalist.size());
    }
}
class DViewHolder extends RecyclerView.ViewHolder{
    TextView text;
    public DViewHolder(View itemView) {
        super(itemView);
        text = (TextView)itemView.findViewById(R.id.detailText);
    }
}