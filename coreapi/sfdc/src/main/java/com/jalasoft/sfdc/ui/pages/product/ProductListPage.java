package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.ListBasePage;

public abstract class ProductListPage extends ListBasePage {

    /**
     * This method perform an action and create a new ProductFormPage.
     * @return a new ProductFormPage.
     */
    public abstract ProductFormPage clickNewProduct();
}
