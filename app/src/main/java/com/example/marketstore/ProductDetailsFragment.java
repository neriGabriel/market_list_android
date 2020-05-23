package com.example.marketstore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailsFragment extends Fragment {

    private Product product;

    TextView productName;
    TextView productPrice;
    TextView productDescription;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_product_details, container, false);
        this.productName = v.findViewById(R.id.textProductName);
        this.productDescription = v.findViewById(R.id.textProductDescription);
        this.productPrice = v.findViewById(R.id.textPrice);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null) {
            this.product = ProductDetailsFragmentArgs.fromBundle(getArguments()).getProduct();
            this.productName.setText(this.product.getNome());
            this.productDescription.setText(this.product.getDescricao());
            this.productPrice.setText(String.valueOf(this.product.getPreco()));
        }
    }
}
