package com.jalasoft.sfdc.steps;
import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactDetailPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.util.List;
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

}
