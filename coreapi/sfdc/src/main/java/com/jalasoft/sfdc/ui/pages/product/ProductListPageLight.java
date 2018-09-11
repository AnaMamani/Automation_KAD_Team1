package com.jalasoft.sfdc.ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListPageLight extends ProductListPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//a[@title='New']")
    WebElement productNewLink;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productNewLink));
    }

    /**
     * This method perform an action and create a new ProductFormPage.
     * @return a new ProductFormPage.
     */
    @Override
    public ProductFormPage clickNewProduct() {
        driverTools.clickElement(productNewLink);
        return new ProductFormPageLight();
    }
}
