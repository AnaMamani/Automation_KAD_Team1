package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.*;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesDetailPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesFormPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesListPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.quotes.*;
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
    private Opportunities opportunity;
    private World world;
    private Quote quote;
    private QuotesLineItem quotesLineItem;
    private QuotesDetailPage quotesDetailPage;
    private QuoteLineItemsPage quoteLineItemsPage;
    private QuotesProductSelectPage quotesProductSelectPage;
    private QuotesAddItemsPage quotesAddItemsPage;
    private Product product;

    public QuotesSteps(World world) {
        this.world=world;
    }


    @When("^I go to Opportunities Page$")
    public void iGoToOpportunitiesListPage() {
        log.info("iGoToTheProductPage -----> Start homePage");
        System.out.println(world.getAccount().getAccountName() + " ==========================>");
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        opportunitiesListPage = allAppsPage.clickOpportunities();

    }

    /**
     * click in new button.
     */
    @And("^I click on New Opportunities$")
    public void iClickOnNewOpportunities() {
        opportunitiesFormPage = opportunitiesListPage.clickNewOpportunities();
    }

    /**
     *  created opportunity information
     * @param opportunities1 list opportunity.
     */
    @Given("^I created opportunity with the following information$")
    public void iCreatedOpportunityWithTheFollowingInformation(List<Opportunities> opportunities1) {
        opportunity = opportunities1.get(0);
        opportunity.updateOpportunityName();
        opportunity.setAccountName(world.getAccount().getAccountName());
        opportunitiesDetailPage = opportunitiesFormPage.createOpportunity(opportunity);

    }

    /**
     * Verify the field
     */
    @Then("^The opportunity should be displayed in details page$")
    public void theOpportunityShouldBeDisplayedInDetailsPage() {

        assertEquals(opportunity.getOpportunityName(), opportunitiesDetailPage.getOpportunityCreated());
        assertTrue("create opportunity", opportunitiesDetailPage.isSuccessCreateOpportunity(opportunity));

    }
    //*********************************************************************************************
//                                     Quotes
// ********************************************************************************************/
    @And("^I click on New quotes button$")
    public void iClickOnNewQuotesButton() {
        quotesFormPage = opportunitiesDetailPage.clickQuotesNew();
    }

    /**
     * click the button for create a new quotes all
     */

    @When("^I create a new Quote with$")
    public void iCreateANewQuoteWith(List<Quote> listQuote) {
        this.quote = listQuote.get(0);
        quotesDetailPage = quotesFormPage.createQuote(quote);
        quoteLineItemsPage = quotesDetailPage.clickAddLineItem();
    }

    /**
     * for select option Standard
     *
     * @param selectStandard
     */

    @And("^Select a price book \"([^\"]*)\"$")
    public void selectAPriceBook(String selectStandard) {
        quotesProductSelectPage = quoteLineItemsPage.selectPriceBook(selectStandard);
    }

    /**
     * get the name of product for select
     */
    @When("^select the name of product create$")
    public void selectTheNameOfProductCreate() {
        System.out.println(world.getProduct().getProductName()+"*************ketty************");
        quotesAddItemsPage = quotesProductSelectPage.selectProductQuote( world.getProduct().getProductName());
    }

    /**
     * fill of form quotes
     *
     * @throws Throwable
     */
    @And("^I add the following line item$")
    public void iAddTheFollowingLineItem(List<QuotesLineItem> listQuote) {
        quotesLineItem = listQuote.get(0);
        quotesDetailPage = quotesAddItemsPage.addPriceBook(quotesLineItem);
    }
    /**
     * show in quotes detail page
     */
    @Then("^the Quotes should be displayed in Quotes Details page$")
    public void theQuotesShouldBeDisplayedInQuotesDetailsPage()  {
        System.out.println(quote.getQuoteName()+"hereeeeeeeeeeeeeeeeeeeeeee");
        assertEquals(quote.getQuoteName(),quotesDetailPage.isSuccessDisplayedQuoteDetail());
    }
}
