package com.relaypickup.relaypickupandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorObject {

    @SerializedName("errorTitle")
    @Expose
    private String errorTitle;

    @SerializedName("errorCode")
    @Expose
    private int errorCode;

    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;

    public String getErrorTitle() {
        return errorTitle;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
