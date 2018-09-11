package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class ProductFormPage extends BasePage {

    /**
     * This method perform an action of setting and create a new ProductDetailPage.
     * @param productName
     * @return a new ProductDetailPage.
     */
    public abstract ProductDetailPage goToFillProduct(String productName);

}
