package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

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
        log.info("isSuccessCreateProduct: Enter");
        //checkBoxProduct(product.getActive()) == productChkActive.isSelected()
        return product.getProductName().equals(productNameTxt.getText()) &&
                product.getProductCode().equals(productCodeTxt.getText()) &&
                product.getProductDescription().equals(productDescriptionTxt.getText());

    }

    /**
     * @return the product name created.
     */
    @Override
    public String getProductCreated() {
        log.info("getProductCreated =====>"+productNameCreatedTxt.getText());
        return productNameCreatedTxt.getText().trim();
    }

    /**
     * @return the new ProductFormPage.
     */
    @Override
    public ProductFormPage clickEditProduct() {
        log.info("clickEditProduct: return new ProductFormPageClassic");
        driverTools.clickElement(editBtn);
        return new ProductFormPageClassic();
    }

    /**
     * verify that a product is edit.
     *
     * @param editProduct information the current user.
     * @return is successfully or not successfully.
     */
    @Override
    public void isSuccessEditProduct(Product editProduct) {
        log.info("isSuccessEditProduct =====>"+editProduct.getProductName()+"-- "+productNameTxt.getText().trim());
        if (editProduct.getProductName()!=null){
            log.debug("isSuccessEditProduct =====>"+productNameTxt.getText().trim());
            assertTrue(editProduct.getProductName().equals(productNameTxt.getText().trim()));

        }
        if (editProduct.getProductCode()!=null){
            log.debug("isSuccessEditProduct =====>"+productCodeTxt.getText().trim());
            assertTrue(editProduct.getProductCode().equals(productCodeTxt.getText().trim()));
        }
        if (editProduct.getProductDescription()!=null){
            log.debug("isSuccessEditProduct =====>"+productDescriptionTxt.getText().trim());
            assertTrue(editProduct.getProductDescription().equals(productDescriptionTxt.getText().trim()));
        }

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
