package com.jalasoft.sfdc.steps;
import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactDetailPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

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

    /**
     * page for Contact.
     */
    @When("^I go to the Contact page$")
    public void iGoToTheContactPage()  {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        contactListPage = allAppsPage.clickContactLink();
    }
    /**
     * Selection New for that appear the form.
     */
    @And("^I click in New button$")
    public void iClickInNewButton()  {

        contactFormPage = contactListPage.clickContactNew();
    }
    /**
     * send a list of contacts.
     * @param contacts
     */
    @When("^I create contact fill the following form with the requirement$")
    public void iCreateContact(List<Contact> contacts){
        this.contact = contacts.get(0);
        contactDetailPage = contactFormPage.createContact(contact);
    }

    /**
     * Verify create data in Detail Contact.
     */
    @Then("^Contact was created should be displayed in ContactDetailPage$")
    public void contactWasCreatedShouldBeDisplayedInContactDetailPage()  {
        System.out.println(contact.getFirstName().concat(" ").concat(contact.getLastName())+ "***********************************");
       // contactDetailPage.
        assertEquals(contactDetailPage.isSuccessDisplayedContactDetail(),contact.getFirstName().concat(" ").concat(contact.getLastName()));
    }

    /**
     * contact that you have.
     * @param contacts list.
     */
    @Given("^I have a Contact with the following information$")
    public void iHaveAContactFollowingInformation(List<Contact> contacts) {
        this.contact= contacts.get(0);
        contactDetailPage=contactFormPage.createContact(contact);
    }

    /**
     * contact for edit the data
     * @param contacts data
     */
    @When("^I edit this Contact with the following information$")
    public void iEditThisContactWithTheFollowingInformation(List<Contact> contacts)  {
        this.contact = contacts.get(0);
        contactFormPage = contactDetailPage.clickInEdit();
        contactDetailPage = contactFormPage.editContact(this.contact);
    }

    /**
     * contact that validate new data
     */
    @Then("^Contact was saved with the information actual in Contact Detail$")
    public void contactWasSavedWithTheInformationActualInContactDetail()  {
        contactWasCreatedShouldBeDisplayedInContactDetailPage();
    }

    /**
     * delete contact selection.
     */
    @When("^I delete this Contact create$")
    public void iDeleteThisContactCreate()  {
        contactListPage= contactDetailPage.deleteContact();
    }

    /**
     * verify that the contact is delete
     */
    @Then("^I should see the Contact is delete$")
    public void iShouldSeeTheContactIsDelete()  {
       assertTrue(contactListPage.contactSearch(contact));
    }
}
