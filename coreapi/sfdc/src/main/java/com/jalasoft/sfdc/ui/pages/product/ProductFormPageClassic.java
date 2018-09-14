package com.jalasoft.sfdc.ui.pages.product;


import com.jalasoft.sfdc.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage createProduct(Product product) {
        log.info("createProduct : Enter");
        driverTools.setInputField(productNameTxt, product.getProductName());
        driverTools.setInputField(productCodeTxt, product.getProductCode());
        driverTools.setInputField(productDescriptionTxt, product.getProductDescription());
        checkProduct(productChkActive,product.getActive());
        driverTools.clickElement(clickBtnSave);
        return new ProductDetailPageClassic();
    }

    /**
     * setting and a new ProductDetailPage.
     *
     * @param productAux all information.
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage setTheFields(Product productAux) {
        log.info("setTheFields : setting the fields and return a new ProductDetailPageClassic");
        if (productAux.getProductName()!=null){
            driverTools.setInputField(productNameTxt, productAux.getProductName());
        }
        if (productAux.getProductCode()!=null){
            driverTools.setInputField(productCodeTxt, productAux.getProductCode());
        }
        if (productAux.getProductDescription()!=null){
            driverTools.setInputField(productDescriptionTxt, productAux.getProductDescription());
        }
        if (productAux.getActive()!=null){
            checkProduct(productChkActive,productAux.getActive());
            driverTools.clickElement(clickBtnSave);
        }
        driverTools.clickElement(clickBtnSave);
        return new ProductDetailPageClassic();
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
