package com.relaypickup.relaypickupandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RelayPickupUser {

    @SerializedName("packages")
    @Expose
    private List<Object> packages = null;

    @SerializedName("idAddress")
    @Expose
    private Integer idAddress;
    @SerializedName("homeAddress")
    @Expose
    private HomeAddress homeAddress;
    @SerializedName("idCardNumber")
    @Expose
    private String idCardNumber;
    @SerializedName("entityKey")
    @Expose
    private Integer entityKey;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("userRole")
    @Expose
    private String userRole;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("idProfile")
    @Expose
    private Integer idProfile;
    @SerializedName("profile")
    @Expose
    private Profile profile;

    public RelayPickupUser() {
        super();
    }

    public List<Object> getPackages() {
        return packages;
    }

    public void setPackages(List<Object> packages) {
        this.packages = packages;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}