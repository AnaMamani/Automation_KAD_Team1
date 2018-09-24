package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.ListBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */

public abstract class ProductListPage extends ListBasePage {
    protected Logger log = Logger.getLogger(getClass());

    /**
     * This method perform an action and create a new ProductFormPage.
     *
     * @return a new ProductFormPage.
     */
    public abstract ProductFormPage clickNewProduct();

    /**
     * verify that a product is delete.
     *
     * @param product information the current user.
     * @return is successfully or not successfully.
     */
    public abstract boolean isSuccessDeleteProduct(Product product);

    /**
     * Select the product Item.
     * @return a new ProductDetailPage.
     */
    public abstract ProductDetailPage selectProductItem(Product product);
}
