package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.BasePage;
import org.apache.log4j.Logger;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */
public abstract class ProductFormPage extends BasePage {
    protected Logger log = Logger.getLogger(getClass());

    /**
     * setting and create a new ProductDetailPage.
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    public abstract ProductDetailPage createProduct(Product product);

    /**
     * fills and edit a  ProductDetailPage.
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    public abstract ProductDetailPage editProduct(Product product);
}
