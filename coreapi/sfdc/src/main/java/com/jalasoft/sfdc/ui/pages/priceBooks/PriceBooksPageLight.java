package com.jalasoft.sfdc.ui.pages.priceBooks;

import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceBooksFormPage;
import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceBooksFormPageClassic;
import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceBooksFormPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBooksPageLight extends PriceBooksPage {


    @FindBy(xpath = "//span[@class='label slds-truncate slds-text-link'][contains(text(),'Price Books')]")
    WebElement priceBooksLinks;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }


    @Override
    public PriceBooksFormPage clickPriceBookNew() {

        driverTools.clickElement(priceBooksLinks);
        return new PriceBooksFormPageLight();
    }
}
