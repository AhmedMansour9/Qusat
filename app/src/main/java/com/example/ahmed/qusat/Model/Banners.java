package com.example.ahmed.qusat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed on 31/10/2018.
 */

public class Banners {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Image")
    @Expose
    private String image;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
