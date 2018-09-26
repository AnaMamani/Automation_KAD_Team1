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
public abstract class ProductDetailPage extends BasePage {
    protected Logger log = Logger.getLogger(getClass());

    /**
     * verify that a product is create.
     *
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
     *
     * @return ProductFormPage.
     */
    public abstract ProductFormPage clickEditOption();

    /**
     * select the product to delete.
     *
     * @return ProductListPage.
     */
    public abstract ProductListPage deleteProduct(Product product);

    /**
     * verify the edit the product.
     *
     * @param product information the current user.
     */
    public abstract boolean isSuccessEditProduct(Product product);

    /**
     * verify the edit the product.
     *
     * @param productApi  information the current user by API.
     * @param productEdit information the current user.
     */
    public boolean isSuccessEditProductByAPI(Product productApi, Product productEdit) {
        log.info("isSuccessEditProductByAPI:   ");
        boolean result = true;
        if (productEdit.getProductName() != null && !productEdit.getProductName().equals(productApi.getProductName())) {
            log.info("product name :" + productEdit.getProductName() + " ====> " + productApi.getProductName());
            return false;
        }

        if (productEdit.getProductCode() != null && !productEdit.getProductCode().equals(productApi.getProductCode())) {
            log.info("product code :" + productEdit.getProductCode() + " ====> " + productApi.getProductCode());
            return false;
        }
        if (productEdit.getProductDescription() != null && !productEdit.getProductDescription().equals(productApi.getProductDescription())) {
            log.info("product name :" + productEdit.getProductDescription() + " ====> " + productApi.getProductDescription());
            return false;
        }
        return result;

    }

    /**
     * add the price book at product.
     *
     * @return new page of ProductPriceBookPage.
     */
    public abstract ProductPriceBookPage clickAddPriceBook();

    /**
     * add the price book at product.
     *
     * @return new page of ProductStandardPrice.
     */
    public abstract ProductStandardPrice clickAddPrice();
}
