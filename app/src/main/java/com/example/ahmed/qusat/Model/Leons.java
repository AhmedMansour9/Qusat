package com.example.ahmed.qusat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed on 01/11/2018.
 */

public class Leons {

    @SerializedName("Loan ID")
    @Expose
    private Integer loanID;
    @SerializedName("Product ID")
    @Expose
    private String productID;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("Deposit")
    @Expose
    private String deposit;
    @SerializedName("Loan Duration")
    @Expose
    private String loanDuration;
    @SerializedName("Period")
    @Expose
    private String period;

    public Integer getLoanID() {
        return loanID;
    }

    public void setLoanID(Integer loanID) {
        this.loanID = loanID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(String loanDuration) {
        this.loanDuration = loanDuration;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
