package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class ProductStandardPrice extends BasePage {
    /**
     *
     * @param price price.
     * @return the new Product Detail Page.
     */
    public abstract ProductDetailPage addPrice(String price);
}
