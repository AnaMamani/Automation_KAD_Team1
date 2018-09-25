package com.jalasoft.sfdc.ui.pages.priceBooks;

import com.jalasoft.sfdc.ui.ListBasePage;

public  abstract class PriceBookListPage extends ListBasePage {

    /**
     * This method perform an action and create a new PriceFormPage.
     * @return a new PriceFormPage.
     */
    public abstract PriceFormPage clickNewPriceBook();
}
