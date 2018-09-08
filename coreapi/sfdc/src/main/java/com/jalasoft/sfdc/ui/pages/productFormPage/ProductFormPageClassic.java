package com.jalasoft.sfdc.ui.pages.productFormPage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFormPageClassic extends ProductFormPage {
    @FindBy(xpath = "//input[@id='Name']")
    WebElement productNameText;

    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
    WebElement clickSave;

    @Override
    public ProductDetailPage goToFillProduct(String productName) {
        driverTools.setInputField(productNameText, productName);
        driverTools.clickElement(clickSave);
        return new ProductDetailPageClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
