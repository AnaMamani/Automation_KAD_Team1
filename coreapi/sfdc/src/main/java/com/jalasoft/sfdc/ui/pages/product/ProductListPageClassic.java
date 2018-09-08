package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.pages.productFormPage.ProductFormPage;
import com.jalasoft.sfdc.ui.pages.productFormPage.ProductFormPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductListPageClassic extends ProductListPage {
    @FindBy(xpath = "//input[@title=\"New\"]")
    WebElement productNewLink;

    @Override
    public ProductFormPage clickNewProduct() {
        wait.until(ExpectedConditions.visibilityOf(productNewLink));
        driverTools.clickElement(productNewLink);
        return new ProductFormPageClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
