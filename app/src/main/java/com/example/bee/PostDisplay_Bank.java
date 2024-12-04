package com.example.bee;

import com.google.gson.annotations.SerializedName;

public class PostDisplay_Bank {


    @SerializedName("StatusCode")
    private int statusCode;

    @SerializedName("uid")
    private String uid;

    @SerializedName("atmno")
    private String atmNo;

    @SerializedName("accno")
    private String accNo;

    @SerializedName("bank")
    private String bank;

    @SerializedName("branch")
    private String branch;

    @SerializedName("ifsc")
    private String ifsc;

    @SerializedName("phno")
    private String phoneNumber;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAtmNo() {
        return atmNo;
    }

    public void setAtmNo(String atmNo) {
        this.atmNo = atmNo;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
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

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
