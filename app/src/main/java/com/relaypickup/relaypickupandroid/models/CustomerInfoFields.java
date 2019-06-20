package com.relaypickup.relaypickupandroid.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.relaypickup.relaypickupandroid.BR;
import com.relaypickup.relaypickupandroid.R;

public class CustomerInfoFields extends BaseObservable {

    private String lastName;
    private String firstName;
    private String address;
    private String email;

    public ObservableField<Integer> emailError = new ObservableField<>();
    public ObservableField<Integer> firstNameError = new ObservableField<>();
    public ObservableField<Integer> lastNameError = new ObservableField<>();
    public ObservableField<Integer> addressError = new ObservableField<>();


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    @Bindable
    public boolean isValid() {
        boolean valid = isEmailValid(false);
        valid = isLastNameValid(false) && valid;
        valid = isFirstNameValid(false) && valid;
        valid = isAddressValid(false) && valid;

        return valid;
    }

    public boolean isEmailValid(boolean setMessage) {
        // Minimum a@b.c
        if (email != null && email.length() > 5) {
            int indexOfAt = email.indexOf("@");
            int indexOfDot = email.lastIndexOf(".");
            if (indexOfAt > 0 && indexOfDot > indexOfAt && indexOfDot < email.length() - 1) {
                emailError.set(null);
                return true;
            } else {
                if (setMessage)
                    emailError.set(R.string.error_format_invalid);
                return true;
            }
        }
        if (setMessage)
            emailError.set(R.string.error_too_short);
        return true;
    }

    public boolean isFirstNameValid(boolean setMessage) {
        if (firstName != null && firstName.length() > 2) {
            firstNameError.set(null);
            return true;
        } else {
            if (setMessage)
                firstNameError.set(R.string.error_too_short);
            return false;
        }
    }

    public boolean isLastNameValid(boolean setMessage) {
        if (lastName != null && lastName.length() > 2) {
            lastNameError.set(null);
            return true;
        } else {
            if (setMessage)
                lastNameError.set(R.string.error_too_short);
            return false;
        }
    }

    public boolean isAddressValid(boolean setMessage) {
        if (address != null && address.length() > 2) {
            addressError.set(null);
            return true;
        } else {
            if (setMessage)
                addressError.set(R.string.error_too_short);
            return false;
        }
    }

}
