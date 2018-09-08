package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.pages.ContactsFormPage.ContactsFormPage;

public class ContactListPageLight extends ContactListPage {
    @Override
    public ContactListPage clickContactLink() {
        return new ContactListPageLight();
    }

    @Override
    public ContactsFormPage clickLoginButtonNew() {
        return null;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
