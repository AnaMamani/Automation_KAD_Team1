package com.jalasoft.sfdc.ui.pages.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class QuoteLineItemsPageClassic extends QuoteLineItemsPage {

    @FindBy(xpath = "//select[contains(@id,'p1')]")
    private WebElement selectCombxItem;

    @FindBy(xpath = "//option[@selected='selected'][contains(.,'Standard')]")
    private WebElement standardPriceBook ;

    @FindBy(xpath = "//input[@title='Save']")
    private WebElement saveBtnItem ;
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(saveBtnItem));
    }

    /**
     * selected preci book in quote items
     *
     * @param selectStandard for String
     * @return QuotesAddItemsPage
     */
    @Override
    public QuotesProductSelectPage selectPriceBook(String selectStandard) {
        driverTools.clickElement(selectCombxItem);
        driverTools.clickElement(By.xpath("//option[contains(.,'"+selectStandard+"')]"));
        driverTools.clickElement(saveBtnItem);
        return new QuotesProductSelectPageClassic();
    }
}
