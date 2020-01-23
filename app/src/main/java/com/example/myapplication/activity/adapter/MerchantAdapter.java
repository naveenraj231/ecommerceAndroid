package com.example.myapplication.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

//public class MerchantAdapter extends RecyclerView.Adapter {
//
//
//    private List<ProductDescription> merchantList;
//
//    public MerchantAdapter(List<ProductDescription> merchantList) {
//        this.merchantList = merchantList;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        final ProductDescription productDescription=merchantList.get(position);
//        //Glide.with(holder.imageView.getContext()).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground)).load(productsItem.getImage()).into(holder.imageView);
//        holder.getItemId();
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder
//    {
//        public TextView textView1;
//        public CardView cardView;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            textView1 = itemView.findViewById(R.id.merchantname);
//            cardView=itemView.findViewById(R.id.home_popular_products);
//        }
//    }
//
//
//}
