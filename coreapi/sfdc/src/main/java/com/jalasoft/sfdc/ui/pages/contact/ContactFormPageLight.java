package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * ContactFormPageLight class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactFormPageLight extends ContactFormPage {
    @FindBy(xpath = "//span[text()='First Name']/parent::label/following-sibling::input")
    private WebElement firtsNameTxt;

    @FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::input")
    private WebElement lastNameTxt;

    @FindBy(xpath = "//span[text()='Title']/parent::label/following-sibling::input")
    private WebElement titleTxt;

    @FindBy(xpath = "//span[text()='Email']/parent::label/following-sibling::input")
    private WebElement emailTxt;

    @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    private WebElement phoneTxt;

    @FindBy(xpath = "//span[text()='Other Street']/parent::label/following-sibling::TextArea")
    private WebElement streetTxt;

    @FindBy(xpath = "//span[text()='Other City']/parent::label/following-sibling::input")
    private WebElement cityTxt;

    @FindBy(xpath = "//span[text()='Other State/Province']/parent::label/following-sibling::input")
    private WebElement stateTxt;

    @FindBy(xpath = "//span[text()='Other Country']/parent::label/following-sibling::input")
    private WebElement countryTxt;

    @FindBy(xpath = "//button[@title='Save']//span[contains(@class,'label bBody')][contains(text(),'Save')]")
    private WebElement clickBtnSave;

    @FindBy(xpath = "//a[@title='New Contact']")
    private WebElement auxToContactId;

    /**
     * Method for create contatc.
     *
     * @param contact of into.
     * @return button of save.
     */
    @Override
    public ContactDetailPage createContact(Contact contact) {
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
        return new ContactDetailPageLight();
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

    /**
     * For edit contact.
     *
     * @param contact review
     * @return ContactDetailPage
     */
    @Override
    public ContactDetailPage editContact(Contact contact) {
        if (contact.getFirstName() != null)
            driverTools.setInputField(firtsNameTxt, contact.getFirstName());
        if (contact.getLastName() != null)
            driverTools.setInputField(lastNameTxt, contact.getLastName());
        if (contact.getPhone() != null)
            driverTools.setInputField(phoneTxt, contact.getPhone());
        if (contact.getTitle() != null)
            driverTools.setInputField(titleTxt, contact.getTitle());
        if (contact.getEmail() != null)
            driverTools.setInputField(emailTxt, contact.getEmail());
        if (contact.getStreet() != null)
            driverTools.setInputField(streetTxt, contact.getStreet());
        if (contact.getCity() != null)
            driverTools.setInputField(cityTxt, contact.getCity());
        if (contact.getState() != null)
            driverTools.setInputField(stateTxt, contact.getState());
        if (contact.getCountry() != null)
            driverTools.setInputField(countryTxt, contact.getCountry());
        driverTools.clickElement(clickBtnSave);
        driverTools.invisibilityElement(clickBtnSave);
        return new ContactDetailPageLight();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));
    }
}
