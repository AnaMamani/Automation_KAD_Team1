package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIContact;
import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.PageTransporter;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactDetailPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * Contact steps class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactSteps {
    private AllAppsPage allAppsPage;
    private HomePage homePage;
    private ContactListPage contactListPage;
    private ContactFormPage contactFormPage;
    private ContactDetailPage contactDetailPage;
    private Contact contact;
    private Contact contactApi;
    private APIContact apiContact;
    private Response response;

    /**
     * page for Contact.
     */
    @Given("^I go to the Contact page$")
    public void iGoToTheContactPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        contactListPage = allAppsPage.clickContactLink();
    }

    /**
     * For new form of contact.
     */
    @When("^I click New button for create$")
    public void iClickNewButtonForCreate() {
        contactFormPage = contactListPage.clickContactNew();
    }

    /**
     * Create contact in Detail Contact.
     */
    @And("^I create a Contact with the following information$")
    public void iCreateAContactWithTheFollowingInformation(List<Contact> contacts) {
        contact = contacts.get(0);
        contact.updateContactName();
        apiContact = new APIContact(contact);
        contactDetailPage = contactFormPage.createContact(contact);
    }

    /**
     * Verify create data in Detail Contact.
     */
    @Then("^the Contact Details Page should be display with the information of the contact$")
    public void theContactDetailsPageShouldBeDisplayWithTheInformationOfTheContactCreated() {
        assertEquals(contactDetailPage.isSuccessDisplayedContactDetail(), contact.getFirstName().concat(" ").concat(contact.getLastName()), "full name the Contact is showed");
    }

    /**
     * Validate for API
     */
    @And("^the Contact should be created$")
    public void theContactShouldBeCreated() {
        contactApi = apiContact.getContactValuesByAPI();
        System.out.println(apiContact.getContactValuesByAPI().getPhone() + "**********here*********************");
        assertEquals(contact.getFirstName(), contactApi.getFirstName(), "should be show the contact first name:");
        assertEquals(contact.getLastName(), contactApi.getLastName(), "should be show the contact last name:");
        assertEquals(contact.getTitle(), contactApi.getTitle(), "should be show the contact title:");
        assertEquals(contact.getPhone(), contactApi.getPhone(), "should be show the contact phone:");
        assertEquals(contact.getEmail(), contactApi.getEmail(), "should be show the contact email:");
    }
    //*********************************************************************************************
//                                     Edit the Contact
// ********************************************************************************************/

    /**
     * for create by API for edit
     */
    @Given("^I have a Contact with the following information$")
    public void iHaveAContactWithTheFollowingInformation(List<Contact> contactsApi) {
        contact = contactsApi.get(0);
        contact.updateContactName();
        apiContact = new APIContact(contact);
        apiContact.createContactByAPI();
    }

    /**
     * For select the Url by recuperate and edit
     */
    @When("^I Select the Contact created by URL$")
    public void iSelectTheContactCreatedByURL() throws MalformedURLException {
        homePage = PageFactory.getHomePage();
        contactDetailPage = PageTransporter.getInstance().navigateToContactPage(contact);
    }

    /**
     * Edit contact
     */
    @And("^I click Edit button contact$")
    public void iClickEditButtonContact() {
        contactFormPage = contactDetailPage.clickEditOption();
    }

    /**
     * contact for edit the data
     *
     * @param editContacts data
     */
    @And("^I edit this Contact with the following information$")
    public void iEditThisContactWithTheFollowingInformation(List<Contact> editContacts) {
        contact = editContacts.get(0);
        contact.updateContactName();
        contactDetailPage = contactFormPage.editContact(contact);
    }

    /**
     * Validate by UI with data edit
     */
    @Then("^the Contact Details Page should be display with the information of the contact update$")
    public void theDisplayWithTheInformationOfTheContactUpdate() {
        System.out.println("============== Validation for UI ==============");
        assertTrue(contactDetailPage.isSuccessEditContact(contact), "the result expected");
    }

    /**
     * validate by API with data update
     */
    @And("^the Contact should be updated$")
    public void theContactShouldBeUpdated() {
        System.out.println("============== Validation for API ==============");
        contactApi = apiContact.getContactValuesByAPI();
        assertTrue(contactDetailPage.isSuccessEditAccountByAPI(contactApi, contact), "the expected result:");
    }
    //*********************************************************************************************
//                                     Delete the Contact
// ********************************************************************************************/

    /**
     * For delete with Button
     */
    @And("^I click Delete button contact$")
    public void iClickDeleteButtonContact() {
        contactListPage = contactDetailPage.deleteContact();
    }

    /**
     * verify that the contact is delete with UI
     */

    @Then("^I should see the Contact is delete$")
    public void iShouldSeeTheContactIsDelete() {
        assertFalse(contactListPage.isSuccessDeleteContact(contact));
    }

    /**
     * validate by API with data dalete
     */
    @And("^the Contact should be deleted$")
    public void theContactShouldBeDeleted() {
        final String deleteEntity = "entity is deleted";
        response = apiContact.deleteContactByAPI();
        assertTrue(response.asString().contains(deleteEntity), "should be return :");

    }

    //****************************************************************
    //Hooks for @Delete Product scenarios
    //****************************************************************
    @After(value = "@deleteContact", order = 999)
    public void afterDeleteContact() {
        apiContact.deleteContactByAPI();

    }
}
