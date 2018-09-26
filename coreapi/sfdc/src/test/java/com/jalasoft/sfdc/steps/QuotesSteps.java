package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesForm;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class QuotesSteps {
    //Logger
    private Logger log = Logger.getLogger(getClass());
    //Pages
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private OpportunitiesListPage opportunitiesListPage;
    private OpportunitiesForm opportunitiesForm;

    @When("^I go to Opportunities Page$")
    public void iGoToOpportunitiesListPage() {
        log.info("iGoToTheProductPage -----> Start homePage");
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        opportunitiesListPage = allAppsPage.clickOpportunities();

    }

    @And("^I click on New Opportunities$")
    public void iClickOnNewOpportunities() {
        //opportunitiesForm=opportunitiesListPage.clickNewOpportunities();
    }

    @Given("^I created opportunity with the following information$")
    public void iCreatedOpportunityWithTheFollowingInformation() {

    }

    @Then("^The opportunity should be displayed in details page$")
    public void theOpportunityShouldBeDisplayedInDetailsPage() {

    }

    @When("^I create a new Quote with \"([^\"]*)\" Name$")
    public void iCreateANewQuoteWithName(String test) {

    }

    @And("^The following line item$")
    public void theFollowingLineItem(){

    }
}
