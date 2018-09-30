package com.jalasoft.sfdc.ui.pages.priceBooks;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class priceFormPageLight extends PriceFormPage {
    //PageFactory of selenium.
    @FindBy(xpath = "(//div[@class='slds-form-element__control']//child::input[@class=' input'])[1]")
    WebElement priceBookNameText;

    @FindBy(xpath = "(//div[@class='slds-form-element__control']//child::input[@class=' input'])[2]")
    WebElement priceBookDescriptionText;

    @FindBy(xpath = "//button[@title='Save']//span[contains(@class,'label bBody')][contains(text(),'Save')]")
    WebElement clickSaveBtn;

    /**
     * This method perform an action of setting and create a new PriceBookDetails.
     * @param priceBookName name.
     * @param description text.
     * @return a new PriceBookDetails.
     */
    @Override
    public PriceBookDetails goToFillPriceBook(String priceBookName, String description) {
        driverTools.setInputField(priceBookNameText, priceBookName);
        driverTools.setInputField(priceBookDescriptionText, description);
        driverTools.clickElement(clickSaveBtn);
        return new PriceBookDetailsLigth();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(priceBookDescriptionText));
    }
}
