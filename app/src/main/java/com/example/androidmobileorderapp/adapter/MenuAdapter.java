package com.example.androidmobileorderapp.adapter;

import com.bumptech.glide.Glide;
import com.example.androidmobileorderapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmobileorderapp.activities.RecyclerViewInterface;
import com.example.androidmobileorderapp.models.Item;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.viewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    private Context ctx;
    private List<Item> items;

    public MenuAdapter(Context ctx, List<Item> items, RecyclerViewInterface recyclerViewInterface) {
        this.ctx = ctx;
        this.items = items;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_cart, parent, false);
        return new viewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final Item item = items.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.price.setText("$" + String.valueOf(item.getPrice()));
        Glide.with(ctx).load(item.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name, description, price;
        public viewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_itemName);
            description = itemView.findViewById(R.id.txt_itemDescription);
            price = itemView.findViewById(R.id.txt_itemPrice);
            image = itemView.findViewById(R.id.iv_itemImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
