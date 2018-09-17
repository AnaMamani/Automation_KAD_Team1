package com.jalasoft.sfdc.ui.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageLight extends HomePage {
    @FindBy(xpath = "//span[contains(text(),'Go Mobile')]")
    private WebElement goMobile;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(goMobile));
    }
}
