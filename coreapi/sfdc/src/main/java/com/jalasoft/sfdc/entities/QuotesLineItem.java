package com.jalasoft.sfdc.entities;

public class QuotesLineItem {
    private String salesPrice;
    private String quantity;
    private String totalPrice;

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        final double total = Integer.parseInt(getQuantity()) * Integer.parseInt(getSalesPrice());
        return totalPrice = String.valueOf(total);
    }
}
