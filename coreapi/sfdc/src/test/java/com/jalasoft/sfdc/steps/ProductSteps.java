package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.product.ProductDetailPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductFormPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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
    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(getClass());
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ProductListPage productListPage;
    private ProductFormPage productFormPage;
    private ProductDetailPage productDetailPage;
    private Product product;

    @When("^I go to the Product page$")
    public void iGoToTheProductPage() {
        log.info("iGoToTheProductPage -----> Start homePage");
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        productListPage = allAppsPage.clickProductLink();
    }

    @And("^I create a Product with the following information$")
    public void iCreateAProductWithTheFollowingInformation(List<Product> products) {
        log.info("iGoToTheProductPage -----> Start create a Product");
        this.product = products.get(0);
        productFormPage = productListPage.clickNewProduct();
        productDetailPage = productFormPage.createProduct(product);
    }

    @Then("^Product Details Page should be display with the information of the product created$")
    public void productDetailsPageShouldBeDisplayWithTheInformationOfTheProductCreated() {
        log.info("ProductCreated -----> Start homePage   " + product.getProductName() + "====>" + productDetailPage.getProductNameCreated());
        final String data = productDetailPage.getProductNameCreated();
        assertTrue(data.contains(product.getProductName()));
        assertTrue(productDetailPage.isSuccessCreateProduct(product));
    }
//*********************************************************************************************
//                                     Edit the Product
// ********************************************************************************************/
    @Given("^I have a New Product with the following information$")
    public void iHaveANewProductWithTheFollowingInformation(List<Product> newProducts) {
        log.info("Go to the Product page -----> Start edit");
        iGoToTheProductPage();
        iCreateAProductWithTheFollowingInformation(newProducts);
        productDetailsPageShouldBeDisplayWithTheInformationOfTheProductCreated();
    }

    @When("^I select the Product$")
    public void iSelectTheProduct() {
        productFormPage=productDetailPage.selectProductToEdit();
    }

    @And("^I Edit the Product information with the following information$")
    public void iEditTheProductInformationWithTheFollowingInformation(List<Product> editProduct) {
        this.product = editProduct.get(0);
        productDetailPage = productFormPage.createProduct(product);
    }

    @Then("^Product Content Page should be displayed with the information updated$")
    public void productContentPageShouldBeDisplayedWithTheInformationUpdated() {
        productDetailsPageShouldBeDisplayWithTheInformationOfTheProductCreated();
    }
}
