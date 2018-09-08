package com.jalasoft.sfdc.ui.pages.contact;


import com.jalasoft.sfdc.ui.pages.ContactsFormPage.ContactsFormPage;
import com.jalasoft.sfdc.ui.pages.ContactsFormPage.ContactsFormPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactListPageClassic extends ContactListPage {

    //@FindBy(xpath = "//a[contains(text(),'Create New View')]")
    @FindBy(xpath = "//input[contains(@title,'New')]")

     WebElement contactsBtnNew;

    @Override
    public ContactListPage clickContactLink() {
        return new ContactListPageClassic();
    }

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

