package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIProduct;
import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.PageTransporter;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.product.ProductDetailPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductFormPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */

public class ProductSteps {
    //Logger
    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(getClass());
    //Pages
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ProductListPage productListPage;
    private ProductFormPage productFormPage;
    private ProductDetailPage productDetailPage;
    //Entities
    private Product product;
    private Product productApi;
    private Product productEdit;
    private APIProduct apiProduct;
    private Response response;
    /**
     * Navigates to the Product page.
     */
    @When("^I go to the Product page$")
    public void iGoToTheProductPage() {
        log.info("iGoToTheProductPage -----> Start homePage");
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        productListPage = allAppsPage.clickProductLink();
    }

    /**
     * click in new button.
     */
    @When("^I click New button Product$")
    public void iClickNewButton() {
        log.info("iClickNewButton -----> click in new Product");
        productFormPage = productListPage.clickNewProduct();
    }

    /**
     * @param products list the Products.
     */
    @Given("^I create a Product with the following information$")
    public void iCreateAProductWithTheFollowingInformation(List<Product> products) {
        log.info("iGoToTheProductPage -----> Start create a Product");
        product = products.get(0);
        product.updateProductName();
        apiProduct = new APIProduct(product);
        productDetailPage = productFormPage.createProduct(product);
    }

    /**
     * Verify the field.
     */
    @Then("^the Product Details Page should be displayed with the product information$")
    public void productDetailsPageShouldBeDisplayWithTheInformationOfTheProductCreated() {
        log.info("Validation for UI -----> Start homePage   " + product.getProductName());
        assertEquals(product.getProductName(), productDetailPage.getProductNameCreated(), "should be show the product name:");
        assertTrue(productDetailPage.isSuccessCreateProduct(product), "should be return :");

    }

    /**
     *Verify the field with API.
     */
    @And("^the Product should be created$")
    public void byAPIShouldBeDisplayInformationOfTheProductCreated() {
        log.info("Validation for API ----->    " + product.getProductName());
        productApi = apiProduct.getProductValuesByAPI();
        assertEquals(product.getProductName(), productApi.getProductName(), "should be show the product name:");
        assertEquals(product.getProductCode(), productApi.getProductCode(), "should be show the product code:");
        assertEquals(product.getProductDescription(), productApi.getProductDescription(), "should be show the product description:");
        assertEquals(product.getActive(), productApi.getActive(), "should be show the product active:");
    }

    //*********************************************************************************************
//                                     Edit the Product
// ********************************************************************************************/

    /**
     * @param productsApi list the Product for API.
     */
    @Given("^I have a Product created with the following information$")
    public void iHaveAProductWithTheFollowingInformation(List<Product> productsApi) {
        log.info("iGoToTheProductPage -----> Start create a Product for API");
        product = productsApi.get(0);
        product.updateProductName();
        apiProduct = new APIProduct(product);
        apiProduct.createProductByAPI();
    }

    /**
     * go to the url the product created.
     */
    @When("^I select the Product created by URL$")
    public void iSelectTheProductCreatedByURL() throws MalformedURLException {
        homePage = PageFactory.getHomePage();
        productDetailPage = PageTransporter.getInstance().navigateToProductPage(product);
    }

    /**
     * click in edit button.
     */
    @And("^I click Edit button Product$")
    public void iClickEditButton() {
        productFormPage = productDetailPage.clickEditOption();
    }

    /**
     * @param editProduct list the Product to edit.
     */
    @When("^I Edit the Product with the following information$")
    public void iEditTheProductInformationWithTheFollowingInformation(List<Product> editProduct) {
//        productDetailPage = productListPage.selectProductItem(product);
        productEdit = editProduct.get(0);
        productEdit.updateProductName();
        productDetailPage = productFormPage.editProduct(productEdit);
    }

    /**
     * verify the Product to edit.
     */
    @Then("^the Product Details Page should be displayed with the edited information$")
    public void theProductDetailsPageShouldBeDisplayWithTheInformationOfTheProductUpdated() {
        log.info("ProductCreated -----> " + productEdit.getProductName() + "====>" + productDetailPage.getProductNameCreated());
        assertEquals(productEdit.getProductName(), productDetailPage.getProductNameCreated(), "should be show the product name:");
        assertTrue(productDetailPage.isSuccessEditProduct(productEdit), "the expected result:");
    }

    @And("^the Product should be updated$")
    public void byAPIShouldBeDisplayInformationOfTheProductEdit() {
        log.info("Validation for API to Edit Product ----->    " + productEdit.getProductName());
        productApi = apiProduct.getProductValuesByAPI();
        assertEquals(productEdit.getProductName(), productApi.getProductName(), "should be show the product name:");
        assertTrue(productDetailPage.isSuccessEditProductByAPI(productApi,productEdit), "the expected result:");

    }

    //*********************************************************************************************
//                                     Delete the Product
// ********************************************************************************************/

    /**
     * Delete the Product.
     */
    @And("^I click Delete button Product$")
    public void iDeleteTheProduct() {
        // productDetailPage = productListPage.selectProductItem(product);
        productListPage = productDetailPage.deleteProduct(product);
        //response=apiProduct.deleteProductByAPI();
    }

    /**
     * verify that product deleted.
     */
    @Then("^the Product should be removed from the Product List$")
    public void theProductShouldBeRemovedFromTheProductList() {
        assertFalse(productListPage.isSuccessDeleteProduct(product), "should be return :");

    }

    /**
     *
     */
    @And("^the Product should be deleted$")
    public void theProductShouldBeDeleted() {
        response = apiProduct.deleteProductByAPI();
        assertTrue(response.asString().isEmpty(), "should be return :");
    }

    //****************************************************************
    //Hooks for @Delete Product scenarios
    //****************************************************************
    @After(value = "@deleteProduct", order = 999)
    public void afterDeleteProduct() {
        log.info("After hook @deleteProduct");
        apiProduct.deleteProductByAPI();

    }

}
