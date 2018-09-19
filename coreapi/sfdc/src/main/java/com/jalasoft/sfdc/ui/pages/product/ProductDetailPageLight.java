package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */
import static org.junit.Assert.assertEquals;

public class ProductDetailPageLight extends ProductDetailPage {
    //PageFactory of selenium.
    @FindBy(xpath = "(//div[@class='slds-form-element__control slds-grid itemBody']//child::span[@class='uiOutputText'])[1]")
    private WebElement productNameTxt;

    @FindBy(xpath = "//div[@class='slds-form-element__control slds-grid itemBody']//following::span[@class='uiOutputText']")
    private WebElement productCodeTxt;

    @FindBy(xpath = "//div[@class='slds-form-element__control slds-grid itemBody']//child::span[@class='uiOutputTextArea']")
    private WebElement productDescriptionTxt;

    @FindBy(xpath = "(//img[contains(@class,' checked')])[2]")
    private WebElement productChkActive;

    @FindBy(xpath = "//div[@class='slds-media__body']//child::span")
    private WebElement productNameCreatedTxt;

    @FindBy(xpath = "//div[@class='slds-media__body']//child::span")
    private WebElement productNameEditTxt;

    @FindBy(xpath = "//a[@title='Show 4 more actions']")
    private WebElement showMoreAction;

    @FindBy(xpath = "//a[@title='Edit']")
    private WebElement selectEdit;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement selectDelete;

    @FindBy(xpath = "//button[@title='Delete']")
    private WebElement actionDelete;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteProduct;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productNameCreatedTxt));
    }

    /**
     * verify that a product is create.
     *
     * @param product information the current user.
     * @return is successfully or not successfully.
     */
    @Override
    public boolean isSuccessCreateProduct(Product product) {
        log.info("isSuccessCreateProduct ---> the product name is :" + product.getProductName());
        return product.getProductName().equals(productNameTxt.getText()) &&
                product.getProductCode().equals(productCodeTxt.getText()) &&
                product.getProductDescription().equals(productDescriptionTxt.getText());
    }

    /**
     * verify the edit the product.
     *
     * @param product information the current user.
     */
    @Override
    public void isSuccessEditProduct(Product product) {
        if (product.getProductName() != null)
            assertEquals("result the product name is:", product.getProductName(), productNameTxt.getText().trim());
        if (product.getProductCode() != null)
            assertEquals("result the product code is:", product.getProductCode(), productCodeTxt.getText().trim());
        if (product.getProductDescription() != null)
            assertEquals("result the product description is:", product.getProductDescription(), productDescriptionTxt.getText().trim());
    }

    /**
     * @return the product name created.
     */
    @Override
    public String getProductNameCreated() {
        log.info("getProductNameCreated ---> the product name is :" + productNameCreatedTxt.getText());
        return productNameCreatedTxt.getText().trim();
    }

    /**
     * select the product to edit.
     *
     * @return ProductFormPage.
     */
    @Override
    public ProductFormPage clickEditOption() {
        log.info("clickEditOption: return ProductFormPageLight");
        driverTools.clickElement(showMoreAction);
        driverTools.clickElement(selectEdit);
        return new ProductFormPageLight();
    }

    /**
     * select the product to delete.
     *
     * @param product
     * @return ProductListPage.
     */
    @Override
    public ProductListPage deleteProduct(Product product) {
        log.info("clickEditOption: return ProductListPageLight");
        driverTools.clickElement(showMoreAction);
        driverTools.clickElement(selectDelete);
        driverTools.clickElement(deleteProduct);
        return new ProductListPageLight();
    }
}
