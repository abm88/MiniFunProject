package com.example.abdulbasith.testmonday.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abdul Basith on 20/11/2017.
 */

public class GameDataModel {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
