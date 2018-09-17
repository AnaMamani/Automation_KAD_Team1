package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;

/**
 * ContactDetailPageClassic class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactDetailPageClassic extends ContactDetailPage {

    @FindBy(xpath = "//*[@class='topName']")
    private WebElement contactCreated;
    @FindBy(xpath = "//*[@title='Edit']")
    private WebElement clickBtnEdit;
    @FindBy(xpath = "div[title='Delete']")
    private WebElement clickBtnDelete;

    /**
     * For show create contact in ContactDetail.
     *
     * @return String.
     */
    @Override
    public String isSuccessDisplayedContactDetail() {
        System.out.print(contactCreated.getText()+ "#####################################################");
        return contactCreated.getText().trim();
    }

    /**
     * Edit contact of contact detail.
     *
     * @return ContactFormPage.
     */
    @Override
    public ContactFormPage clickInEdit() {
        driverTools.clickElement(clickBtnEdit);
        return new ContactFormPageClassic();
    }


    /**
     * Delete Contact of contact detail.
     *
     * @return ContactListPage.
     */
    @Override
    public ContactListPage deleteContact() {
        driverTools.clickElement(clickBtnDelete);
        clickConfirmDeleteButton();
        return new ContactListPageClassic();
    }

    public void clickConfirmDeleteButton() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
