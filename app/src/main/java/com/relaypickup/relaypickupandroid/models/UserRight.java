package com.relaypickup.relaypickupandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRight {

    @SerializedName("entityKey")
    @Expose
    private Integer entityKey;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("profiles")
    @Expose
    private Object profiles;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("idRightProfileJoin")
    @Expose
    private Integer idRightProfileJoin;

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

    public Object getProfiles() {
        return profiles;
    }

    public void setProfiles(Object profiles) {
        this.profiles = profiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}