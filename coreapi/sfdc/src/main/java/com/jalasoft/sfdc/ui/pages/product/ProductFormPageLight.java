package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFormPageLight extends ProductFormPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//*[@data-interactive-lib-uid='5']")
    private WebElement productNameTxt;

    @FindBy(xpath = "//*[@data-interactive-lib-uid='7']")
    private WebElement productCodeTxt;

    @FindBy(xpath = "//*[@data-interactive-lib-uid='9']")
    private WebElement productDescriptionTxt;

    @FindBy(xpath = "//*[@data-interactive-lib-uid='6']")
    private WebElement productActive;

    @FindBy(xpath = "//*[@title= 'Save']")
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
        log.info("createProduct : Enter");
        driverTools.setInputField(productNameTxt, product.getProductName());
        driverTools.setInputField(productCodeTxt, product.getProductCode());
        driverTools.setInputField(productDescriptionTxt, product.getProductDescription());
        checkProduct(productActive,product.getActive());
        driverTools.clickElement(clickBtnSave);
        return new ProductDetailPageLight();
    }
    /**
     * setting the field checkbox product.
     * @param webElement is.
     * @param active state of checkbox.
     */
    private void checkProduct(WebElement webElement, String active){
        log.info("checkProduct : Enter   ---> "+active);
        if (active.equalsIgnoreCase("True")){
            log.debug("checkProduct :"+active);
            driverTools.clickElement(webElement);
        }
    }
}
