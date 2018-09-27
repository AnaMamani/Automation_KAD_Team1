package com.jalasoft.sfdc.entities;

/**
 * Quote class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class Quote {
    private String id;
    private String quoteName;
    private String quoteSubtotal;
    private String quoteAccountName;
    private String quoteGranTotal;


    public String getQuoteName() {
        return quoteName;
    }

    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
    }

    public String getQuoteSubtotal() {
        return quoteSubtotal;
    }

    public void setQuoteSubtotal(String quoteSubtotal) {
        this.quoteSubtotal = quoteSubtotal;
    }

    public String getQuoteAccountName() {
        return quoteAccountName;
    }

    public void setQuoteAccountName(String quoteAccountName) {
        this.quoteAccountName = quoteAccountName;
    }

    public String getQuoteGranTotal() {
        return quoteGranTotal;
    }

    public void setQuoteGranTotal(String quoteGranTotal) {
        this.quoteGranTotal = quoteGranTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
