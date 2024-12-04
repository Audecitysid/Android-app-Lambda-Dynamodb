package com.example.bee;

import com.google.gson.annotations.SerializedName;

public class PostBankshow1Activity {
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

    @SerializedName("phone")
    private String phone;

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
