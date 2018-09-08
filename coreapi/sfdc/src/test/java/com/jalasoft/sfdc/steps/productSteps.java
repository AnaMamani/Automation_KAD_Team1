package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.productFormPage.ProductFormPage;
import cucumber.api.java.en.When;

public class productSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ProductListPage productListPage;
    private ProductFormPage productFormPage;

    @When("^I go to the Product page$")
    public void iGoToTheSliderIcon() throws Throwable {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        productListPage = allAppsPage.clickProductLink();
    }

    @When("^I add the new product \"([^\"]*)\"$")
    public void iAddTheNewProduct(String productName) throws Throwable {
        productFormPage=productListPage.clickNewProduct();
        productFormPage.goToFillProduct(productName);


    }
}
