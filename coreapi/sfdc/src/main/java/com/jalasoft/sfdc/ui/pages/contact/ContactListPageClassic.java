package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * ContactListPageClassic class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactListPageClassic extends ContactListPage {

    /**
     * Method for the button new.
     * @return ContactFormPage.
     */
    @Override
    public ContactFormPage clickContactNew() {
        driverTools.clickElement(newBtn);
        return new ContactFormPageClassic();

    }

    /**
     * Verify contact search in page.
     *
     * @param contact
     * @return a PageFactory
     */
    @Override
    public boolean isSuccessDeleteContact(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath("//*[contains(text(),'"+contact.getFirstName()+"')]"));
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

