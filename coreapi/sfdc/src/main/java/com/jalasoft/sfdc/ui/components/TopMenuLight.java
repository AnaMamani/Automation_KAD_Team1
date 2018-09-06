package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPageLight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuLight extends TopMenu {

    public TopMenuLight() {

        sliderBtnBy = By.xpath("//nav[@class='appLauncher slds-context-bar__icon-action']//button[@type='button']");
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void swithSkin() {

    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageLight();
    }

    public AllAppsPage goToAllAppsPage() {
        driverTools.clickElement(sliderBtnBy);
        return new AllAppsPageLight();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}
