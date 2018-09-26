package com.jalasoft.sfdc.entities;

import java.util.List;

public class Quote {
    private String id;
    private String name;
    private String opportunityId;
    private String accountId;
    private String expirationDate;
    private String status;
    private String description;
    private double tax = 0.0;
    private double shippingAndHandling = 0.0;

    private double subTotal = 0.0;
    private double discount = 0.0;
    private double totalPrice = 0.0;
    private double grandTotal = 0.0;
    private List<Product> productList;
}
