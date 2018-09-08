package com.jalasoft.sfdc.ui.pages.priceBooksFormPage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceFormPageLigth extends PriceFormPage {
    @FindBy(xpath = "//input[@id='7:1554;a']")
    WebElement priceBooksNameText;

    @FindBy(xpath = "//input[@id='43:1519;a']")
    WebElement priceBooksDescritionText;

    @FindBy(xpath = "//button[@title='Save']//span[contains(@class,'label bBody')][contains(text(),'Save')]")
    WebElement clickSave;

    @Override
    public PriceBooksDetails goToFillPriceBooks(String priceBookName, String description) {
        driverTools.setInputField(priceBooksNameText, priceBookName);
        driverTools.setInputField(priceBooksDescritionText, description);
        driverTools.clickElement(clickSave);
        return new PriceBooksDetailsLigth();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(priceBooksDescritionText));

    }
}
