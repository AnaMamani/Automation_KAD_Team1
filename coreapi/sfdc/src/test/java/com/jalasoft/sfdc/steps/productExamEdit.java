package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.product.ProductDetailPage;
import com.jalasoft.sfdc.ui.pages.product.ProductFormPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * Exam Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/13/2018
 */
public class productExamEdit {
    private HomePage homePage;
    private Product editProduct;
    private ProductDetailPage productDetailPage;
    private ProductFormPage productFormPage;

    @When("^I edit to the Product created with the following data$")
    public void iEditToTheProductCreatedWithTheFollowingData(List<Product> editProducts) {
        homePage = PageFactory.getHomePage();
        productDetailPage = PageFactory.getProductDetailPage();
        editProduct = editProducts.get(0);
        productFormPage = productDetailPage.clickEditProduct();
        productDetailPage = productFormPage.setTheFields(editProduct);
    }

    @Then("^The Product should be edit and should be display with the information of the product edit$")
    public void theProductShouldBeEditAndShouldBeDisplayWithTheInformationOfTheProductEdit() {
        productDetailPage.isSuccessEditProduct(editProduct);
    }
}
