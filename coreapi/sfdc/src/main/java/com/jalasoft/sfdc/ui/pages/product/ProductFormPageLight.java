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
public class ProductFormPageLight extends ProductFormPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//span[text()='Product Name']/parent::label/following-sibling::input")
    private WebElement productNameTxt;

    @FindBy(xpath = "//span[text()='Product Code']/parent::label/following-sibling::input")
    private WebElement productCodeTxt;

    @FindBy(xpath = "//textarea[@class=' textarea']")
    private WebElement productDescriptionTxt;

    @FindBy(xpath = "//div[@class= 'slds-form-element__control']//child::input[@type='checkbox']")
    private WebElement productActive;

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement clickBtnSave;

    @FindBy(xpath = "//span[contains(text(),'Save & New')]")
    private WebElement clickBtnSaveAndNew;

    @FindBy(xpath = "//button[@title='Cancel']//span[contains(@class,'label bBody')][contains(text(),'Cancel')]")
    private WebElement clickBtnCancel;

    @FindBy(xpath = "//a[@title='New Contact']")
    private WebElement auxToProductId;

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
        driverTools.selectChkBox(productActive, product.getActive());
        driverTools.clickElement(clickBtnSave);
        wait.until(ExpectedConditions.visibilityOf(auxToProductId));
        saveProductId(driver.getCurrentUrl(),product);
        return new ProductDetailPageLight();
    }

    /**
     * @param currentUrl url.
     * @param product product.
     */
    private void saveProductId(String currentUrl, Product product) {
        String[] url=currentUrl.split("/");
        product.setId(url[url.length-2]);
        System.out.println("ID: "+url[url.length-2]+" THIS IS THE PRODUCT ID");
    }

    /**
     * fills and edit a  ProductDetailPage.
     *
     * @param product all information.
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage editProduct(Product product) {
        log.info("editProduct : start the edit the Product  and return a new ProductDetailPageLight");
        if (product.getProductName() != null)
            driverTools.setInputField(productNameTxt, product.getProductName());
        if (product.getProductCode() != null)
            driverTools.setInputField(productCodeTxt, product.getProductCode());
        if (product.getProductDescription() != null)
            driverTools.setInputField(productDescriptionTxt, product.getProductDescription());

        driverTools.selectChkBox(productActive, product.getActive());
        driverTools.clickElement(clickBtnSave);
        driverTools.invisibilityElement(clickBtnSave);
        return new ProductDetailPageLight();
    }
}
