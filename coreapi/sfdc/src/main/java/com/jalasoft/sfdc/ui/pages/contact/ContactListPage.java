package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.ContactsFormPage.ContactsFormPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;

public abstract class ContactListPage  extends BasePage {

    /**
     * method for definition a contactClassi and ContactsLight
     * @return a PageFactory
     */
    public ContactListPage clickContactLink(){
        return PageFactory.getHomeContacts();
    }

    public abstract ContactsFormPage clickLoginButtonNew();
}
