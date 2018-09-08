package com.jalasoft.sfdc.entities;

public class Contact {
    private String firstName;
    private String lastName;


    public Contact(String viewName, String uniqueName){
        this.firstName = viewName;
        this.lastName= uniqueName;
    }
}
