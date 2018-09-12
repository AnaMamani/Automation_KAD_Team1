package com.jalasoft.sfdc.entities;

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
    private String active;

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
        this.productName = productName;
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
    public String getActive() {
        return active;
    }

    /**
     * Sets the state product.
     * @param active or no active product.
     */
    public void setActive(String  active) {
        this.active = active;
    }
}
