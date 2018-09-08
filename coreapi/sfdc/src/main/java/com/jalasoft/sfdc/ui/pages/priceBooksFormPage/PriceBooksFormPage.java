package com.jalasoft.sfdc.ui.pages.priceBooksFormPage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.priceBooksDetailPage.PriceBooksDetailPage;

public abstract class PriceBooksFormPage extends BasePage {


    public abstract PriceBooksDetailPage insertPriceBooks(String priceBookName, String description);

    public abstract PriceBooksDetailPage clickBtnSave();
}
