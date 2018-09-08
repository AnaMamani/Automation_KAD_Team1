package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.ContactsFormPage.ContactsFormPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.contactDetailPage.ContactDetailPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ContactSteps {
    private AllAppsPage allAppsPage;
    private HomePage homePage;
    private ContactListPage contactListPage;
    private ContactsFormPage contactsFormPage;
    private ContactDetailPage contactDetailPage;


    @When("^I go to the Contact page$")
    public void iGoToTheContactPage() throws Throwable {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        contactListPage = allAppsPage.clickContactLink();
    }


    @And("^I click in New button$")
    public void iClickInNewButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        contactsFormPage = contactListPage.clickLoginButtonNew();
    }

    @When("^I fill the following form with the minimum requirement \"([^\"]*)\", \"([^\"]*)\"$")
    public void iFillTheFollowingFormWithTheMinimumRequirementWith(String firstName, String lastName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        contactDetailPage = contactsFormPage.insertContact(firstName, lastName);
        //throw new PendingException();
    }

    @And("^I click in button Save$")
    public void iClickInButtonSave() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        contactDetailPage = contactsFormPage.clickBtnSave();
        //throw new PendingException();
    }
}
