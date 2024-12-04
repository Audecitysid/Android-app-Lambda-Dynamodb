package com.example.bee;

import com.google.gson.annotations.SerializedName;

public class PostUPI_Interface {
    @SerializedName("StatusCode")
    private int statusCode;

    @SerializedName("request")
    private String request;

    @SerializedName("uid")
    private String uid;

    @SerializedName("trans_status")
    private String transStatus;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }
}
