package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TopMenuLight extends TopMenu {
    //PageFactory of selenium.
    @FindBy(xpath = "//img[@class='icon noicon']")
    private WebElement profileOption;

    @FindBy(xpath = "//a[@class='profile-link-label']//parent::h1")
    private WebElement profileSelect;

    @FindBy(className = "slds-icon-waffle")
    private WebElement allAppBtn;

    @FindBy(xpath = "//span[@class='uiImage' and @xpath='1']")
    private WebElement profileLink;

    @FindBy(xpath = "//a[@class='profile-link-label logout uiOutputURL']")
    private WebElement logOutLink;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(allAppBtn));
    }

    @Override
    public void swithSkin() {

    }

    /**
     * This method get the profile name the current user.
     * @return the profile name.
     */
    @Override
    public String getProfileName() {
        log.info("getProfileName ----->"+profileSelect.getText().trim());
        driverTools.clickElement(profileOption);
        return profileSelect.getText().trim();
    }

    /**
     * This method do click and create the new page.
     * @return a new allAppsPage.
     */
    @Override
    public AllAppsPage goToAllAppsPage() {
        log.info("goToAllAppsPage ---> return new AllAppsPageLight");
        driverTools.clickElement(allAppBtn);
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
