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


    /**
     * Method for create contatc.
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
        return clickContactBtnSave();
    }

    /**
     * For edit contact.
     *
     * @param contact review
     * @return ContactDetailPage
     */
    @Override
    public ContactDetailPage editContact(Contact contact) {
        return createContact(contact);
    }


    /**
     * Method for save the information.
     * @return ContactDetailPageLight.
     */
    public ContactDetailPage clickContactBtnSave() {
        driverTools.clickElement(clickBtnSave);
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
