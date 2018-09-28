package com.jalasoft.sfdc.ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/18/2018
 */
public class ProductListPriceBookClassic extends ProductListPriceBook {
    //PageFactory of selenium.
    @FindBy(id = "td0_8")
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
     * @param price it is the price of product.
     * @return the new ProductDetailPage page.
     */
    @Override
    public ProductDetailPage addPriceBook(String price) {
        log.info("addPriceBook ====> "+price);
        driverTools.setInputField(priceFieldTxt,price);
        driverTools.clickElement(savePriceBtn);
        return new ProductDetailPageClassic();
    }
}
