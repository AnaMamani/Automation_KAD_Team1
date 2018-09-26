package com.jalasoft.sfdc.ui.pages.quotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class QuotesDetailPageClassic extends QuotesDetailPage {

    @FindBy(xpath = "//input[contains(@title,'Add Line Item')]")
    private WebElement clickAddLineItem;
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

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
}
