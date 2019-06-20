package com.relaypickup.relaypickupandroid.models;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.EditText;

public class FollowParcelViewModel extends ViewModel {
    private FollowParcelFields followParcelFields;
    private View.OnFocusChangeListener onFocusCode;

    private MutableLiveData<FollowParcelFields> buttonClick = new MutableLiveData<>();

    public void init() {
        followParcelFields = new FollowParcelFields();
        onFocusCode =  new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    followParcelFields.isCodeValid(true);
                }
            }
        };


    }

    public FollowParcelFields getFollowParcelFields() {
        return followParcelFields;
    }

    public View.OnFocusChangeListener getCodeOnFocusChangeListener() {
        return onFocusCode;
    }


    public void onButtonClick() {
        if (followParcelFields.isValid()) {
            buttonClick.setValue(followParcelFields);
        }
    }

    public MutableLiveData<FollowParcelFields> getButtonClick() {
        return buttonClick;
    }

    @BindingAdapter("followParcelError")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }

    }

    @BindingAdapter("followParcelOnFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }
}
