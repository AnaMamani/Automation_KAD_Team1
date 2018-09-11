package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsPageLight;
import com.jalasoft.sfdc.ui.pages.profile.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class TopMenuLight extends TopMenu {


    public TopMenuLight() {
        allAppBtnBy = By.xpath("//div[@class='slds-icon-waffle']");
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOf(allAppBtnBy));
    }

    @Override
    public void swithSkin() {

    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageLight();
    }

    @Override
    public ProfilePage goToProfilePage() {
        return null;
    }

    /**
     * Method for go to All Apps age
     * @return AllAppsPage
     */
    @Override
    public AllAppsPage goToAllAppsPage() {
        driverTools.clickElement(allAppBtnBy);
        return new AllAppsPageLight();
    }
    @Override
    public String getCurrentUser() {
        return null;
    }

}
