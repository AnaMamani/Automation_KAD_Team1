package com.jalasoft.sfdc.ui.pages.priceBooks;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class PriceFormPage extends BasePage {

    /**
     * This method perform an action of setting and create a new PriceBookDetails.
     * @param priceBookName name.
     * @param description text.
     * @return a new PriceBookDetails.
     */
    public abstract PriceBookDetails goToFillPriceBook(String priceBookName, String description);
}
