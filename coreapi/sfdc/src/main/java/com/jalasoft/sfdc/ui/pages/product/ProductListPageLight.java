package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.pages.productFormPage.ProductFormPage;
import com.jalasoft.sfdc.ui.pages.productFormPage.ProductFormPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPageLight extends ProductListPage {
    @FindBy(xpath = "//a[@title='New']")
    WebElement productNewLink;

    @Override
    public ProductFormPage clickNewProduct() {
        driverTools.clickElement(productNewLink);
        return new ProductFormPageLight();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}
