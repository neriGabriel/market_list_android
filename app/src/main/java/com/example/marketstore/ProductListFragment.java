package com.example.marketstore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {

    private List<Product> productList = new ArrayList<Product>();
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private StoreList storeList = new StoreList();


    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_product_list, container, false);

        this.reset();
        this.populate();
        this.recyclerView = v.findViewById(R.id.recyclerView);
        this.productAdapter = new ProductAdapter(this.productList);

        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(productAdapter);
        setHasOptionsMenu(true);

        return v;
    }

    private void populate() {
        for(int i = 0; i <= 20; i++) {
            Product objPopulate = new Product( i, "Product n "+i, "Product n "+i, 10, false);
            this.productList.add(objPopulate);
        }
    }

    private void reset() {
        this.productList = new ArrayList<Product>();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.cart:
                this.storeList = this.productAdapter.returnItensSelecteds();
                NavDirections action = ProductListFragmentDirections.actionProductListFragmentToStoreListFragment(this.storeList);
                Navigation.findNavController(getView()).navigate(action);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
