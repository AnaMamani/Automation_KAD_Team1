package com.jalasoft.sfdc.ui.pages.ContactsFormPage;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.contactDetailPage.ContactDetailPage;

public abstract class ContactsFormPage extends BasePage {

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    public abstract ContactsFormPage clickLoginButtonNew();
    public abstract ContactDetailPage insertContact( String viewName,  String viewUniqueName);
    public abstract ContactDetailPage clickBtnSave();


}
