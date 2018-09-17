package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsClassic;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuClassic extends TopMenu {
    //PageFactory of selenium.
    @FindBy(id = "AllTab_Tab")
    private WebElement allAppBtn;

    @FindBy(id = "userNavLabel")
    private WebElement profileLink;

    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement logOutLink;

    @FindBy(id = "userNavButton")
    WebElement profileOption;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(profileLink));
    }

    @Override
    public void swithSkin() {

    }

    /**
     * This method get the profile name the current user.
     * @return  a new LoginPage.
     */
    @Override
    public LoginPage logout() {
        driverTools.clickElement(profileLink);
        driverTools.clickElement(logOutLink);
        return new LoginPage();
    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageClassic();
    }

    /**
     * This method get the profile name the current user.
     *
     * @return the profile name.
     */
    @Override
    public String getProfileName() {
        return profileOption.getText().trim();
    }

    /**
     * This method do click and create the new page.
     * @return a new allAppsPage.
     */
    @Override
    public AllAppsPage goToAllAppsPage() {
        driverTools.clickElement(allAppBtn);
        return new AllAppsClassic();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}

