package com.jalasoft.sfdc.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Product class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */
public class Product {
    private String productName;
    private String productCode;
    private String productDescription;
    private String id;
    private String family;
    private boolean active;

    /**
     * Gets the product name.
     * @return the current product name.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the product name.
     * @param productName the current product name.
     */
    public void setProductName(String productName) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.productName = productName.concat(" ").concat(timeStamp);
    }

    /**
     * Gets the product code.
     * @return the current product code.
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the product code.
     * @param productCode the current product code.
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * Gets the product description.
     * @return the current product description.
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the product description.
     * @param productDescription the current product description.
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Gets the product is active.
     * @return if product is active.
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Sets the state product.
     * @param active or no active product.
     */
    public void setActive(boolean  active) {
        this.active = active;
    }

    /**
     * Gets the product ID.
     * @return the ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the product ID.
     * @param id ID the product.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the product family.
     * @return the family.
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the product family.
     * @param family family the product.
     */
    public void setFamily(String family) {
        this.family = family;
    }
}
