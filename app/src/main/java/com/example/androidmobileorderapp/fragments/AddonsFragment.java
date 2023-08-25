package com.example.androidmobileorderapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidmobileorderapp.R;
import com.example.androidmobileorderapp.activities.RecyclerViewInterface;
import com.example.androidmobileorderapp.adapter.AddonsAdapter;
import com.example.androidmobileorderapp.models.Addon;
import com.example.androidmobileorderapp.viewmodels.ItemViewModel;

import java.util.List;

public class AddonsFragment extends Fragment implements RecyclerViewInterface {
    private RecyclerView recyclerView;

    private ItemViewModel itemViewModel;

    private List<Addon> baseAddons;
    private String itemName;
    public AddonsFragment() {
        super(R.layout.fragment_addons);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

        if (getArguments() != null) {
            baseAddons = getArguments().getParcelableArrayList("addons");
            itemName = getArguments().getString("itemName");
        } else {
            itemName = "";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        System.out.println("AddonsFragment");
        super.onViewCreated(view, savedInstanceState);

        if (baseAddons != null) {
            TextView addonsLabel = view.findViewById(R.id.tv_addonsLabel);
            String newLabel = "Add to " + itemName + ":";
            addonsLabel.setText(newLabel);

            recyclerView = view.findViewById(R.id.rv_addons);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            AddonsAdapter addonsAdapter = new AddonsAdapter(getContext(), baseAddons, itemViewModel);
            recyclerView.setAdapter(addonsAdapter);
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}