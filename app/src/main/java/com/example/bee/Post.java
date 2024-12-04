package com.example.bee;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("StatusCode")
    private int statusCode;

    @SerializedName("request")
    private String request;

    @SerializedName("name")
    private String name;

    @SerializedName("uid")
    private String uid;

    @SerializedName("password")
    private String password;

    @SerializedName("isvalid")
    private String isValid;

    @SerializedName("body")
    private String text;

    @SerializedName("bank")
    private String bank;

    @SerializedName("branch")
    private String branch;

    @SerializedName("ifsc")
    private String ifsc;

    @SerializedName("phone")
    private String phone;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    // Getter and Setter methods for IFSC
    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    // Getter and Setter methods for phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
