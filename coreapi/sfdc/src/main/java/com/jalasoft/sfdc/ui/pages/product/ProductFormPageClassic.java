package com.jalasoft.sfdc.ui.pages.product;


import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductFormPageClassic extends ProductFormPage {
    //PageFactory of selenium.
    @FindBy(id = "Name")
    WebElement productNameTxt;

    @FindBy(id = "43:3867;a")
    WebElement productCodeTxt;

    @FindBy(id = "109:3867;a")
    WebElement productDescriptionTxt;

    @FindBy(id = "bottomButtonRow")
    WebElement clickBtnSave;

    @FindBy(xpath = "//span[contains(text(),'Save & New')]")
    WebElement clickBtnSaveAndNew;

    @FindBy(xpath = "//button[@title='Cancel']//span[contains(@class,'label bBody')][contains(text(),'Cancel')]")
    WebElement clickBtnCancel;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productNameTxt));
    }

    /**
     * setting and create a new ProductDetailPage.
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage createProduct(Product product) {
        driverTools.setInputField(productNameTxt, product.getProductName());
        driverTools.setInputField(productCodeTxt, product.getProductCode());
        driverTools.setInputField(productDescriptionTxt, product.getProductDescription());
        driverTools.clickElement(clickBtnSave);
        return new ProductDetailPageClassic();
    }
}
