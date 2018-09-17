package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * ContactFormPageClassic class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactFormPageClassic extends ContactFormPage {



    @FindBy(id = "name_firstcon2")
    private WebElement firtsNameTxt;

    @FindBy(id = "name_lastcon2")
    private WebElement lastNameTxt;

    @FindBy(id = "con5")
    private WebElement titleTxt;

    @FindBy(id = "con15")
    private WebElement emailTxt;

    @FindBy(id = "con10")
    private WebElement phoneTxt;

    @FindBy(id = "con19street")
    private WebElement streetTxt;

    @FindBy(id = "con19city")
    private WebElement cityTxt;

    @FindBy(id = "con19state")
    private WebElement stateTxt;

    @FindBy(id = "con19country")
    private WebElement countryTxt;

    @FindBy(name = "save")
    private WebElement clickBtnSave;

    /**
     * Create contact.
     * @param contact of into.
     * @return button of save.
     */
    @Override
    public  ContactDetailPage createContact(Contact contact) {
        driverTools.setInputField(firtsNameTxt, contact.getFirstName());
        driverTools.setInputField(lastNameTxt, contact.getLastName());
        driverTools.setInputField(phoneTxt, contact.getPhone());
        driverTools.setInputField(titleTxt, contact.getTitle());
        driverTools.setInputField(emailTxt, contact.getEmail());
        driverTools.setInputField(streetTxt, contact.getStreet());
        driverTools.setInputField(cityTxt, contact.getCity());
        driverTools.setInputField(stateTxt, contact.getState());
        driverTools.setInputField(countryTxt, contact.getCountry());
        return  clickContactBtnSave();
    }
    /**
     * Save the information.
     * @return ContactDetailPage.
     */
    public ContactDetailPage clickContactBtnSave() {
        driverTools.clickElement(clickBtnSave);
        return new ContactDetailPageClassic();
    }

    @Override
    public ContactDetailPage editContact(Contact contact) {
        return createContact(contact);
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));
    }
}
