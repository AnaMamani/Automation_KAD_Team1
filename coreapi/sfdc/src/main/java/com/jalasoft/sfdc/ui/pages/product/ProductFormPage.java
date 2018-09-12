package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.BasePage;
import org.apache.log4j.Logger;

public abstract class ProductFormPage extends BasePage {
    protected Logger log = Logger.getLogger(getClass());

    /**
     * setting and create a new ProductDetailPage.
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    public abstract ProductDetailPage createProduct(Product product);

}
