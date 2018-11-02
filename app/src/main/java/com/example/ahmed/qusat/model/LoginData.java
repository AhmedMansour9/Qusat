package com.example.ahmed.qusat.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class LoginData {
    @SerializedName("user_token")
    @Expose
    private String userToken;
    @SerializedName("message")
    @Expose
    private String message;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
