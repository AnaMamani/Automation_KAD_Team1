package com.jalasoft.sfdc.ui.pages.AllAppsPage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;

public abstract class AllAppsPage extends BasePage {

    public abstract ProductListPage clickProductLink();
    public abstract ContactListPage clickContactLink();

    /**
     *
     * @return
     */
    public abstract AccountListPage clickAccountsLink();
}
