package com.relaypickup.relaypickupandroid.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.relaypickup.relaypickupandroid.BR;
import com.relaypickup.relaypickupandroid.R;

public class ParcelInfoFields extends BaseObservable {

    private String weightNumber;
    private String category;
    private String deliveryMode;

    public ObservableField<Integer> weightNumberError = new ObservableField<>();
    public ObservableField<Integer> categoryError = new ObservableField<>();

    public String getWeightNumber() {
        return weightNumber;
    }

    public String getCategory() {
        return category;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setWeightNumber(String weightNumber) {
        this.weightNumber = weightNumber;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    public void setCategory(String category) {
        this.category = category;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    public boolean isWeightNumberValid(boolean setMessage) {
        if (weightNumber != null && weightNumber.length() > 0) {
            weightNumberError.set(null);
            return true;
        } else {
            if (setMessage)
                weightNumberError.set(R.string.error_too_short);
            return false;
        }
    }

    public boolean isCategoryValid(boolean setMessage) {
        if (category != null && category.length() > 0) {
            categoryError.set(null);
            return true;
        } else {
            if (setMessage)
                categoryError.set(R.string.error_too_short);
            return false;
        }
    }

    @Bindable
    public boolean isValid() {
        boolean valid = isWeightNumberValid(false);
        valid = isCategoryValid(false) && valid;
        return valid;
    }

}
