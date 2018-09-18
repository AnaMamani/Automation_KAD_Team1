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


    /**
     * For show create contact in ContactDetail.
     * @return String.
     */
    public abstract String isSuccessDisplayedContactDetail();

    /**
     * Edit contact of contact detail.
     * @return ContactFormPage.
     */
    public abstract ContactFormPage clickEditOption();

    /**
     * Delete Contact of contact detail.
     * @return ContactListPage.
     */
    public abstract ContactListPage deleteContact();
    /**
     * For show update contact in ContactDetail.
     * @return String.
     */
    public abstract String isSuccessDisplayedContactDetailUpdate();
}
