package com.jalasoft.sfdc.entities;

public class Contact {
    private String firstName;
    private String lastName;
    private String accountName;
    private String title;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String country;

    /**
     * Sets the contact name.
     * @param firstName contact firstName to set.
     * @param lastName contact lastName to set.
     * @param accountName contact accountName to set.
     * @param title contact title to set.
     * @param email contact email to set.
     * @param phone contact phone to set.
     * @param street contact street to set.
     * @param city contact city to set.
     * @param state contact state to set.
     * @param country contact country to set.
     */
    public Contact(String firstName, String lastName, String accountName, String title,String email, String phone, String street,  String city,  String state,  String country){
        this.firstName = firstName;
        this.lastName= lastName;
        this.accountName=accountName;
        this.title=title;
        this.email=email;
        this.phone=phone;
        this.street=street;
        this.city=city;
        this.state=state;
        this.country=country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
