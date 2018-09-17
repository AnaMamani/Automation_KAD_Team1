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

    @FindBy(xpath = "//a[@title='Show 5 more actions']//lightning-primitive-icon")
    private WebElement clickAction;

    //@FindBy(xpath = "div[title='Delete']")
    //private WebElement clickBtnDelete;
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
        return null;
    }


    /**
     * Delete Contact of contact detail.
     *
     * @return ContactListPage.
     */
    @Override
    public ContactListPage deleteContact() {
        driverTools.clickElement(clickAction);
        //driverTools.clickElement(clickBtnDelete);
        //driverTools.clickElement(optionTypeCmbBox);
        driverTools.clickElement(By.xpath(("//*[@title='Delete']/parent::a)[1]")));
        return new ContactListPageLight();
    }


}
