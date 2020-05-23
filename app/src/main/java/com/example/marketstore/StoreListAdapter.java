package com.example.marketstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.StoreListViewHolder>{

    private StoreList storeList = new StoreList();

    public StoreListAdapter(StoreList storeList) {
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public StoreListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_list_view, parent, false);
        return new StoreListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreListViewHolder holder, int position) {
        holder.textViewItem.setText(this.storeList.getProductList().get(position).getNome());
        holder.textViewPrice.setText(String.valueOf(this.storeList.getProductList().get(position).getPreco()));
    }

    @Override
    public int getItemCount() {
        return this.storeList.getProductList().size();
    }

    public static class StoreListViewHolder extends RecyclerView.ViewHolder {

        TextView textViewItem;
        TextView textViewPrice;

        public StoreListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewItem = itemView.findViewById(R.id.textViewItem);
            this.textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
