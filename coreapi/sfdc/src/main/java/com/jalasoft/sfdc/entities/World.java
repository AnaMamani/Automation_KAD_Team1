package com.jalasoft.sfdc.entities;

public class World {
    private Product product;
    private Account account;
    private Opportunities opportunities;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Opportunities getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Opportunities opportunities) {
        this.opportunities = opportunities;
    }
}
