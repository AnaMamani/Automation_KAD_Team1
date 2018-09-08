package com.jalasoft.sfdc.ui.pages.profile;

import com.jalasoft.sfdc.ui.pages.PriceBookPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookPageLight extends PriceBookPage {
    @FindBy(xpath = "//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")
    WebElement newBtnBook;
    @Override
    public PriceBookPage clickNewBook() {
        driverTools.clickElement(newBtnBook);
        return new PriceBookPageLight();

    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
