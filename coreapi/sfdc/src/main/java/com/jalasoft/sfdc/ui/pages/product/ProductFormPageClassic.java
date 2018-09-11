package com.jalasoft.sfdc.ui.pages.product;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductFormPageClassic extends ProductFormPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//input[@id='Name']")
    WebElement productNameText;

    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
    WebElement clickSave;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productNameText));
    }

    /**
     * This method perform an action of setting and create a new ProductDetailPage.
     * @param productName
     * @return a new ProductDetailPage.
     */
    @Override
    public ProductDetailPage goToFillProduct(String productName) {
        driverTools.setInputField(productNameText, productName);
        driverTools.clickElement(clickSave);
        return new ProductDetailPageClassic();
    }
}
