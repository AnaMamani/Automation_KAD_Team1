package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuLight extends TopMenu {

    @FindBy(xpath = ".//*[@id='oneHeader']/div[3]/div/div[1]/div[1]/nav/button")

    private WebElement sliderBtn;

    public TopMenuLight() {

       //sliderBtnBy = By.xpath("//button[@class =\"bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader\"]");
       // sliderBtnBy = By.xpath(".//*[@id='oneHeader']/div[3]/div/div[1]/div[1]/nav/button");
       // sliderBtnBy = By.xpath(".//*[@id='AllTab_Tab']/a/img");

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

        driverTools.clickElement(sliderBtn);
        return new AllAppsPageLight();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}
