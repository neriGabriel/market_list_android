package com.example.marketstore;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item_view, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final @NonNull ProductViewHolder holder, final int position) {
        holder.textProductName.setText(this.productList.get(position).getNome());
        holder.textProductDescription.setText(this.productList.get(position).getDescricao());
        holder.checkItemStore.setSelected(this.productList.get(position).isStatus());

        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(productList.get(position));
                Navigation.findNavController(view).navigate(action);
            }
        });

        holder.checkItemStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productList.get(position).setStatus(holder.checkItemStore.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.productList.size();
    }

    public StoreList returnItensSelecteds() {
        StoreList objReturn = new StoreList();
        for(int i = 0; i <= 20; i++) {
           if(this.productList.get(i).isStatus()) {

               objReturn.addItem(productList.get(i));
           }
        }
        return objReturn;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textProductName;
        TextView textProductDescription;
        CheckBox checkItemStore;
        CardView cardItem;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textProductName = itemView.findViewById(R.id.textProductName);
            this.textProductDescription= itemView.findViewById(R.id.textProductDescription);
            this.checkItemStore = itemView.findViewById(R.id.checkItemStore);
            this.cardItem = itemView.findViewById(R.id.cardItem);
        }
    }

}
