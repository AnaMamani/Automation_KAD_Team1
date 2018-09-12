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
    WebElement firtsNameTxt;

    @FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::input")
    WebElement lastNameTxt;

    @FindBy(xpath = "//span[text()=\"Title\"]/parent::label/following-sibling::input")
    WebElement titleTxt;

    @FindBy(xpath = "//span[text()=\"Email\"]/parent::label/following-sibling::input")
    WebElement emailTxt;

    @FindBy(xpath = "//span[text()=\"Phone\"]/parent::label/following-sibling::input")
    WebElement phoneTxt;

    @FindBy(xpath = "//span[text()=\"Other Street\"]/parent::label/following-sibling::TextArea")
    WebElement streetTxt;

    @FindBy(xpath = "//span[text()=\"Other City\"]/parent::label/following-sibling::input")
    WebElement cityTxt;

    @FindBy(xpath = "//span[text()=\"Other State/Province\"]/parent::label/following-sibling::input")
    WebElement stateTxt;

    @FindBy(xpath = "//span[text()=\"Other Country\"]/parent::label/following-sibling::input")
    WebElement countryTxt;

    @FindBy(xpath = "//button[@title='Save']//span[contains(@class,'label bBody')][contains(text(),'Save')]")
    WebElement clickBtnSave;


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
        driverTools.scrollDown(5);
        driverTools.setInputField(titleTxt, contact.getTitle());
        driverTools.setInputField(emailTxt, contact.getEmail());
        driverTools.setInputField(streetTxt, contact.getStreet());
        driverTools.setInputField(cityTxt, contact.getCity());
        driverTools.setInputField(stateTxt, contact.getState());
        driverTools.setInputField(countryTxt, contact.getCountry());
        return clickContactBtnSave();
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
