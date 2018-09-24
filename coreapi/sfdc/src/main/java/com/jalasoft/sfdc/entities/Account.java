package com.jalasoft.sfdc.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * User class contains the Account information.
 *
 * @author Ketty Camacho Vasquez
 * @since 7/3/2018
 */
public class Account {

    private String accountName;
    private String parentAccount;
    private String accountNumber;
    private String accountSite;
    private String fax;
    private String phone;
    private String type;
    private String industry;
    private String annualRevenue;
    private String ranting;
    private String website;
    private String tickerSymbol;
    private String ownership;
    private String employees;
    private String sicCode;
    private String billingStreet;
    private String billingZip;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String shippingStreet;
    private String shippingZip;
    private String shippingStae;
    private String shippingCountry;
    private String customerPriority;
    private String numberOfLocation;
    private String id;



//    public Account(String accountName, String parentAccount, String accountNumber, String accountSite,String fax, String phone,String type,String industry,String annualRevenue,
//                   String ranting,String website,String tickerSymbol,String ownership,String employees,String sicCode,String billingStreet,String billingZip,String billingCity,
//                   String billingState,String billingCountry,String shippingStreet,String shippingZip,String shippingStae,String shippingCountry,String customerPriority,String numberOfLocation,String id){
//        this.accountName = accountName;
//        this.parentAccount= parentAccount;
//        this.accountNumber=accountNumber;
//        this.accountSite=accountSite;
//        this.fax=fax;
//        this.phone=phone;
//        this.type=type;
//        this.industry=industry;
//        this.annualRevenue=annualRevenue;
//        this.ranting=ranting;
//        this.website=website;
//        this.tickerSymbol=tickerSymbol;
//        this.ownership=ownership;
//        this.employees=employees;
//        this.sicCode=sicCode;
//        this.billingStreet=billingStreet;
//        this.billingCity=billingCity;
//        this.billingCountry=billingCountry;
//        this.billingZip=billingZip;
//        this.billingState=billingState;
//        this.shippingCountry=shippingCountry;
//        this.shippingStae=shippingStae;
//        this.shippingZip=shippingZip;
//        this.shippingStreet=shippingStreet;
//        this.customerPriority=customerPriority;
//        this.numberOfLocation=numberOfLocation;
//        this.id=id;
//
//    }
    /**
     * Get the Account ID.
     * @Return ID account.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the Account ID.
     * @param id ID the product.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *gets the Account Names.
     * @return account names.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     *gets the Parent Account.
     * @return account parent.
     */
    public String getParentAccount() {
        return parentAccount;
    }
    /**
     *gets the Account Number.
     * @return account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    /**
     *gets the Account Site.
     * @return account site.
     */
    public String getAccountSite() {
        return accountSite;
    }
    /**
     *gets the phone
     * @return phone account.
     */
    public String getPhone() {
        return phone;
    }
    /**
     *gets the fax
     * @return fax.
     */
    public String getFax() {
        return fax;
    }

    /**
     *  sets of account name.
     * @param accountName to set
     */
    public void setAccountName(String accountName) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
       // this.accountName = accountName.concat(" ").concat(timeStamp);
        this.accountName = accountName;
    }

    /**
     *sets of parent account.
     * @param parentAccount to set
     */
    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    /**
     *sets of account site
     * @param accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *sets account site.
     * @param accountSite to set.
     */
    public void setAccountSite(String accountSite) {
        this.accountSite = accountSite;
    }

    /**
     *sets  fax
     * @param fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     *sets phone
     * @param phone to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getRanting() {
        return ranting;
    }

    public void setRanting(String ranting) {
        this.ranting = ranting;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getSicCode() {
        return sicCode;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public String getShippingZip() {
        return shippingZip;
    }

    public void setShippingZip(String shippingZip) {
        this.shippingZip = shippingZip;
    }

    public String getShippingStae() {
        return shippingStae;
    }

    public void setShippingStae(String shippingStae) {
        this.shippingStae = shippingStae;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getCustomerPriority() {
        return customerPriority;
    }

    public void setCustomerPriority(String customerPriority) {
        this.customerPriority = customerPriority;
    }

    public String getNumberOfLocation() {
        return numberOfLocation;
    }

    public void setNumberOfLocation(String numberOfLocation) {
        this.numberOfLocation = numberOfLocation;
    }

}
