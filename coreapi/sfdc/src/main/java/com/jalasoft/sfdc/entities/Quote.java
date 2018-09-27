package com.jalasoft.sfdc.entities;

import java.util.List;

/**
 * Quote class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class Quote {
    private String id;
    private String quoteName;
    private String expirationDate;
    private String status;
    private String description;


    public String getQuoteName() {
        return quoteName;
    }

    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
