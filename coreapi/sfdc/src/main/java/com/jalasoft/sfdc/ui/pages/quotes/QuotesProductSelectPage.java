package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.ui.BasePage;
/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public abstract class QuotesProductSelectPage extends BasePage {
    /**
     * for select of product in quotes
     * @param productName String
     * @return QuotesAddItemsPage
     */
    public abstract QuotesAddItemsPage selectProductQuote(String productName);
}
