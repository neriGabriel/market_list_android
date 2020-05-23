package com.example.marketstore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoreListFragment extends Fragment {

    private StoreList storeList;
    private RecyclerView recyclerView;
    private StoreListAdapter storeListAdapter;

    public StoreListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_store_list, container, false);

        if(getArguments() != null) {
            this.storeList = StoreListFragmentArgs.fromBundle(getArguments()).getStoreList();
        }
        this.recyclerView = v.findViewById(R.id.recyclerViewStore);
        this.storeListAdapter = new StoreListAdapter(this.storeList);

        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(storeListAdapter);

        return  v;
    }
}
