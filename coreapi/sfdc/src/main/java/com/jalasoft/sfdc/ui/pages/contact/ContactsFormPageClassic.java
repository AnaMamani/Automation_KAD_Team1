package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsFormPageClassic extends ContactsFormPage {



    @FindBy(xpath = "//input[@id='name_firstcon2']")
    WebElement firtsNameTxt;

    @FindBy(xpath = "//input[@id='name_lastcon2']")
    WebElement lastNameTxt;

    //@FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div")
    //WebElement accountNameTxt;

    @FindBy(xpath = "//input[@id='con5']")
    WebElement titleTxt;

    @FindBy(xpath = "//input[@id='con15']")
    WebElement emailTxt;

    @FindBy(xpath = "//input[@id='con10']")
    WebElement phoneTxt;

    @FindBy(xpath = "//textarea[@id='con19street']")
    WebElement streetTxt;

    @FindBy(xpath = "//input[@id='con19city']")
    WebElement cityTxt;

    @FindBy(xpath = "//input[@id='con19state']")
    WebElement stateTxt;

    @FindBy(xpath = "//input[@id='con19country']")
    WebElement countryTxt;

    @FindBy(name = "save")
    WebElement clickBtnSave;


    @Override
    public  ContactDetailPage insertContact(Contact contact) {
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
        return new ContactDetailPageClassic();
    }

    @Override
    public ContactDetailPage clickBtnSave() {
        driverTools.clickElement(clickBtnSave);
        return new ContactDetailPageClassic();
    }

}
