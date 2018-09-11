package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuLight extends TopMenu {
    //PageFactory of selenium.
    @FindBy(xpath = "//img[@class=\"icon noicon\"]")
    WebElement profileOption;

    @FindBy(xpath = "//a[@class=\"profile-link-label\"]//parent::h1")
    WebElement profileSelect;

    @FindBy(className = "slds-icon-waffle")
    WebElement sliderBtn;

    @FindBy(xpath = "//span[@class=\"uiImage\" and @xpath=\"1\"]")
    WebElement profileLink;

    @FindBy(xpath = "//a[@class='profile-link-label logout uiOutputURL']")
    WebElement logOutLink;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(sliderBtn));
    }

    @Override
    public void swithSkin() {

    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageLight();
    }

    /**
     * This method get the profile name the current user.
     * @return the profile name.
     */
    @Override
    public String getProfileName() {
        driverTools.clickElement(profileOption);
        return profileSelect.getText().trim();
    }

    /**
     * This method do click and create the new page.
     * @return a new AllAppsPage.
     */
    @Override
    public AllAppsPage goToAllAppsPage() {
        driverTools.clickElement(sliderBtn);
        driverTools.sleepMilliSeconds(1000);
        return new AllAppsPageLight();
    }

    @Override
    public LoginPage logout() {
        driverTools.clickElement(profileLink);
        driverTools.clickElement(logOutLink);
        return new LoginPage();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}
