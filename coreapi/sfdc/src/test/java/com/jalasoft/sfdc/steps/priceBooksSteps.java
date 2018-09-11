package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceFormPage;
import cucumber.api.java.en.When;

public class priceBooksSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private PriceBookListPage priceBookListPage;
    private PriceFormPage priceFormPage;

    @When("^I go to the Price Books page$")
    public void iGoToThePriceBooksPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        priceBookListPage =allAppsPage.clickPriceBookLink();
    }

    @When("^I add the new Price Books \"([^\"]*)\",\"([^\"]*)\"$")
    public void iAddTheNewPriceBooks(String priceBookName, String description) {
        priceFormPage= priceBookListPage.clickNewPriceBook();
        priceFormPage.goToFillPriceBook(priceBookName,description);

    }
}
