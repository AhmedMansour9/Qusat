package com.example.ahmed.qusat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed on 30/10/2018.
 */

public class Categories {


    @SerializedName("Category ID")
    @Expose
    private String categoryID;
    @SerializedName("Category Name ")
    @Expose
    private String categoryName;
    @SerializedName("Image")
    @Expose
    private String image;

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
