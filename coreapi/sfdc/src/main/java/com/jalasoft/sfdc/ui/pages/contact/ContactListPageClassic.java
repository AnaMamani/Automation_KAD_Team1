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
     * Methos for the button new.
     * @return ContactFormPage.
     */
    @Override
    public ContactFormPage clickContactNew() {
        driverTools.clickElement(newBtn);
        return new ContactFormPageClassic();

    }

    @Override
    public ContactDetailPage selectContact(String firstName) {
        String locatorNameLink = "//*[contains(text(), '" + firstName + "')]";
        driverTools.clickElement(By.xpath(locatorNameLink));
        return new ContactDetailPageClassic();
    }

    @Override
    public boolean contactSearch(Contact contact) {

        try {
            driver.findElement(By.xpath("//*[contains(text(), '" + contact.getFirstName() + "')]"));
            return false;
        } catch (Exception e) {
            return true;
        }

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

