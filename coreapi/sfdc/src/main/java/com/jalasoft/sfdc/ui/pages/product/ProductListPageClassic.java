package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */

public class ProductListPageClassic extends ProductListPage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    /**
     * This method perform an action and create a new ProductFormPage.
     *
     * @return a new ProductFormPage.
     */
    @Override
    public ProductFormPage clickNewProduct() {
        log.info("clickNewProduct: ----> action");
        driverTools.clickElement(newBtn);
        return new ProductFormPageClassic();
    }

    /**
     * verify that a product is delete.
     *
     * @param product information the current user.
     * @return is successfully or not successfully.
     */
    @Override
    public boolean isSuccessDeleteProduct(Product product) {
        log.info("isSuccessDeleteProduct: ----> compare  ");
        return driverTools.isElementDisplayed(By.xpath("//a[contains(text(),'" + product.getProductName() + "')]"));
    }

    /**
     * Select the product Item.
     *
     * @param product
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage selectProductItem(Product product) {
        log.info("selectProductItem: ----> return  ProductDetailPageClassic ");
        driverTools.refreshPage();
        driverTools.clickElement(By.xpath("//a[contains(text(),'"+product.getProductName()+"')]"));
        return new ProductDetailPageClassic();
    }

}
