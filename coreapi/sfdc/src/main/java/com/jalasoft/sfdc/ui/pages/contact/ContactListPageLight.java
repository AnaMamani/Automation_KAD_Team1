package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * ContactListPageLight class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactListPageLight extends ContactListPage {



    /**
     * Method for the button new.
     * @return ContactFormPage.
     */
    @Override
    public ContactFormPage clickContactNew() {
        driverTools.clickElement(newBtn);
        return new ContactFormPageLight();
    }

    @Override
    public ContactDetailPage selectContact(String firstName) {
        return null;
    }

    @Override
    public boolean contactSearch(Contact contact) {
        return false;
    }

    /**
     *  Waits until page object is loaded.
     * {@inheritDoc}
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }
}
