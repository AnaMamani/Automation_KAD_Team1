package com.jalasoft.sfdc.ui.pages.allAppsPage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;

/**
 * Product All Apps Page class.
 * @author Denis Camacho.
 * @author Ketty Camacho.
 * @author Ana Mamani.
 * @since 9/18/2018
 */
public abstract class AllAppsPage extends BasePage {

    /**
     * Click ProductList Link.
     * @return ProductListPage.
     */
    public abstract ProductListPage clickProductLink();

    /**
     * Click ContactList Link.
     * @return ContactListPage.
     */
    public abstract ContactListPage clickContactLink();
    /**
     * Click Price Books Link.
     * @return PriceBookListPage.
     */
    public abstract PriceBookListPage clickPriceBookLink();

    /**
     * click Account List PAge.
     * @return AccountListPage.
     */
    public abstract AccountListPage clickAccountsLink();

    public abstract OpportunitiesListPage clickOpportunities();
}
