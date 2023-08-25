package com.example.androidmobileorderapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmobileorderapp.R;
import com.example.androidmobileorderapp.models.Addon;
import com.example.androidmobileorderapp.viewmodels.ItemViewModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AddonsAdapter extends RecyclerView.Adapter<AddonsAdapter.viewHolder>{
    private Context context;
    private List<Addon> baseAddons;

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private final ItemViewModel itemViewModel;
    private List<Addon> selectedAddons = new ArrayList<>();

    public AddonsAdapter(Context context, List<Addon> baseAddons, ItemViewModel itemViewModel) {
        this.context = context;
        this.baseAddons = baseAddons;
        this.itemViewModel = itemViewModel;

        itemViewModel.getSelectedAddons().observeForever(selectedAddons -> {
            this.selectedAddons = selectedAddons;
            notifyDataSetChanged();
        });
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_addon, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Addon addon = baseAddons.get(position);
        holder.name.setText(addon.getName());
        holder.price.setText((addon.getPrice() > 0) ? ("+" + currencyFormat.format(addon.getPrice())) : "");
        if (isAddonSelected(addon)) {
            holder.checkbox.setImageResource(R.drawable.baseline_check_box_24);
        } else {
            holder.checkbox.setImageResource(R.drawable.baseline_check_box_outline_blank_24);
        }
    }



    private boolean isAddonSelected(Addon addon) {
        return selectedAddons.contains(addon);
    }

    @Override
    public int getItemCount() {
        return baseAddons.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView name, price;
        private ImageView checkbox;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_addonName);
            price = itemView.findViewById(R.id.tv_addonPrice);
            checkbox = itemView.findViewById(R.id.iv_addonCheckbox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Selected Addons:");
                    System.out.println(selectedAddons);
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Addon addon = baseAddons.get(position);
                        if (isAddonSelected(addon)) {
                            itemViewModel.removeSelectedAddon(addon);
                        } else {
                            itemViewModel.addSelectedAddon(addon);
                        }
                    }
                }
            });
        }
    }
}
