package com.relaypickup.relaypickupandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeAddress {

    @SerializedName("entityKey")
    @Expose
    private Integer entityKey;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("quarter")
    @Expose
    private String quarter;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("xcoordinate")
    @Expose
    private Double xcoordinate;
    @SerializedName("ycoordinate")
    @Expose
    private Double ycoordinate;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getXcoordinate() {
        return xcoordinate;
    }

    public void setXcoordinate(Double xcoordinate) {
        this.xcoordinate = xcoordinate;
    }

    public Double getYcoordinate() {
        return ycoordinate;
    }

    public void setYcoordinate(Double ycoordinate) {
        this.ycoordinate = ycoordinate;
    }

}