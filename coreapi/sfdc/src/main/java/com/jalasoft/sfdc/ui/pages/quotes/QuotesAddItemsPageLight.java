package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.entities.QuotesLineItem;

/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class QuotesAddItemsPageLight extends QuotesAddItemsPage {
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
    public QuotesDetailPage addPriceBook(QuotesLineItem quote) {
        return null;
    }
}
