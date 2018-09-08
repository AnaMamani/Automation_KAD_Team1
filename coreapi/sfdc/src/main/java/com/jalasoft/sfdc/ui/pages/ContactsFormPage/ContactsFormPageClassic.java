package com.jalasoft.sfdc.ui.pages.ContactsFormPage;

import com.jalasoft.sfdc.ui.pages.contactDetailPage.ContactDetailPage;
import com.jalasoft.sfdc.ui.pages.contactDetailPage.ContactDetailPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsFormPageClassic extends ContactsFormPage {

    @FindBy(id = "name_firstcon2")
    WebElement firtsNameTxt;

    @FindBy(id = "name_lastcon2")
    WebElement lastNameTxt;


    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
    WebElement clickBtnSave;

    @Override
    public ContactsFormPage clickLoginButtonNew() {
        return new ContactsFormPageClassic();
    }

    public void setViewName(final String viewName) {
        driverTools.setInputField(firtsNameTxt, viewName);
    }
    public void setUniqueName(final String uniqueName) {
        driverTools.setInputField(lastNameTxt, uniqueName);
    }
    @Override
    public  ContactDetailPage insertContact(final String viewName, final String viewUniqueName) {
        setViewName(viewName);
        setUniqueName(viewUniqueName);
        return new ContactDetailPageClassic();
    }

    @Override
    public ContactDetailPage clickBtnSave() {
        driverTools.clickElement(clickBtnSave);
        return new ContactDetailPageClassic();
    }

}
