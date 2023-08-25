package com.example.androidmobileorderapp.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmobileorderapp.R;
import com.example.androidmobileorderapp.adapter.MenuAdapter;
import com.example.androidmobileorderapp.models.Addon;
import com.example.androidmobileorderapp.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MenuActivity extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView rvMenu;
    private ArrayList<Item> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        items.add(new Item("1", "Chicago Style Hot Dog", "Desc", 4.59, R.drawable.hotdog));
        items.add(new Item("2", "Italian Beef Sandwich", "Sliced beef cooked in gravy.", 7.99, R.drawable.italianbeef));
        items.add(new Item("3", "Jumbo Dog", "Quarter pound hot dog.", 6.99, R.drawable.jumbo));
        items.add(new Item("1", "Cheese Dog", "Cheese with raw onion.", 4.59, R.drawable.cheesedog));
        items.add(new Item("2", "Chili Cheese Dog", "Chili (no beans) and cheese with raw onion.", 7.99, R.drawable.chilicheesedog));
        items.add(new Item("3", "Chicago Polish", "100% Beef Vienna Beef Polish. Mustard, Relish, Onion, Pickle, Celery Salt, and Sport Pepper.", 6.99, R.drawable.chicagopolish));
        items.add(new Item("1", "Corn Dog", "Vienna Beef hot dog dipped in batter and deep fried.", 4.59, R.drawable.corndog));
        items.add(new Item("2", "Chili Dog", "Chili (no beans) with raw onion.", 7.99, R.drawable.chilidog));
        items.add(new Item("3", "Maxwell Street Polish", "Deep fried pork and beef polish sausage topped with grilled onions, mustard, and sport pepper.", 6.99, R.drawable.maxwellpolish));

        ArrayList<Addon> addons = new ArrayList<>();
        addons.add(new Addon(10, "Add Sweet Peppers", 1.25));
        addons.add(new Addon(11, "Add Hot Peppers", 1.20));
        addons.add(new Addon(12, "Add Cheddar Cheese", 1.50));
        addons.add(new Addon(13, "Add Ketchup", 0));
        addons.add(new Addon(11, "Add Hot Peppers", 1.20));
        addons.add(new Addon(12, "Add Cheddar Cheese", 1.50));
        addons.add(new Addon(13, "Add Ketchup", 0));
        addons.add(new Addon(11, "Add Hot Peppers", 1.20));
        addons.add(new Addon(12, "Add Cheddar Cheese", 1.50));
        addons.add(new Addon(13, "Add Ketchup", 0));
        items.get(2).setAddons(addons);

        rvMenu = findViewById(R.id.rv_menu);
        MenuAdapter menuAdapter = new MenuAdapter(this, items, this);
        rvMenu.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
//        rvMenu.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvMenu.setLayoutManager(layoutManager);
        rvMenu.setItemAnimator(new DefaultItemAnimator());
        rvMenu.setAdapter(menuAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MenuActivity.this, ItemActivity.class);
        intent.putExtra("item", items.get(position));
        startActivity(intent);
    }
}