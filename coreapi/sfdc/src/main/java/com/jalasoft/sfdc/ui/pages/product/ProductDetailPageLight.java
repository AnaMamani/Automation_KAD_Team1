package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPageLight extends ProductDetailPage {
    //PageFactory of selenium.
    @FindBy(xpath = "(//span[contains(@class,'separator is-read-only')])[1]")
    private WebElement productNameTxt;

    @FindBy(xpath = "(//span[contains(@class,'separator is-read-only')])[3]")
    private WebElement productCodeTxt;

    @FindBy(xpath = "(//span[contains(@class,'separator is-read-only')])[7]")
    private WebElement productDescriptionTxt;

    @FindBy(id = "IsActive_chkbox")
    private WebElement productChkActive;

    @FindBy(xpath = "//div[@class='slds-media__body' ]//parent::span")
    private WebElement productNameCreatedTxt;

    @FindBy(xpath = "//a[@title='Show 4 more actions']")
    private WebElement showMoreAction;

    @FindBy(xpath = "//a[@title='Edit']")
    private WebElement selectEdit;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement selectDelete;

    @FindBy(xpath = "//button[@title='Delete']")
    private WebElement actionDelete;


    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productNameCreatedTxt));
    }

    /**
     * verify that a product is create.
     * @param product information the current user.
     * @return is successfully or not successfully.
     */
    @Override
    public boolean isSuccessCreateProduct(Product product) {
        log.info("isSuccessCreateProduct ---> the product name is :"+product.getProductName());
        return product.getProductName().equals(productNameTxt.getText()) &&
                product.getProductCode().equals(productCodeTxt.getText()) &&
                product.getProductDescription().equals(productDescriptionTxt.getText());

    }

    /**
     * @return the product name created.
     */
    @Override
    public String getProductNameCreated() {
        log.info("getProductNameCreated ---> the product name is :"+productNameCreatedTxt.getText());
        return productNameCreatedTxt.getText().trim();
    }
    /**
     * select the product to edit.
     *
     * @return ProductFormPage.
     */
    @Override
    public ProductFormPage selectProductToEdit() {
        log.info("selectProductToEdit: return ProductFormPageLight");
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
        log.info("selectProductToEdit: return ProductListPageLight");
        driverTools.clickElement(showMoreAction);
        driverTools.clickElement(selectDelete);
        acceptAlertDialog();
        return new ProductListPageLight();
    }

    /**
     * @param chk
     * @return
     */
    private boolean checkBoxProduct(String chk) {
        return chk.equalsIgnoreCase("True");

    }
}
