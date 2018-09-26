package com.jalasoft.sfdc.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPriceBookPageLight extends ProductPriceBookPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//input[@title = 'Select']")
    private WebElement selectPriceBookBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(selectPriceBookBtn));
    }

    /**
     * @param standard it is the category of product.
     * @return the new ProductListPriceBook page.
     */
    @Override
    public ProductListPriceBook selectPriceBook(String standard) {
        log.info("selectPriceBook =====> " + standard + " return ProductListPriceBookLight");
        driverTools.clickElement(By.xpath("//input[@title = 'Select " + standard + "']"));
        driverTools.clickElement(selectPriceBookBtn);
        return new ProductListPriceBookLight();
    }
}
