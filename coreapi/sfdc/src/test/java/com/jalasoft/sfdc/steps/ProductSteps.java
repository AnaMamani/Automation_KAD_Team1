package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIProduct;
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
    APIProduct apiProduct;

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
     * @param products list the Products.
     */
    @Given("^I create a Product with the following information$")
    public void iCreateAProductWithTheFollowingInformation(List<Product> products) {
        log.info("iGoToTheProductPage -----> Start create a Product");
        this.product = products.get(0);
        product.setProductName(products.get(0).getProductName());
        productFormPage = productListPage.clickNewProduct();
        productDetailPage = productFormPage.createProduct(product);
        apiProduct=new APIProduct(product);
        System.out.println(apiProduct.getProductValuesByAPI().asString());
    }

    /**
     * Verify the field.
     */
    @Then("^the Product Details Page should be display with the information of the product created$")
    public void productDetailsPageShouldBeDisplayWithTheInformationOfTheProductCreated() {
        log.info("ProductCreated -----> Start homePage   " + product.getProductName() + "====>"
                + productDetailPage.getProductNameCreated());
        assertEquals(product.getProductName(), productDetailPage.getProductNameCreated(), "should be show the product name:");
        assertTrue(productDetailPage.isSuccessCreateProduct(product), "should be return :");
    }

    //*********************************************************************************************
//                                     Edit the Product
// ********************************************************************************************/

    /**
     * @param editProduct list the Product to edit.
     */
    @When("^I Edit the Product information with the following information$")
    public void iEditTheProductInformationWithTheFollowingInformation(List<Product> editProduct) {
        productFormPage = productDetailPage.clickEditOption();
        this.product = editProduct.get(0);
        this.product.setProductName(editProduct.get(0).getProductName());
        productDetailPage = productFormPage.editProduct(product);
    }

    /**
     * verify the Product to edit.
     */
    @Then("^the Product Details Page should be display with the information of the product updated$")
    public void theProductDetailsPageShouldBeDisplayWithTheInformationOfTheProductUpdated() {
        log.info("ProductCreated -----> " + product.getProductName() + "====>" + productDetailPage.getProductNameCreated());
        assertEquals(product.getProductName(), productDetailPage.getProductNameCreated(), "should be show the product name:");
        assertTrue(productDetailPage.isSuccessEditProduct(product),"the expected result:");
    }

    //*********************************************************************************************
//                                     Delete the Product
// ********************************************************************************************/

    /**
     * Delete the Product.
     */
    @And("^I delete the product$")
    public void iDeleteTheProduct() {
        productListPage = productDetailPage.deleteProduct(product);
    }

    /**
     * verify that product deleted.
     */
    @Then("^the Product should be removed from the Product List$")
    public void theProductShouldBeRemovedFromTheProductList() {
        assertFalse(productListPage.isSuccessDeleteProduct(product), "should be return :");
    }

}
