package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFormPageLight extends ProductFormPage {
    //PageFactory of selenium.
    @FindBy(id = "7:3867;a")
    private WebElement productNameTxt;

    @FindBy(id = "43:3867;a")
    private WebElement productCodeTxt;

    @FindBy(id = "109:3867;a")
    private WebElement productDescriptionTxt;

    @FindBy(id = "23:3867;a")
    private WebElement productActive;

    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
    private WebElement clickBtnSave;

    @FindBy(xpath = "//span[contains(text(),'Save & New')]")
    private WebElement clickBtnSaveAndNew;

    @FindBy(xpath = "//button[@title='Cancel']//span[contains(@class,'label bBody')][contains(text(),'Cancel')]")
    private WebElement clickBtnCancel;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * setting and create a new ProductDetailPage.
     *
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage createProduct(Product product) {
        driverTools.setInputField(productNameTxt, product.getProductName());
        driverTools.setInputField(productCodeTxt, product.getProductCode());
        driverTools.setInputField(productDescriptionTxt, product.getProductDescription());
        driverTools.clickElement(clickBtnSave);
        return new ProductDetailPageLight();
    }
}
