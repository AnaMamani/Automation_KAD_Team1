package com.jalasoft.sfdc.ui.pages.allAppsPage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;

public abstract class AllAppsPage extends BasePage {

    public abstract ProductListPage clickProductLink();

    public abstract ContactListPage clickContactLink();

    public abstract PriceBooksListPage clickPriceBooksLink();
}
