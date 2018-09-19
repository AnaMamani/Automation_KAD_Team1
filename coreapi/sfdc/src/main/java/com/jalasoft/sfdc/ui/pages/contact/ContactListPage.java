package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.ListBasePage;

/**
 * ContactListPage class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public abstract class ContactListPage extends ListBasePage {


    /**
     * Contact click for go  ContactFormPage.
     *
     * @return a PageFactory
     */
    public abstract ContactFormPage clickContactNew();

    /**
     * Verify contact search in page.
     *
     * @return a PageFactory
     */
    public abstract boolean contactSearch(Contact contact);
}
