package com.relaypickup.relaypickupandroid.models;


import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.EditText;



public class CustomerInfoViewModel extends ViewModel {

    private CustomerInfoFields customerInfoFields;
    private View.OnFocusChangeListener onFocusLastName;
    private View.OnFocusChangeListener onFocusFirstName;
    private View.OnFocusChangeListener onFocusEmail;
    private View.OnFocusChangeListener onFocusAddress;

    public void init() {
        customerInfoFields = new CustomerInfoFields();
        onFocusLastName =  new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    customerInfoFields.isLastNameValid(true);
                }
            }
        };

        onFocusFirstName =  new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    customerInfoFields.isFirstNameValid(true);
                }
            }
        };

        onFocusEmail =  new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    customerInfoFields.isEmailValid(true);
                }
            }
        };

        onFocusAddress =  new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    customerInfoFields.isAddressValid(true);
                }
            }
        };
    }

    public CustomerInfoFields getCustomerInfoFields() {
        return customerInfoFields;
    }

    public View.OnFocusChangeListener getLastNameOnFocusChangeListener() {
        return onFocusLastName;
    }

    public View.OnFocusChangeListener getFirstNameOnFocusChangeListener() {
        return onFocusFirstName;
    }

    public View.OnFocusChangeListener getEmailOnFocusChangeListener() {
        return onFocusEmail;
    }

    public View.OnFocusChangeListener getAddressOnFocusChangeListener() {
        return onFocusAddress;
    }





    @BindingAdapter("customerInfoError")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }

    }

    @BindingAdapter("customerInfoOnFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }
}
