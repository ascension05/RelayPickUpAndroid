package com.relaypickup.relaypickupandroid.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("entityKey")
    @Expose
    private Integer entityKey;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userProfile")
    @Expose
    private String userProfile;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("idRightProfileJoin")
    @Expose
    private Integer idRightProfileJoin;
    @SerializedName("userRights")
    @Expose
    private List<UserRight> userRights = null;

    public Integer getEntityKey() {
        return entityKey;
    }

    public void setEntityKey(Integer entityKey) {
        this.entityKey = entityKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Integer getIdRightProfileJoin() {
        return idRightProfileJoin;
    }

    public void setIdRightProfileJoin(Integer idRightProfileJoin) {
        this.idRightProfileJoin = idRightProfileJoin;
    }

    public List<UserRight> getUserRights() {
        return userRights;
    }

    public void setUserRights(List<UserRight> userRights) {
        this.userRights = userRights;
    }

}