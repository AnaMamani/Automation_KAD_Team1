package com.jalasoft.sfdc.ui.pages.productFormPage;

import com.jalasoft.sfdc.ui.HomeBasePage;

public abstract class ProductFormPage extends HomeBasePage {

    public abstract ProductDetailPage goToFillProduct(String productName);

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
