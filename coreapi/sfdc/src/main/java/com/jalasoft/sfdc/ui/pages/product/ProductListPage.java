package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.ListBasePage;
import org.apache.log4j.Logger;

public abstract class ProductListPage extends ListBasePage {
    protected Logger log = Logger.getLogger(getClass());

    /**
     * This method perform an action and create a new ProductFormPage.
     * @return a new ProductFormPage.
     */
    public abstract ProductFormPage clickNewProduct();
}
