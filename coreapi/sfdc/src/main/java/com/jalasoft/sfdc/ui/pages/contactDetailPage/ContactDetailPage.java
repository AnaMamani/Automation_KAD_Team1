package com.jalasoft.sfdc.ui.pages.contactDetailPage;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class ContactDetailPage extends BasePage {
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public abstract ContactDetailPage insertContact(final String viewName, final String viewUniqueName);
    public abstract  ContactDetailPage clickBtnSave();


}
