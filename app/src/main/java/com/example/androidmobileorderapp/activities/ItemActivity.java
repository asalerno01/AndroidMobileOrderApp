package com.example.androidmobileorderapp.activities;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.androidmobileorderapp.fragments.AddonsFragment;
import com.example.androidmobileorderapp.models.Addon;
import com.example.androidmobileorderapp.models.Item;
import com.example.androidmobileorderapp.viewmodels.ItemViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import com.example.androidmobileorderapp.databinding.ActivityItemBinding;

import com.example.androidmobileorderapp.R;

import java.text.NumberFormat;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private ActivityItemBinding binding;

    private ItemViewModel itemViewModel;

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        System.out.println("Hello from ItemActivity");
        binding = ActivityItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Item item = getIntent().getParcelableExtra("item");
        if (item != null) {
            TextView name = findViewById(R.id.tv_itemName);
            ImageView image = findViewById(R.id.iv_itemImage);
            TextView description = findViewById(R.id.tv_itemDescription);
            name.setText(item.getName());
            description.setText(item.getDescription());
            Glide.with(getApplicationContext()).load(item.getImage()).into(image);
            itemViewModel.setBasePrice(item.getPrice());
            itemViewModel.setCurrentPrice(item.getPrice());
        }

        itemViewModel.getCurrentPrice().observeForever(price -> {
            Button addToCartButton = findViewById(R.id.btn_addToCart);
            String priceString = "Add To Cart - (" + currencyFormat.format(price) + ")";
            addToCartButton.setText(priceString);
        });

        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            assert item != null;
            bundle.putParcelableArrayList("addons", item.getAddons());
            bundle.putString("itemName", item.getName());
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, AddonsFragment.class, bundle)
                    .commit();
        }
    }
}