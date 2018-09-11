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
    @FindBy(xpath = "//li[@id=\"AllTab_Tab\"]")
    WebElement sliderBtn;

    @FindBy(xpath = "//span[@id='userNavLabel']")
    WebElement profileLink;

    @FindBy(xpath = "//a[@title='Logout']")
    WebElement logOutLink;

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
        driverTools.clickElement(sliderBtn);
        return new AllAppsClassic();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}

