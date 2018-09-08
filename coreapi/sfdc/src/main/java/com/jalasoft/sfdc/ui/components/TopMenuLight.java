package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPageLight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuLight extends TopMenu {
    @FindBy(xpath = "//span[@class=\"uiImage\" and @xpath=\"1\"]")
    WebElement profileLink;
    @FindBy(xpath = "//a[@class='profile-link-label logout uiOutputURL']")
    WebElement logOutLink;

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
    public LoginPage logout() {
        wait.until(ExpectedConditions.visibilityOf(profileLink));
        driverTools.clickElement(profileLink);
        wait.until(ExpectedConditions.visibilityOf(logOutLink));
        driverTools.clickElement(logOutLink);
        return new LoginPage();
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
