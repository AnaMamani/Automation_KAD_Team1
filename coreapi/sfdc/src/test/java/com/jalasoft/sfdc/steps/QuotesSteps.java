package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Opportunities;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesDetailPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesFormPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesListPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuotesSteps {
    //Logger
    private Logger log = Logger.getLogger(getClass());
    //Pages
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private OpportunitiesListPage opportunitiesListPage;
    private QuotesFormPage quotesFormPage;
    private OpportunitiesFormPage opportunitiesFormPage;
    private OpportunitiesDetailPage opportunitiesDetailPage;
    private Opportunities opportunities;
    private Opportunities opportunity;


    @When("^I go to Opportunities Page$")
    public void iGoToOpportunitiesListPage() {
        log.info("iGoToTheProductPage -----> Start homePage");
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
         opportunitiesListPage = allAppsPage.clickOpportunities();

    }
    /**
     * click in new button.
     */
    @And("^I click on New Opportunities$")
    public void iClickOnNewOpportunities() {
        opportunitiesFormPage =opportunitiesListPage.clickNewOpportunities();
    }

    /**
     *
     * @param opportunities of Opportunity
     */
    @Given("^I created opportunity with the following information$")
    public void iCreatedOpportunityWithTheFollowingInformation(List<Opportunities> opportunities) {
         opportunity = opportunities.get(0);
         opportunity.updateOpportunityName();
        opportunitiesDetailPage=opportunitiesFormPage.createOpportunity(opportunity);

    }

    /**
     * Verify the field
     */
    @Then("^The opportunity should be displayed in details page$")
    public void theOpportunityShouldBeDisplayedInDetailsPage() {

              assertEquals(opportunity.getOpportunityName(),opportunitiesDetailPage.getOpportunityCreated());
              assertTrue("create opportunity",opportunitiesDetailPage.isSuccessCreateOpportunity(opportunity));

    }

    /**
     * click the button for create a new quotes all
     */
    @When("^I create a new Quote with Test Quote Name$")
    public void iCreateANewQuoteWithTestQuoteName() {
        quotesFormPage=opportunitiesDetailPage.clickQuotesNew();
    }

    @And("^The following line item$")
    public void theFollowingLineItem(){

    }


}
