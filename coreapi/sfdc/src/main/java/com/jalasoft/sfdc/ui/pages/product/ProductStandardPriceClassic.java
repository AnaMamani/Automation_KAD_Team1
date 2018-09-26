package com.jalasoft.sfdc.ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductStandardPriceClassic extends ProductStandardPrice {

    @FindBy(xpath = "//input[@title='Unit Price']")
    private WebElement priceFieldTxt;

    @FindBy(xpath = "//*[@title='Save']")
    private WebElement savePriceBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(priceFieldTxt));
    }

    /**
     * @param price price.
     * @return the new Product Detail Page.
     */
    @Override
    public ProductDetailPage addPrice(String price) {
        log.info("addPrice ====> " + price);
        driverTools.setInputField(priceFieldTxt, price);
        driverTools.clickElement(savePriceBtn);
        return new ProductDetailPageClassic();
    }
}
