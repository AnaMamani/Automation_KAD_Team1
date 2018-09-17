package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListPageLight extends ProductListPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//*[@scope=\"row\"]")
    private WebElement productNameTxt;

    @FindBy(xpath = "//*[@class=\"slds-truncate uiOutputText\"]")
    private WebElement productCodeTxt;

    @FindBy(xpath = "//*[@class=\"slds-cell-edit lockTrigger cellContainer\"]")
    private WebElement productDescriptionTxt;

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
        return product.getProductName().equals(productNameTxt.getText().trim()) &&
                product.getProductCode().equals(productCodeTxt.getText().trim()) &&
                product.getProductDescription().equals(productDescriptionTxt.getText().trim());
    }
}
