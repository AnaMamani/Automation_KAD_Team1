package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIOpportunities;
import com.jalasoft.sfdc.api.APIQuote;
import com.jalasoft.sfdc.entities.*;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesDetailPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesFormPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesListPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.quotes.*;
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
    private QuotesDetailPage quotesDetailPage;
    private QuoteLineItemsPage quoteLineItemsPage;
    private QuotesProductSelectPage quotesProductSelectPage;
    private QuotesAddItemsPage quotesAddItemsPage;
    //Entities
    private Opportunities opportunity;
    private Opportunities opportunityApi;
    private World world;
    private Quote quote;
    private Quote quoteApi;
    private APIOpportunities apiOpportunities;
    private APIQuote apiQuote;
    private QuotesLineItem quotesLineItem;

    /**
     * builder of QuotesSteps.
     *
     * @param world general entities.
     */
    public QuotesSteps(World world) {
        this.world = world;
    }

    //*********************************************************************************************
//                                     Opportunities
// ********************************************************************************************/
    @When("^I go to Opportunities Page$")
    public void iGoToOpportunitiesListPage() {
        log.info("iGoToTheProductPage -----> go to opportunities");
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        opportunitiesListPage = allAppsPage.clickOpportunities();
    }

    /**
     * click in new button.
     */
    @And("^I click on New Opportunities$")
    public void iClickOnNewOpportunities() {
        log.info("clickNewOpportunities -----> return opportunitiesFormPage");
        opportunitiesFormPage = opportunitiesListPage.clickNewOpportunities();
    }

    /**
     * created opportunity information
     *
     * @param opportunities1 list opportunity.
     */
    @Given("^I created opportunity with the following information$")
    public void iCreatedOpportunityWithTheFollowingInformation(List<Opportunities> opportunities1) {
        log.info("clickNewOpportunities -----> create an opportunity");
        opportunity = opportunities1.get(0);
        opportunity.updateOpportunityName();
        apiOpportunities = new APIOpportunities(opportunity);
        opportunity.setAccountName(world.getAccount().getAccountName());
        opportunitiesDetailPage = opportunitiesFormPage.createOpportunity(opportunity);
    }

    /**
     * Verify the field
     */
    @Then("^the opportunity should be displayed in details page$")
    public void theOpportunityShouldBeDisplayedInDetailsPage() {
        assertEquals(opportunity.getOpportunityName(), opportunitiesDetailPage.getOpportunityCreated());
        assertTrue("create opportunity", opportunitiesDetailPage.isSuccessCreateOpportunity(opportunity));
    }

    /**
     *
     */
    @And("^the opportunity should be created$")
    public void theOpportunityShouldBeCreated() {
        log.info("verify the created opportunity by API    ================>");
        opportunityApi = apiOpportunities.getOpportunitiesValuesByAPI();
        assertEquals("should be: ", opportunityApi.getOpportunityName(), opportunity.getOpportunityName());
        assertEquals("should be: ", opportunityApi.getStage(), opportunity.getStage());
        assertEquals("should be: ", opportunityApi.getCloseDate(), opportunity.getCloseDateFormat());
    }

    //*********************************************************************************************
//                                     Quotes
// ********************************************************************************************/
    @And("^I click on New quote button$")
    public void iClickOnNewQuotesButton() {
        log.info("clickQuotesNew -----> return quotesFormPage");
        quotesFormPage = opportunitiesDetailPage.clickQuotesNew();
    }

    /**
     * click the button for create a new quotes all
     */
    @When("^I create a new Quote with the following information$")
    public void iCreateANewQuoteWith(List<Quote> listQuote) {
        log.info("createQuote -----> create a Quote");
        this.quote = listQuote.get(0);
        apiQuote = new APIQuote(quote);
        quotesDetailPage = quotesFormPage.createQuote(quote);
        quoteLineItemsPage = quotesDetailPage.clickAddLineItem();
    }

    /**
     * for select option Standard
     *
     * @param selectStandard s.
     */

    @And("^I select a price book \"([^\"]*)\"$")
    public void selectAPriceBook(String selectStandard) {
        log.info("selectPriceBook -----> " + selectStandard);
        quotesProductSelectPage = quoteLineItemsPage.selectPriceBook(selectStandard);
    }

    /**
     * get the name of product for select
     */
    @When("^select the name of product create$")
    public void selectTheNameOfProductCreate() {
        log.info("selectProductQuote -----> " + world.getProduct().getProductName());
        quotesAddItemsPage = quotesProductSelectPage.selectProductQuote(world.getProduct().getProductName());
    }

    /**
     * fill of form quotes.
     *
     * @param listQuote quote information.
     */
    @And("^I add the following line item$")
    public void iAddTheFollowingLineItem(List<QuotesLineItem> listQuote) {
        log.info("addPriceBook -----> ");
        quotesLineItem = listQuote.get(0);
        quotesDetailPage = quotesAddItemsPage.addPriceBook(quotesLineItem);
    }

    /**
     * show in quotes detail page
     */
    @Then("^the Quote should be displayed in Quotes Details page$")
    public void theQuotesShouldBeDisplayedInQuotesDetailsPage() {
        assertEquals("", quote.getQuoteName(), quotesDetailPage.isSuccessDisplayedQuoteDetail());
    }

    @And("^the Quote should be created$")
    public void theQuotesShouldBeCreated() {
        log.info("verify the created quote by API =================>");
        quoteApi = apiQuote.getQuoteValuesByAPI();
        final double total = Integer.parseInt(quotesLineItem.getQuantity()) * Integer.parseInt(quotesLineItem.getSalesPrice());
        assertEquals("should be: ", quoteApi.getQuoteName(), quote.getQuoteName());
        assertEquals("should be :", String.valueOf(total), quoteApi.getQuoteGranTotal());
        assertEquals("should be :",world.getAccount().getAccountName(),quoteApi.getQuoteAccountName());
    }

}
