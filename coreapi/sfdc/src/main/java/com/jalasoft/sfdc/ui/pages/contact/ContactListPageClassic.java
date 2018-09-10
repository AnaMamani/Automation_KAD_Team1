package com.jalasoft.sfdc.ui.pages.contact;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPageClassic extends ContactListPage {

    @FindBy(xpath = "//input[@title='New']")
    WebElement contactsBtnNew;


    @Override
    public ContactsFormPage clickLoginButtonNew() {
        //wait.until(ExpectedConditions.visibilityOf(contactsBtnNew));
        System.out.println(contactsBtnNew);
        driverTools.clickElement(contactsBtnNew);
        return new ContactsFormPageClassic();

    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}

