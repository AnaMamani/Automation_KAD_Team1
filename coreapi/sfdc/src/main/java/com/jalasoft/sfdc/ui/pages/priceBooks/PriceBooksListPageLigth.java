package com.jalasoft.sfdc.ui.pages.priceBooks;

import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceFormPage;
import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceFormPageLigth;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PriceBooksListPageLigth extends PriceBooksListPage {
    @FindBy(xpath = "//div[@title='New']")
    WebElement priceBooksNewLink;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(priceBooksNewLink));
    }

    @Override
    public PriceFormPage clickNewPriceBooks() {
        driverTools.clickElement(priceBooksNewLink);
        return new PriceFormPageLigth();
    }
}
