package com.relaypickup.relaypickupandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Parcel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idHolder")
    @Expose
    private Integer idHolder;
    @SerializedName("holderType")
    @Expose
    private String holderType;
    @SerializedName("packageStatus")
    @Expose
    private String packageStatus;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("recipientName")
    @Expose
    private String recipientName;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("deliveryDuration")
    @Expose
    private Integer deliveryDuration;
    @SerializedName("idLargePackage")
    @Expose
    private Integer idLargePackage;
    @SerializedName("itineraryStages")
    @Expose
    private List<ItineraryStage> itineraryStages = null;
    @SerializedName("currentStageOrder")
    @Expose
    private Integer currentStageOrder;
    @SerializedName("customer")
    @Expose
    private RelayPickupUser customer;
    @SerializedName("securityCode")
    @Expose
    private String securityCode;
    @SerializedName("isDelivered")
    @Expose
    private Boolean isDelivered;
    @SerializedName("deliveryTime")
    @Expose
    private String deliveryTime;

    public Parcel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdHolder() {
        return idHolder;
    }

    public void setIdHolder(Integer idHolder) {
        this.idHolder = idHolder;
    }

    public String getHolderType() {
        return holderType;
    }

    public void setHolderType(String holderType) {
        this.holderType = holderType;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDeliveryDuration() {
        return deliveryDuration;
    }

    public void setDeliveryDuration(Integer deliveryDuration) {
        this.deliveryDuration = deliveryDuration;
    }

    public Integer getIdLargePackage() {
        return idLargePackage;
    }

    public void setIdLargePackage(Integer idLargePackage) {
        this.idLargePackage = idLargePackage;
    }

    public List<ItineraryStage> getItineraryStages() {
        return itineraryStages;
    }

    public void setItineraryStages(List<ItineraryStage> itineraryStages) {
        this.itineraryStages = itineraryStages;
    }

    public Integer getCurrentStageOrder() {
        return currentStageOrder;
    }

    public void setCurrentStageOrder(Integer currentStageOrder) {
        this.currentStageOrder = currentStageOrder;
    }

    public RelayPickupUser getCustomer() {
        return customer;
    }

    public void setCustomer(RelayPickupUser customer) {
        this.customer = customer;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }


}

