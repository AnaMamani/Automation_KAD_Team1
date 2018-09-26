package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import com.jalasoft.sfdc.ui.BasePage;
/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public abstract class QuotesFormPage extends BasePage {

    /**
     * for create a Quote
     * @return  QuotesDetailPage
     */
     public abstract QuotesDetailPage createQuote(String quoteName);
}
