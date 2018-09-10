package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class ContactSteps {
    private AllAppsPage allAppsPage;
    private HomePage homePage;


    @When("^I go to the Contact page$")
    public void iGoToTheContactPage() throws Throwable {
        homePage = PageFactory.getHomePage();
       allAppsPage = homePage.topMenu.goToAllAppsPage();
        allAppsPage.clickContactLink();
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
