package com.jalasoft.sfdc.ui.pages.priceBooksFormPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceFormPageClassic extends PriceFormPage {
    @FindBy(xpath = "//input[@id='Name']")
    WebElement priceBooksNameText;

    @FindBy(xpath = "//input[@id='Description']")
    WebElement priceBooksDescritionText;

    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
    WebElement clickSave;

    @Override
    public PriceBooksDetails goToFillPriceBooks(String priceBookName, String description) {
        driverTools.setInputField(priceBooksNameText, priceBookName);
        driverTools.setInputField(priceBooksDescritionText, description);
        driverTools.clickElement(clickSave);
        return new PriceBooksDetailsClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(priceBooksDescritionText));

    }
}
