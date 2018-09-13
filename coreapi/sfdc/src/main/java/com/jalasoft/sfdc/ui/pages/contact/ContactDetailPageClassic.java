package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
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
     * For show create contact in ContactFormPage.
     *
     * @return ContactFormPage.
     */
    @Override
    public ContactFormPage clickBtnEditContact() {
        driverTools.clickElement(clickBtnEdit);
        System.out.print("munos***************************************************");
        return new ContactFormPageClassic();
    }
}
