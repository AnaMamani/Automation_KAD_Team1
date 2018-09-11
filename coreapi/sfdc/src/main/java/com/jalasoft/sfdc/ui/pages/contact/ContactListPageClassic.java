package com.jalasoft.sfdc.ui.pages.contact;

public class ContactListPageClassic extends ContactListPage {


    @Override
    public ContactListPage clickContactLink() {
        return new ContactListPageClassic();
    }
}

