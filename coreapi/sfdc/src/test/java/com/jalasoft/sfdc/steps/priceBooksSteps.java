package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksListPage;
import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceFormPage;
import cucumber.api.java.en.When;

public class priceBooksSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private PriceBooksListPage priceBooksListPage;
    private PriceFormPage priceFormPage;

    @When("^I go to the Price Books page$")
    public void iGoToThePriceBooksPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        priceBooksListPage=allAppsPage.clickPriceBooksLink();
    }

    @When("^I add the new Price Books \"([^\"]*)\",\"([^\"]*)\"$")
    public void iAddTheNewPriceBooks(String arg0, String arg1) {
        priceFormPage=priceBooksListPage.clickNewPriceBooks();
        priceFormPage.goToFillPriceBooks(arg0,arg1);


    }
}
