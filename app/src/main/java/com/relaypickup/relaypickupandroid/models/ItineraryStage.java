package com.relaypickup.relaypickupandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItineraryStage {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idLargePackage")
    @Expose
    private Integer idLargePackage;
    @SerializedName("isCompleted")
    @Expose
    private Boolean isCompleted;
    @SerializedName("isCurrentStage")
    @Expose
    private Boolean isCurrentStage;
    @SerializedName("stageOrder")
    @Expose
    private Integer stageOrder;
    @SerializedName("idPackage")
    @Expose
    private Integer idPackage;
    @SerializedName("stageAddress")
    @Expose
    private StageAddress stageAddress;
    @SerializedName("departureTime")
    @Expose
    private String departureTime;
    @SerializedName("arrivalTime")
    @Expose
    private String arrivalTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLargePackage() {
        return idLargePackage;
    }

    public void setIdLargePackage(Integer idLargePackage) {
        this.idLargePackage = idLargePackage;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Boolean getIsCurrentStage() {
        return isCurrentStage;
    }

    public void setIsCurrentStage(Boolean isCurrentStage) {
        this.isCurrentStage = isCurrentStage;
    }

    public Integer getStageOrder() {
        return stageOrder;
    }

    public void setStageOrder(Integer stageOrder) {
        this.stageOrder = stageOrder;
    }

    public Integer getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(Integer idPackage) {
        this.idPackage = idPackage;
    }

    public StageAddress getStageAddress() {
        return stageAddress;
    }

    public void setStageAddress(StageAddress stageAddress) {
        this.stageAddress = stageAddress;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

}
