package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsClassic;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuClassic extends TopMenu {
    @FindBy(xpath = "//span[@id='userNavLabel']")
    WebElement profileLink;
    @FindBy(xpath = "//a[@title='Logout']")
    WebElement logOutLink;

    public TopMenuClassic() {
        sliderBtnBy = By.xpath("//li[@id=\"AllTab_Tab\"]");
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
        return new HomePageClassic();
    }

    public AllAppsPage goToAllAppsPage() {
        driverTools.clickElement(sliderBtnBy);
        return new AllAppsClassic();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}

