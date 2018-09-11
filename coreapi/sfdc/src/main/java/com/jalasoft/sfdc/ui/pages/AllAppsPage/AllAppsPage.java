package com.jalasoft.sfdc.ui.pages.AllAppsPage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import org.openqa.selenium.By;

public abstract class AllAppsPage extends BasePage {

    /**
     * declared variable Contacts Light
     */
    By contactsLink;
    /**
     * declared variable  Price Books Links
     */
    By priceBooksLinks;

    public abstract ProductListPage clickProductLink();

    /**
     * Method for go to contacts page
     * @return ContactsListPage
     */
    public abstract ContactListPage clickContactLink();
    /**
     * Method for go to Price Books page
     * @return PriceBooks
     */
    public abstract PriceBooksPage clickPriceBooksLink();
}
