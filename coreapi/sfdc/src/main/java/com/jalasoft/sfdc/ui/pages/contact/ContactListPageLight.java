package com.jalasoft.sfdc.ui.pages.contact;

import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * ContactListPageLight class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactListPageLight extends ContactListPage {


    /**
     * Methos for the button new.
     * @return ContactFormPage.
     */
    @Override
    public ContactFormPage clickContactNew() {
        driverTools.clickElement(newBtn);
        return new ContactFormPageLight();
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
