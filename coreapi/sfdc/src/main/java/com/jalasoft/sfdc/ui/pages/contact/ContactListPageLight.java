package com.jalasoft.sfdc.ui.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPageLight extends ContactListPage {
    @FindBy(xpath = "//a[@title='New']")
    WebElement contactsBtnNew;
    @Override
    public ContactsFormPage clickLoginButtonNew() {
        driverTools.clickElement(contactsBtnNew);
        return new ContactsFormPageLight();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
