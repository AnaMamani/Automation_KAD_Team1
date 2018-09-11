package com.jalasoft.sfdc.ui.pages.priceBooks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceBookListPageClassic extends PriceBookListPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//input[@title='New']")
    WebElement priceBookNewLink;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(priceBookNewLink));
    }

    /**
     * This method perform an action and create a new PriceFormPage.
     * @return a new PriceFormPage.
     */
    @Override
    public PriceFormPage clickNewPriceBook() {
        driverTools.clickElement(priceBookNewLink);
        return new PriceFormPageClassic();
    }
}
