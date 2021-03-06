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

    @FindBy(xpath = "//*[@class='topName']")
    private WebElement auxToContactId;

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
        driverTools.clickElement(clickBtnSave);
        wait.until(ExpectedConditions.visibilityOf(auxToContactId));
        saveContactId(driver.getCurrentUrl(),contact);
        return new ContactDetailPageClassic();
    }
    /**
     * @param currentUrl url.
     * @param contact product.
     */
    private void saveContactId(String currentUrl, Contact contact) {
        String[] url=currentUrl.split("/");
        contact.setId(url[url.length-1]);
        System.out.println("ID: "+contact.getId()+" THIS IS THE CONTACT ID");
    }
    @Override
    public ContactDetailPage editContact(Contact contact)
    {
        if (contact.getFirstName()!=null)
            driverTools.setInputField(firtsNameTxt,contact.getFirstName());
        if (contact.getLastName()!=null)
            driverTools.setInputField(lastNameTxt,contact.getLastName());
        if (contact.getPhone()!=null)
            driverTools.setInputField(phoneTxt,contact.getPhone());
        if (contact.getTitle()!=null)
            driverTools.setInputField(titleTxt,contact.getTitle());
        if (contact.getEmail()!=null)
            driverTools.setInputField(emailTxt,contact.getEmail());
        if (contact.getStreet()!=null)
            driverTools.setInputField(streetTxt,contact.getStreet());
        if (contact.getCity()!=null)
            driverTools.setInputField(cityTxt,contact.getCity());
        if (contact.getState()!=null)
            driverTools.setInputField(stateTxt,contact.getState());
        if (contact.getCountry()!=null)
            driverTools.setInputField(countryTxt,contact.getCountry());
        driverTools.clickElement(clickBtnSave);
        return new ContactDetailPageClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));
    }
}
