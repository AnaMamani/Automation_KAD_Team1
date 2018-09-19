package com.jalasoft.sfdc.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
    private String firstName =" ";
    private String lastName =" ";
    private String accountName =" ";
    private String title =" ";
    private String email =" ";
    private String phone =" ";
    private String street =" ";
    private String city =" ";
    private String state =" ";
    private String country =" ";



    /**
     * Gets the Contact firstName.
     *
     * @return the current Contact firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName contact firstName to set
     */
    public void setFirstName(String firstName) {
        //String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
       // this.firstName = firstName. concat("").concat(timeStamp);
        this.firstName = firstName;
    }

    /**
     * Gets the Contact lastName.
     *
     * @return the current Contact lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last Name.
     *
     * @param lastName contact lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the Contact accountName.
     *
     * @return the current Contact accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the account accountName.
     *
     * @param accountName contact accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Gets the Contact title.
     *
     * @return the current Contact title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title contact title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the Contact email.
     *
     * @return the current Contact email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the  email.
     *
     * @param email contact email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the Contact phone.
     *
     * @return the current Contact phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone contact phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the Contact street.
     *
     * @return the current Contact street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street .
     *
     * @param street contact street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the Contact city.
     *
     * @return the current Contact city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city .
     *
     * @param city contact city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the Contact state.
     *
     * @return the current Contact state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state contact state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the Contact country.
     *
     * @return the current Contact country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country contact country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
