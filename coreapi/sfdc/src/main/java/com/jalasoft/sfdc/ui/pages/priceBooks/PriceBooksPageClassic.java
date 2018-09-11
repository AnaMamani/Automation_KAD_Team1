package com.jalasoft.sfdc.ui.pages.priceBooks;

import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceBooksFormPage;
import com.jalasoft.sfdc.ui.pages.priceBooksFormPage.PriceBooksFormPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBooksPageClassic extends PriceBooksPage {

    @FindBy(xpath = "//input[@title='New']")
    WebElement priceBooksLinks;
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public PriceBooksFormPage clickPriceBookNew() {
        driverTools.clickElement(priceBooksLinks);
        return new PriceBooksFormPageClassic();
    }
    }
