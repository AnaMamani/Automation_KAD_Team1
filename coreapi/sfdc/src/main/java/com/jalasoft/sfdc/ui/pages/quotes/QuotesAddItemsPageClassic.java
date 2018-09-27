package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class QuotesAddItemsPageClassic extends QuotesAddItemsPage {

    @FindBy(xpath = "//input[@id='UnitPrice01u0b00001qyiMQ']")
    private WebElement quoteSalesPrice;
    @FindBy(xpath = "//input[@id='Quantity01u0b00001qyiMQ']")
    private WebElement quoteQuantity;
    @FindBy(xpath = "(//input[@value=' Save '])[1]")
    private WebElement saveBtn;
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * for calculate for data
     *
     * @param quote
     * @return
     */
    @Override
    public QuotesDetailPage addPriceBook(Quote quote) {
        driverTools.setInputField(quoteSalesPrice, quote.getSalesPrice());
        driverTools.setInputField(quoteQuantity, quote.getQuantity());
        driverTools.clickElement(saveBtn);
        return new QuotesDetailPageClassic();
    }
}
