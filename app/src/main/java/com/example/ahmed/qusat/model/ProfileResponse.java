package com.example.ahmed.qusat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse {

    @SerializedName("data")
    @Expose
    private ProfileData data;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("error")
    @Expose
    private String error;

    public ProfileData getData() {
        return data;
    }

    public void setData(ProfileData data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
