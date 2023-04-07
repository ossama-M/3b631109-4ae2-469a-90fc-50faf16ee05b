package com.hackerrank.eshopping.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRequest {
    @JsonProperty("retail_price")
    private Double retailPrice;
    @JsonProperty("discounted_price")
    private Double discountedPrice;
    private Boolean availability;

    public UpdateRequest() {
    }

    public UpdateRequest(Double retailPrice, Double discountedPrice, Boolean availability) {
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.availability = availability;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
