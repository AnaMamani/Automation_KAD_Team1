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
    @CacheLookup
    protected WebElement detailsLinkBtn;

    //for validate
    @FindBy(xpath = "//span[contains(text(), 'Name')]/parent::div/following-sibling::div/span/span")
    private WebElement nameDetail;
    @FindBy(xpath = "//span[contains(text(), 'Title')]/parent::div/following-sibling::div/span/span")
    private WebElement titleDetail;
    @FindBy(xpath = "//span[contains(text(), 'Phone')]/parent::div/following-sibling::div/span/span")
    private WebElement phoneDetail;
    @FindBy(xpath = "//span[contains(text(), 'Email')]/parent::div/following-sibling::div/span/span/a")
    private WebElement emailDatail;
    @FindBy(xpath = "")
    private WebElement streetDetail;
    @FindBy(xpath = "")
    private WebElement cityDetail ;
    @FindBy(xpath = "")
    private WebElement statetDetail ;
    @FindBy(xpath = "")
    private WebElement countryDetail;



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
     * For made click in Detail
     */
    @Override
    public void clickOnDetail() {
        driverTools.clickElement(detailsLinkBtn);
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(contactCreated));
    }

    /**
     * Validate with detail.
     *
     * @param contact
     */
    @Override
    public void validateWithDetail(Contact contact) {
        System.out.println(contact.getEmail()+"*************");
        System.out.println(emailDatail.getText()+"///////////////");
        if (contact.getFirstName()!=null &&  contact.getLastName()!=null)
        assertEquals(contact.getFirstName().concat(" ").concat(contact.getLastName()), nameDetail.getText().trim());
        if (contact.getPhone()!=null)
            assertEquals(contact.getPhone(), phoneDetail.getText().trim());
        if (contact.getTitle()!=null)
            assertEquals(contact.getTitle(), titleDetail.getText().trim());
        if (contact.getEmail()!=null)
           assertEquals(contact.getEmail(), emailDatail.getText().trim());
        if (contact.getStreet()!=null)
          assertEquals(contact.getStreet(), streetDetail.getText().trim());
        if (contact.getCity()!=null)
            assertEquals(contact.getCity(), cityDetail.getText().trim());
        if (contact.getState()!=null)
            assertEquals(contact.getState(), statetDetail.getText().trim());
        if (contact.getCountry()!=null)
            assertEquals(contact.getCountry(), countryDetail.getText().trim());
    }

}
