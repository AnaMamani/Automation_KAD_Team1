package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.entities.QuotesLineItem;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class QuotesAddItemsPageClassic extends QuotesAddItemsPage {

    @FindBy(xpath = "//input[contains(@id,'UnitPrice')]")
    private WebElement quoteSalesPrice;
    @FindBy(xpath = "//input[contains(@id,'Quantity')]")
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
     * @param quotesLineItem
     * @return
     */
    @Override
    public QuotesDetailPage addPriceBook(QuotesLineItem quotesLineItem) {
        driverTools.setInputField(quoteSalesPrice, quotesLineItem.getSalesPrice());
        driverTools.setInputField(quoteQuantity, quotesLineItem.getQuantity());
        driverTools.clickElement(saveBtn);
        return new QuotesDetailPageClassic();
    }
}
