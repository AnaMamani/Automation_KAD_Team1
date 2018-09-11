package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsClassic;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.profile.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuClassic extends TopMenu {



    public TopMenuClassic() {

        allAppBtnBy = By.xpath("//img[contains(@title,'All Tabs')]");
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

        //wait.until(ExpectedConditions.visibilityOf(sliderBtnClassic));
    }

    @Override
    public void swithSkin() {

    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageClassic();
    }

    @Override
    public ProfilePage goToProfilePage() {
        driver.findElement(By.id("userNavButton")).click();
        driver.findElement(By.linkText("My Profile")).click();
        return new ProfilePageClassic();
    }
    /**
     * Method for go to All Apps age
     * @return AllAppsPage
     */
    @Override
    public AllAppsPage goToAllAppsPage() {
        driverTools.clickElement(allAppBtnBy);
        return new AllAppsClassic();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}

