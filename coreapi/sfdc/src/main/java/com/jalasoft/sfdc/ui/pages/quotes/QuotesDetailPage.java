package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.ui.BasePage;
/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public abstract class QuotesDetailPage extends BasePage {
    /**
     * For add line Item
     * @return QuoteLineItemPage
     */
    public abstract QuoteLineItemsPage clickAddLineItem();
}
