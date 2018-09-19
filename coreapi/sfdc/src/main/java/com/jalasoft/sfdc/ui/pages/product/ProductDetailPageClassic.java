package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/11/2018
 */
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
     * verify the edit the product.
     *
     * @param product information the current user.
     */
    @Override
    public void isSuccessEditProduct(Product product) {
        if (product.getProductName() != null)
            assertEquals("result the product name is:", product.getProductName(),productNameTxt.getText().trim());
        if (product.getProductCode()!=null)
            assertEquals("result the product code is:",product.getProductCode(),productCodeTxt.getText().trim());
        if (product.getProductDescription()!=null)
            assertEquals("result the product description is:",product.getProductDescription(),productDescriptionTxt.getText().trim());
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
    public ProductFormPage clickEditOption() {
        log.info("clickEditOption: return ProductFormPageClassic");
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
        log.info("clickEditOption: return ProductListPageClassic");
        driverTools.clickElement(deleteBtn);
        acceptAlertDialog();
        return new ProductListPageClassic();
    }

}
