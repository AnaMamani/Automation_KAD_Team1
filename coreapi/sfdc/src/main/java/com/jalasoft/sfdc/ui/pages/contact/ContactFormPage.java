package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * ContactFormPage class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public abstract class ContactFormPage extends BasePage {

    /**
     * Create contacts.
     *
     * @param contact of into.
     * @return ContactDetailPage.
     */
    public abstract ContactDetailPage createContact(Contact contact);

    /**
     * For edit contact.
     *
     * @param contact review
     * @return ContactDetailPage
     */
    public abstract ContactDetailPage editContact(Contact contact);
}
