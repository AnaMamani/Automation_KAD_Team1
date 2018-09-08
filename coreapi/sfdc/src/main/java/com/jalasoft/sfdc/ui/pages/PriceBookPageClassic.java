package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBookPageClassic extends PriceBookPage {
    @FindBy(xpath = "//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")
    WebElement btnBook;
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public PriceBookPage clickNewBook() {
        driverTools.clickElement(btnBook);
       return new PriceBookPageClassic();
    }
}
