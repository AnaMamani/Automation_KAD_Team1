package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    private WebElement clickEditOption;
    @FindBy(xpath = "(//*[@title='Delete'])[1]")
    private WebElement clickDeleteOption;
    //for validate
    @FindBy(id = "con2_ileinner")
    private WebElement nameTxt;
    @FindBy(id = "con5_ileinner")
    private WebElement titleText;
    @FindBy(id = "con10_ileinner")
    private WebElement phoneTxt;
    @FindBy(xpath = "con15_ileinner")
    private WebElement emailTxt;
    @FindBy(xpath = "")
    private WebElement streetTxt;
    @FindBy(xpath = "")
    private WebElement cityTxt;
    @FindBy(xpath = "")
    private WebElement statetTxt;
    @FindBy(xpath = "")
    private WebElement countryTxt;
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
    public ContactFormPage clickEditOption() {
        driverTools.clickElement(clickEditOption);
        return new ContactFormPageClassic();
    }

    /**
     * Delete Contact of contact detail.
     *
     * @return ContactListPage.
     */
    @Override
    public ContactListPage deleteContact() {
        driverTools.clickElement(clickDeleteOption);
        acceptAlertDialog();
        return new ContactListPageClassic();
    }

    /**
     * Validate with detail.
     *
     * @param contact
     */
    @Override
    public boolean isSuccessEditContact(Contact contact) {
        log.info("isSuccessEditProduct:   ");
        boolean result = true;
        if (contact.getFirstName() != null &&contact.getLastName() != null && !contact.getFirstName()
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


    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickDeleteOption));
    }
}
