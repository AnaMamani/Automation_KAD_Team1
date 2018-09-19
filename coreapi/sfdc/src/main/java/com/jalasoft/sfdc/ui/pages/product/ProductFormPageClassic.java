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
public class ProductFormPageClassic extends ProductFormPage {
    //PageFactory of selenium.
    @FindBy(id = "Name")
    private WebElement productNameTxt;

    @FindBy(id = "ProductCode")
    private WebElement productCodeTxt;

    @FindBy(id = "Description")
    private WebElement productDescriptionTxt;

    @FindBy(id = "IsActive")
    private WebElement productChkActive;

    @FindBy(xpath = "//input[@name = \"save\"]")
    private WebElement clickBtnSave;

    @FindBy(xpath = "//input[@title='Save & Add Price']")
    private WebElement clickBtnSaveAndNew;

    @FindBy(xpath = "//input[@title='Cancel']")
    private WebElement clickBtnCancel;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productNameTxt));
    }

    /**
     * setting and create a new ProductDetailPage.
     *
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage createProduct(Product product) {
        log.info("createProduct : Enter");
        driverTools.setInputField(productNameTxt, product.getProductName());
        driverTools.setInputField(productCodeTxt, product.getProductCode());
        driverTools.setInputField(productDescriptionTxt, product.getProductDescription());
        driverTools.selectChkBox(productChkActive, product.getActive());
        driverTools.clickElement(clickBtnSave);
        return new ProductDetailPageClassic();
    }

    /**
     * fills and edit a  ProductDetailPage.
     *
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage editProduct(Product product) {
        log.info("editProduct : start the edit the Product  and return a new ProductDetailPageClassic");
        if (product.getProductName() != null)
            driverTools.setInputField(productNameTxt, product.getProductName());
        if (product.getProductCode() != null)
            driverTools.setInputField(productCodeTxt, product.getProductCode());
        if (product.getProductDescription() != null)
            driverTools.setInputField(productDescriptionTxt, product.getProductDescription());

        driverTools.selectChkBox(productChkActive, product.getActive());
        driverTools.clickElement(clickBtnSave);
        return new ProductDetailPageClassic();
    }
}
