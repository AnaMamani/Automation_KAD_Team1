package com.jalasoft.sfdc.ui.pages.priceBooks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceFormPageClassic extends PriceFormPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//input[@id='Name']")
    WebElement priceBooksNameText;

    @FindBy(xpath = "//input[@id='Description']")
    WebElement priceBooksDescritionText;

    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
    WebElement clickSave;

    /**
     * This method perform an action of setting and create a new PriceBookDetails.
     * @param priceBookName name.
     * @param description text.
     * @return a new PriceBookDetails.
     */
    @Override
    public PriceBookDetails goToFillPriceBook(String priceBookName, String description) {
        driverTools.setInputField(priceBooksNameText, priceBookName);
        driverTools.setInputField(priceBooksDescritionText, description);
        driverTools.clickElement(clickSave);
        return new PriceBookDetailsClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(priceBooksDescritionText));

    }
}
