package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPageClassic extends ProductDetailPage {
    //PageFactory of selenium.
    @FindBy(id = "Name_ileinner")
    private WebElement productNameTxt;

    @FindBy(id = "ProductCode_ileinner")
    private WebElement productCodeTxt;

    @FindBy(id = "Description_ileinner")
    private WebElement productDescriptionTxt;

    @FindBy(id = "IsActive_chkbox")
    private WebElement productChkActive;

    @FindBy(className = "pageDescription")
    private WebElement productNameCreatedTxt;

    @FindBy(xpath = "//*[@title='Edit']")
    private WebElement editBtn;

    @FindBy(xpath = "//*[@title='Delete']")
    private WebElement deleteBtn;

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
        log.info("isSuccessCreateProduct: Enter  " + productChkActive.isSelected());
        return product.getProductName().equals(productNameTxt.getText()) &&
                product.getProductCode().equals(productCodeTxt.getText()) &&
                product.getProductDescription().equals(productDescriptionTxt.getText());

    }

    /**
     * @return the product name created.
     */
    @Override
    public String getProductNameCreated() {
        log.info("getProductNameCreated: " + productNameCreatedTxt.getText());
        return productNameCreatedTxt.getText().trim();
    }

    /**
     * select the product to edit.
     *
     * @return ProductFormPage.
     */
    @Override
    public ProductFormPage selectProductToEdit() {
        log.info("selectProductToEdit: return ProductFormPageClassic");
        driverTools.clickElement(editBtn);
        return new ProductFormPageClassic();
    }

    /**
     * select the product to delete.
     *
     * @param product
     * @return ProductListPage.
     */
    @Override
    public ProductListPage deleteProduct(Product product) {
        log.info("selectProductToEdit: return ProductListPageClassic");
        driverTools.clickElement(deleteBtn);
        acceptAlertDialog();
        return new ProductListPageClassic();
    }

    /**
     * @param chk
     * @return
     */
    private boolean checkBoxProduct(String chk) {
        log.info("checkBoxProduct: " + chk);
        return chk.equalsIgnoreCase("True");
    }
}
