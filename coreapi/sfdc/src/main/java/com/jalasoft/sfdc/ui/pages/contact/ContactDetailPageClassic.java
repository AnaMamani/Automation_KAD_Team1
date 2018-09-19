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
     * For made click in Detail
     */
    @Override
    public void clickOnDetail() {

    }

    /**
     * Validate with detail.
     *
     * @param contact
     */
    @Override
    public void validateWithDetail(Contact contact) {

    }
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickDeleteOption));
    }
}
