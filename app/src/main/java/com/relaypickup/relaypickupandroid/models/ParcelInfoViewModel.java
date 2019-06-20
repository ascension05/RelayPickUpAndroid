package com.relaypickup.relaypickupandroid.models;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.EditText;

public class ParcelInfoViewModel extends ViewModel {
    private ParcelInfoFields parcelInfo;
    private View.OnFocusChangeListener onFocusWeightNumber;
    private View.OnFocusChangeListener onFocusCategory;

    public void init() {
        parcelInfo = new ParcelInfoFields();

        onFocusWeightNumber =  new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    parcelInfo.isWeightNumberValid(true);
                }
            }
        };

        onFocusCategory =  new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    parcelInfo.isWeightNumberValid(true);
                }
            }
        };
    }

    public ParcelInfoFields getParcelInfo(){
        return parcelInfo;
    }

    public View.OnFocusChangeListener getWeightNumberOnFocusChangeListener() {
        return onFocusWeightNumber;
    }

    public View.OnFocusChangeListener getCategoryOnFocusChangeListener() {
        return onFocusCategory;
    }

    @BindingAdapter("parcelInfoError")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }

    }

    @BindingAdapter("parcelInfoOnFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

}
