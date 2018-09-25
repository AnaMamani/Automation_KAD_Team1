package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class OpportunitiesSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private OpportunitiesListPage opportunitiesListPage;
    @And("^I go to Opportunities page$")
    public void iGoToOpportunitiesPage()  {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        opportunitiesListPage = allAppsPage.clickOpportunities();
    }

    @When("^I click New button Opportunities$")
    public void iClickNewButtonOpportunities()  {
        opportunitiesListPage.clickNewOpportunities();
    }
}
