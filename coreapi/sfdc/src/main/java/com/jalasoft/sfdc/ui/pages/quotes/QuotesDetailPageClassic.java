package com.jalasoft.sfdc.ui.pages.quotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class QuotesDetailPageClassic extends QuotesDetailPage {

    @FindBy(xpath = "//input[contains(@title,'Add Line Item')]")
    private WebElement clickAddLineItem;

    @FindBy(xpath = "//h2[@class='pageDescription']")
    private WebElement quoteCreatedName;
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickAddLineItem));
    }

    /**
     * For add line Item
     *
     * @return QuoteLineItemPage
     */
    @Override
    public QuoteLineItemsPage clickAddLineItem() {
        driverTools.clickElement(clickAddLineItem);
        return new QuoteLineItemsPageClassic();
    }

    /**
     * validate data of Quotes
     *
     * @return String
     */
    @Override
    public String isSuccessDisplayedQuoteDetail() {
        System.out.print(quoteCreatedName.getText()+ "#####################################################");
        return quoteCreatedName.getText().trim();
    }
}
