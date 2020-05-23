package com.example.marketstore;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StoreList  implements Serializable {

    private List<Product> productList = new ArrayList<Product>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addItem(Product product) {
        this.productList.add(product);
    }
}
