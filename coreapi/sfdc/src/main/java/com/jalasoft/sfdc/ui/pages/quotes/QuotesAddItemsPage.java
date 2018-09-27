package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.QuotesLineItem;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public abstract class QuotesAddItemsPage extends BasePage {

    /**
     * for calculate for data
     *
     * @param quote
     * @return
     */
    public abstract QuotesDetailPage addPriceBook(QuotesLineItem quote);
}
