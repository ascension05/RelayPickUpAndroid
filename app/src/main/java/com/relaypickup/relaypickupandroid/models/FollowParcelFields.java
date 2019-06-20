package com.relaypickup.relaypickupandroid.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.relaypickup.relaypickupandroid.BR;
import com.relaypickup.relaypickupandroid.R;

public class FollowParcelFields extends BaseObservable {

    private String code;
    private String sender;
    private String recipient;
    private String parcelDetailBoxVisibility = "invisible";
    public ObservableField<Integer> codeError = new ObservableField<>();


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    @Bindable
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    @Bindable
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    public void setParcelDetailBoxVisibility(String parcelDetailBoxVisibility) {
        this.parcelDetailBoxVisibility = parcelDetailBoxVisibility;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }


    public String getParcelDetailBoxVisibility() {
        return parcelDetailBoxVisibility;
    }


    @Bindable
    public boolean isValid() {
        boolean valid = isCodeValid(false);
        return valid;
    }



    public boolean isCodeValid(boolean setMessage) {
        if (code != null && code.length() > 0) {
            codeError.set(null);
            return true;
        } else {
            if (setMessage)
                codeError.set(R.string.error_too_short);
            return false;
        }
    }
}
