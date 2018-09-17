package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.BasePage;
import org.apache.log4j.Logger;

public abstract class ProductDetailPage extends BasePage {
    protected Logger log = Logger.getLogger(getClass());
    /**
     * verify that a product is create.
     * @param product information the current user.
     * @return is successfully or not successfully.
     */
    public abstract boolean isSuccessCreateProduct(Product product);

    /**
     * @return the product name created.
     */
    public abstract String getProductNameCreated();

    /**
     * select the product to edit.
     * @return ProductFormPage.
     */
    public abstract ProductFormPage selectProductToEdit();

    /**
     * select the product to delete.
     * @return ProductListPage.
     */
    public abstract ProductListPage deleteProduct(Product product);
}
