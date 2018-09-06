package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;

public abstract class AllAppsPage extends BasePage {

    public abstract ProductListPage clickProductLink();
    public abstract ContactListPage clickContactLink();
}
