package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class productSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ProductListPage productListPage;

    @When("^I go to the Product page$")
    public void iGoToTheSliderIcon() throws Throwable {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        productListPage = allAppsPage.clickProductLink();
        throw new PendingException();
    }

    @When("^I add the new product$")
    public void iAddTheNewProduct() throws Throwable {
        productListPage.clickNewProduct();
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
