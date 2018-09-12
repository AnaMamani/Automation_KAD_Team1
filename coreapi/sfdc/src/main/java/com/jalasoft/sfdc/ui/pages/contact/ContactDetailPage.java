package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.BasePage;
/**
 * ContactDetailPage class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public abstract class ContactDetailPage extends BasePage {
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    public abstract ContactDetailPage insertContact(Contact contact);

    public abstract  ContactDetailPage clickBtnSave();


}
