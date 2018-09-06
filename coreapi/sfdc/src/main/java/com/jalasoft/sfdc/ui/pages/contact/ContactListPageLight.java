package com.jalasoft.sfdc.ui.pages.contact;

public class ContactListPageLight extends ContactListPage {
    @Override
    public ContactListPage clickContactLink() {
        return new ContactListPageLight();
    }
}
