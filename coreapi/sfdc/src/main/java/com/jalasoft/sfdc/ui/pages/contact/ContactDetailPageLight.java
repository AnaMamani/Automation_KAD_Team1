package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    @FindBy(css = "[title='Details']")
    protected WebElement detailsLinkBtn;
    //for validate
    @FindBy(xpath = "//span[contains(text(), 'Name')]/parent::div/following-sibling::div/span/span")
    private WebElement nameTxt;
    @FindBy(xpath = "//span[contains(text(), 'Title')]/parent::div/following-sibling::div/span/span")
    private WebElement titleText;
    @FindBy(xpath = "//span[contains(text(), 'Phone')]/parent::div/following-sibling::div/span/span")
    private WebElement phoneTxt;
    @FindBy(xpath = "//span[contains(text(), 'Email')]/parent::div/following-sibling::div/span/span/a")
    private WebElement emailTxt;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(detailsLinkBtn));
    }

    /**
     * For show create contact in ContactDetail.
     *
     * @return String.
     */
    @Override
    public String isSuccessDisplayedContactDetail() {
        return contactCreated.getText().trim();
    }

    /**
     * Edit contact of contact detail.
     *
     * @return ContactFormPage.
     */
    @Override
    public ContactFormPage clickEditOption() {
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

    /**
     * Validate with detail.
     *
     * @param contact
     */
    @Override
    public boolean isSuccessEditContact(Contact contact) {
        driverTools.clickElement(detailsLinkBtn);
        wait.until(ExpectedConditions.visibilityOf(nameTxt));
        System.out.println(nameTxt.getText().trim()+"herrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        boolean result = true;
        if (contact.getFirstName() != null && contact.getLastName() != null && !contact.getFirstName()
                .concat(" ").concat(contact.getLastName()).equals(nameTxt.getText().trim())) {
            return false;
        }
        if (contact.getPhone() != null && !contact.getPhone().equals(phoneTxt.getText().trim())) {

            return false;
        }
        if (contact.getTitle() != null && !contact.getTitle().equals(titleText.getText().trim())) {
            return false;
        }
        return result;
    }

}
