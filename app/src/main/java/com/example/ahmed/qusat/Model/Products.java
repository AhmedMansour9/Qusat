package com.example.ahmed.qusat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed on 31/10/2018.
 */

public class Products {


    @SerializedName("Product ID")
    @Expose
    private String productID;
    @SerializedName("Product Name")
    @Expose
    private String productName;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("Model Product")
    @Expose
    private String modelProduct;
    @SerializedName("Category Name")
    @Expose
    private String categoryName;
    @SerializedName("Brand Name")
    @Expose
    private String brandName;
    @SerializedName("nameVendor")
    @Expose
    private String nameVendor;
    @SerializedName("addressVendor")
    @Expose
    private String addressVendor;
    @SerializedName("phoneVendor")
    @Expose
    private String phoneVendor;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getModelProduct() {
        return modelProduct;
    }

    public void setModelProduct(String modelProduct) {
        this.modelProduct = modelProduct;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getNameVendor() {
        return nameVendor;
    }

    public void setNameVendor(String nameVendor) {
        this.nameVendor = nameVendor;
    }

    public String getAddressVendor() {
        return addressVendor;
    }

    public void setAddressVendor(String addressVendor) {
        this.addressVendor = addressVendor;
    }

    public String getPhoneVendor() {
        return phoneVendor;
    }

    public void setPhoneVendor(String phoneVendor) {
        this.phoneVendor = phoneVendor;
    }
}
