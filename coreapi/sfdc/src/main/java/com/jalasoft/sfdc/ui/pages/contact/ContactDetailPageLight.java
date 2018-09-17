package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ContactDetailPageLight class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactDetailPageLight extends ContactDetailPage {

    @FindBy(xpath = "(//div[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon' ]//parent::span)[1]")
    private WebElement contactCreated;

    @FindBy(xpath = "//a[contains(@title,'Show 5 more actions')]")
    private WebElement clickCmbBox;
    @FindBy(xpath = "//a[@title='Edit']")
    private WebElement clickOptionEdit;
    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement clickOptionDelete;
    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement messageVerifyDelete;


    /**
     * For show create contact in ContactDetail.
     *
     * @return String.
     */
    @Override
    public String isSuccessDisplayedContactDetail() {
        System.out.print(contactCreated.getText() + "#####################################################");
        return contactCreated.getText().trim();
    }

    /**
     * Edit contact of contact detail.
     *
     * @return ContactFormPage.
     */
    @Override
    public ContactFormPage clickInEdit() {
        driverTools.clickElement(clickCmbBox);
        driverTools.clickElement(clickOptionEdit);
        return new ContactFormPageLight();
    }


    /**
     * Delete Contact of contact detail.
     *
     * @return ContactListPage.
     */
    @Override
    public ContactListPage deleteContact() {
        driverTools.clickElement(clickCmbBox);
        driverTools.clickElement(clickOptionDelete);
        driverTools.clickElement(messageVerifyDelete);
        return new ContactListPageLight();
    }

}
