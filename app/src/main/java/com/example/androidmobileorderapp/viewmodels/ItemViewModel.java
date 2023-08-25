package com.example.androidmobileorderapp.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidmobileorderapp.models.Addon;

import java.util.ArrayList;
import java.util.List;

public class ItemViewModel extends ViewModel {
    public MutableLiveData<Double> currentPrice = new MutableLiveData<>();

    public MutableLiveData<Double> getCurrentPrice() {
        if (currentPrice.getValue() == null) {
            currentPrice.setValue(0d);
        }
        return currentPrice;
    }

    public void setCurrentPrice(Double price) {
        if (currentPrice.getValue() == null) {
            currentPrice = new MutableLiveData<>();
        }
        currentPrice.setValue(price);
    }

    private MutableLiveData<Double> basePrice = new MutableLiveData<>();

    public MutableLiveData<Double> getBasePrice() {
        if (basePrice.getValue() == null) {
            basePrice = new MutableLiveData<Double>();
        }
        return basePrice;
    }

    private void calculateCurrentPrice() {
        System.out.println("1");
        if (basePrice.getValue() != null && selectedAddons.getValue() != null) {
            System.out.println("2");
            double price = basePrice.getValue();
            for(Addon addon : selectedAddons.getValue()) {
                price += addon.getPrice();
            }
            setCurrentPrice(price);
            System.out.println(currentPrice.getValue());
        }

    }

    public void setBasePrice(Double price) {
        if (basePrice.getValue() == null) {
            basePrice = new MutableLiveData<>();
        }
        basePrice.setValue(price);
    }


    private final MutableLiveData<List<Addon>> selectedAddons = new MutableLiveData<>();

    public MutableLiveData<List<Addon>> getSelectedAddons() {
        if (selectedAddons.getValue() == null) {
            selectedAddons.setValue(new ArrayList<>());
        }
        return selectedAddons;
    }
    public void addSelectedAddon(Addon addon) {
        List<Addon> currentList = selectedAddons.getValue();
        if (currentList != null) {
            currentList.add(addon);
            selectedAddons.setValue(currentList);
            calculateCurrentPrice();
        }
    }

    public void removeSelectedAddon(Addon addon) {
        List<Addon> currentList = selectedAddons.getValue();
        if (currentList != null) {
            currentList.remove(addon);
            selectedAddons.setValue(currentList);
            calculateCurrentPrice();
        }
    }
}
