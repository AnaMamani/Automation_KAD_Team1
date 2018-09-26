package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */

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

    @FindBy(xpath = "//*[@title='Add to Price Book']")
    private WebElement addPriceBookBtn;

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
     * @return is successfully or not successfully.
     */
    @Override
    public boolean isSuccessEditProduct(Product product) {
        log.info("isSuccessEditProduct:   ");
        boolean result = true;
        if (product.getProductName() != null && !product.getProductName().equals(productNameTxt.getText().trim())) {
            log.info("product name :" + product.getProductName() + " ====> " + productNameTxt.getText().trim());
            return false;
        }

        if (product.getProductCode() != null && !product.getProductCode().equals(productCodeTxt.getText().trim())) {
            log.info("product code :" + product.getProductCode() + " ====> " + productCodeTxt.getText().trim());
            return false;
        }
        if (product.getProductDescription() != null && !product.getProductDescription().equals(productDescriptionTxt.getText().trim())) {
            log.info("product name :" + product.getProductDescription() + " ====> " + productDescriptionTxt.getText().trim());
            return false;
        }
        return result;
    }

    /**
     * add the price book at product.
     * @return new page of ProductPriceBookPage.
     */
    @Override
    public ProductPriceBookPage clickAddPriceBook() {
        log.info("clickAddPriceBook -----> return new page of ProductPriceBookPageClassic");
        driverTools.clickElement(addPriceBookBtn);
        return new ProductPriceBookPageLight();
    }

    /**
     * add the price at product.
     *
     * @return new page of ProductStandardPrice.
     */
    @Override
    public ProductStandardPrice clickAddPrice() {
        return null;
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
