package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIContact;
import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactDetailPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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

    /**
     * page for Contact.
     */
    @When("^I go to the Contact page$")
    public void iGoToTheContactPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        contactListPage = allAppsPage.clickContactLink();
    }
    /**
     * Create contact in Detail Contact.
     */
    @Given("^I create a Contact with the following information$")
    public void iCreateAContactWithTheFollowingInformation(List<Contact> contacts) {
        this.contact = contacts.get(0);
        contactFormPage = contactListPage.clickContactNew();
        apiContact=new APIContact(contact);
        apiContact.createContactByAPI();
       // contact.setFirstName(contacts.get(0).getFirstName());
        //contactDetailPage = contactFormPage.createContact(contact);
    }

    /**
     * Verify create data in Detail Contact.
     */
    @Then("^the Contact Details Page should be display with the information of the contact$")
    public void theContactDetailsPageShouldBeDisplayWithTheInformationOfTheContactCreated() {
        System.out.println(contact.getFirstName().concat(" ").concat(contact.getLastName()) + "***********************************");
        contactApi=apiContact.getContactValuesByAPI();
        assertEquals(contact.getFirstName(),contactApi.getFirstName(),"should be show the contact first name:");
        assertEquals(contact.getLastName(),contactApi.getLastName(),"should be show the contact last name:");
        assertEquals(contact.getTitle(),contactApi.getTitle(),"should be show the contact title:");
        assertEquals(contact.getPhone(),contactApi.getPhone(),"should be show the contact phone:");
        assertEquals(contact.getEmail(),contactApi.getEmail(),"should be show the contact email:");
       // assertEquals(contactDetailPage.isSuccessDisplayedContactDetail(), contact.getFirstName().concat(" ").concat(contact.getLastName()), "full name the Contact is showed");
    }
    //*********************************************************************************************
//                                     Edit the Contact
// ********************************************************************************************/
    /**
     * contact for edit the data
     *
     * @param editContacts data
     */
    @When("^I edit this Contact with the following information$")
    public void iEditThisContactWithTheFollowingInformation(List<Contact> editContacts) {
        this.contact = editContacts.get(0);
        contactFormPage = contactDetailPage.clickEditOption();
        //contact.setFirstName(editContacts.get(0).getFirstName());
        contactDetailPage = contactFormPage.editContact(this.contact);
    }

    @Then("^the Contact Details Page should be display with the information of the contact update$")
    public void theDisplayWithTheInformationOfTheContactUpdate() {
        assertTrue(contactDetailPage.isSuccessEditContact(contact), "the result expected");
    }
    //*********************************************************************************************
//                                     Delete the Contact
// ********************************************************************************************/
    /**
     * delete contact selection.
     */
    @When("^I delete this Contact create$")
    public void iDeleteThisContactCreate() {
        apiContact.deleteContactByAPI();
        //contactListPage = contactDetailPage.deleteContact();
    }

    /**
     * verify that the contact is delete
     */
    @Then("^I should see the Contact is delete$")
    public void iShouldSeeTheContactIsDelete() {
        assertFalse(contactListPage.contactSearch(contact));
    }

}
