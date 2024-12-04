package com.example.bee;
import com.google.gson.annotations.SerializedName;

public class PostSignup {

    @SerializedName("StatusCode")
    private int statusCode;

    @SerializedName("request")
    private String request;

    @SerializedName("uid")
    private String uid;

    @SerializedName("password")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
