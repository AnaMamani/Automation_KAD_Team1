package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksPage;
import com.jalasoft.sfdc.ui.pages.priceBooksDetailPage.PriceBooksDetailPage;
import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceBooksFormPage;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class PriceBooks {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private PriceBooksPage priceBooksPage;
    private PriceBooksFormPage priceBooksFormPage;
    private PriceBooksDetailPage priceBooksDetailPage;

    @When("^I go to the Price Books page$")
    public void iGoToThePriceBooksPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        priceBooksPage = allAppsPage.clickPriceBooksLink();
    }

    @And("^I click in New button of books$")
    public void iClickInNewButtonOfBooks()  {
        priceBooksFormPage= priceBooksPage.clickPriceBookNew();
    }

    @When("^I fill the following form with requirement \"([^\"]*)\", \"([^\"]*)\"$")
    public void iFillTheFollowingFormWithRequirement(String priceBookName, String description) {
        priceBooksDetailPage= priceBooksFormPage.insertPriceBooks(priceBookName, description);
    }

    @And("^I click in button Save og books$")
    public void iClickInButtonSaveOgBooks()  {
        priceBooksDetailPage = priceBooksFormPage.clickBtnSave();

    }
}
