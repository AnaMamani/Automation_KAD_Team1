package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPageLight extends ProductDetailPage {
    //PageFactory of selenium.
    @FindBy(id = "'Name_ileinner")
    private WebElement productNameTxt;

    @FindBy(id = "ProductCode_ileinner")
    private WebElement productCodeTxt;

    @FindBy(id = "Description_ileinner")
    private WebElement productDescriptionTxt;

    @FindBy(id = "IsActive_chkbox")
    private WebElement productChkActive;

    @FindBy(xpath = "//div[@class='slds-media__body' ]//parent::span")
    private WebElement productNameCreatedTxt;

    @FindBy(className = "//*[@title='Edit']")
    private WebElement editBtn;

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
                product.getProductDescription().equals(productDescriptionTxt.getText()) &&
                checkBoxProduct(product.getActive()) == productChkActive.isSelected();

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
        driverTools.clickElement(editBtn);
        return new ProductFormPageLight();
    }
    /**
     * @param chk
     * @return
     */
    private boolean checkBoxProduct(String chk) {
        return chk.equalsIgnoreCase("True");

    }
}
