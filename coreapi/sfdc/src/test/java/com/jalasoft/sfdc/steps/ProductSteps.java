package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.product.ProductDetailPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductFormPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ProductSteps {

    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ProductListPage productListPage;
    private ProductFormPage productFormPage;
    private ProductDetailPage productDetailPage;
    private Product product;

    @When("^I go to the Product page$")
    public void iGoToTheSliderIcon() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        productListPage = allAppsPage.clickProductLink();
    }

    @And("^I create a Product with the following information$")
    public void iCreateAProductWithTheFollowingInformation(List<Product> products) {
        this.product=products.get(0);
        productFormPage=productListPage.clickNewProduct();
        productDetailPage=productFormPage.createProduct(product);
    }

    @Then("^Product Details Page should be display with the information of the product created$")
    public void productDetailsPageShouldBeDisplayWithTheInformationOfTheProductCreated() {
        assertEquals(product.getProductName(),productDetailPage.getProductCreated(),"should be show the product name created");
        //assertTrue(productDetailPage.isSuccessCreateProduct(product));
    }
}