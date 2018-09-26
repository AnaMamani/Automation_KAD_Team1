package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.ui.BasePage;
/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public abstract class QuoteLineItemsPage extends BasePage {
    /**
     * selected preci book in quote items
     * @param selectStandard for String
     * @return QuotesAddItemsPage
     */
    public abstract QuotesProductSelectPage selectPriceBook(String selectStandard);
}
