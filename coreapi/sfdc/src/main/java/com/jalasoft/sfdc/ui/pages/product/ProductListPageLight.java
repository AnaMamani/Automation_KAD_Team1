package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */
public class ProductListPageLight extends ProductListPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//div[@class='slds-grid']//following::a[@title='Select List View']")
    private WebElement productItems;

    @FindBy(xpath = "//span[@class=' virtualAutocompleteOptionText' and contains(text(),'All Products')]")
    private WebElement selectOptionItems;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    /**
     * This method perform an action and create a new ProductFormPage.
     * @return a new ProductFormPage.
     */
    @Override
    public ProductFormPage clickNewProduct() {
        log.info("clickNewProduct: ----> action");
        driverTools.clickElement(newBtn);
        return new ProductFormPageLight();
    }

    /**
     * verify that a product is delete.
     *
     * @param product information the current user.
     * @return is successfully or not successfully.
     */
    @Override
    public boolean isSuccessDeleteProduct(Product product) {
        log.info("isSuccessDeleteProduct: ----> compare");
        return driverTools.isElementDisplayed(By.xpath("//table[@class]//child::a[contains(@title,'" + product.getProductName() + "')]"));
    }

    /**
     * Select the product Item.
     *
     * @param product
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage selectProductItem(Product product) {
        driverTools.clickElement(productItems);
        driverTools.clickElement(selectOptionItems);
        driverTools.clickElement(By.xpath("//a[@title='"+product.getProductName()+"']"));
        return new ProductDetailPageLight();
    }
}
